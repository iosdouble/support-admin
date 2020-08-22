<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" :inline="true">
      <el-form-item label="新闻标题" prop="roleName">
        <el-input
          v-model="queryParams.roleName"
          placeholder="请输入新闻标题"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker
          v-model="dateRange"
          size="small"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>


    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:role:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:role:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:role:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:role:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" prop="newId" width="180" />
      <el-table-column label="信息名称" prop="newTitle" :show-overflow-tooltip="true" width="150" />
      <el-table-column label="添加时间" prop="applyDateTime" width="200" />
      <el-table-column label="发布机构" prop="deptName" width="100" />
      <el-table-column label="状态" prop="status" width="100">
        <template slot-scope="{row}">
          <el-tag :type="row.status | statusFilter">
            {{ row.status==0 ? '正常' :(row.status==1 ? '进行中':'未完成') }}
            <!--            {{  }}-->
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="创建时间"  prop="createTime" width="180"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:role:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-circle-check"
            @click="handleDataScope(scope.row)"
            v-hasPermi="['system:role:edit']"
          >数据权限</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:role:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改角色配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="80%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="新闻标题">
          <el-input v-model="content.title"  />
        </el-form-item>
        <!--富文本编辑器-->
        <el-form-item label-width="0" >
          <quill-editor class="ql-editor" v-model="content.value" ref="myQuillEditor" :options="editorOption" @change="onEditorChange($event)">
          </quill-editor>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 分配角色数据权限对话框 -->
    <el-dialog :title="title" :visible.sync="openDataScope" width="500px" append-to-body>
      <el-form :model="form" label-width="80px">
        <el-form-item label="角色名称">
          <el-input v-model="form.roleName" :disabled="true" />
        </el-form-item>
        <el-form-item label="权限字符">
          <el-input v-model="form.roleKey" :disabled="true" />
        </el-form-item>
        <el-form-item label="权限范围">
          <el-select v-model="form.dataScope">
            <el-option
              v-for="item in dataScopeOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="数据权限" v-show="form.dataScope == 2">
          <el-tree
            :data="deptOptions"
            show-checkbox
            default-expand-all
            ref="dept"
            node-key="id"
            empty-text="加载中，请稍后"
            :props="defaultProps"
          ></el-tree>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitDataScope">确 定</el-button>
        <el-button @click="cancelDataScope">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
    import { listRole, getRole, delRole, addRole, updateRole, exportRole, dataScope, changeRoleStatus } from "@/api/system/role";
    import { treeselect as menuTreeselect, roleMenuTreeselect } from "@/api/system/menu";
    import { treeselect as deptTreeselect, roleDeptTreeselect } from "@/api/system/dept";

    import { createNews,listNews } from "@/api/news/createnews"



    export default {
        name: "Role",
        filters: {
            statusFilter(status) {
                const statusMap = {
                    0: 'success',
                    1: 'info',
                    2: 'danger'
                }
                return statusMap[status]
            }
        },
        data() {
            return {
                statusOptions: [{
                    key: '进行中',
                    value: '1'
                }, {
                    key: '已完成',
                    value: '2'
                }, {
                    key: '未完成',
                    value: '0'
                }],
                content:{
                  title:"",
                  value:""
                },
                value:'',

                editorOption: {
                    placeholder: '编辑新闻内容',
                    theme: 'snow',
                    modules: {}
                },
                // 遮罩层
                loading: true,
                // 选中数组
                ids: [],
                // 非单个禁用
                single: true,
                // 非多个禁用
                multiple: true,
                // 显示搜索条件
                showSearch: true,
                // 总条数
                total: 0,
                // 角色表格数据
                roleList: [],
                // 弹出层标题
                title: "",
                // 是否显示弹出层
                open: false,
                // 是否显示弹出层（数据权限）
                openDataScope: false,
                // 日期范围
                dateRange: [],
                // 状态数据字典
                statusOptions: [],
                // 数据范围选项
                dataScopeOptions: [
                    {
                        value: "1",
                        label: "全部数据权限"
                    },
                    {
                        value: "2",
                        label: "自定数据权限"
                    },
                    {
                        value: "3",
                        label: "本部门数据权限"
                    },
                    {
                        value: "4",
                        label: "本部门及以下数据权限"
                    },
                    {
                        value: "5",
                        label: "仅本人数据权限"
                    }
                ],
                // 菜单列表
                menuOptions: [],
                // 部门列表
                deptOptions: [],
                // 查询参数
                queryParams: {
                    pageNum: 1,
                    pageSize: 10,
                    roleName: undefined,
                    roleKey: undefined,
                    status: undefined
                },
                // 表单参数
                form: {},
                defaultProps: {
                    children: "children",
                    label: "label"
                },
                // 表单校验
                rules: {
                    roleName: [
                        { required: true, message: "角色名称不能为空", trigger: "blur" }
                    ],
                    roleKey: [
                        { required: true, message: "权限字符不能为空", trigger: "blur" }
                    ],
                    roleSort: [
                        { required: true, message: "角色顺序不能为空", trigger: "blur" }
                    ]
                }
            };
        },
        created() {
            this.getList();
        },
        methods: {
            /** 查询角色列表 */
            getList() {
                this.loading = true;
                listNews().then(response => {
                        this.roleList = response.rows;
                        this.total = response.total;
                        this.loading = false;
                    }
                );
            },
            /** 查询菜单树结构 */
            getMenuTreeselect() {
                menuTreeselect().then(response => {
                    this.menuOptions = response.data;
                });
            },
            /** 查询部门树结构 */
            getDeptTreeselect() {
                deptTreeselect().then(response => {
                    this.deptOptions = response.data;
                });
            },
            // 所有菜单节点数据
            getMenuAllCheckedKeys() {
                // 目前被选中的菜单节点
                let checkedKeys = this.$refs.menu.getHalfCheckedKeys();
                // 半选中的菜单节点
                let halfCheckedKeys = this.$refs.menu.getCheckedKeys();
                checkedKeys.unshift.apply(checkedKeys, halfCheckedKeys);
                return checkedKeys;
            },
            // 所有部门节点数据
            getDeptAllCheckedKeys() {
                // 目前被选中的部门节点
                let checkedKeys = this.$refs.dept.getHalfCheckedKeys();
                // 半选中的部门节点
                let halfCheckedKeys = this.$refs.dept.getCheckedKeys();
                checkedKeys.unshift.apply(checkedKeys, halfCheckedKeys);
                return checkedKeys;
            },
            /** 根据角色ID查询菜单树结构 */
            getRoleMenuTreeselect(roleId) {
                return roleMenuTreeselect(roleId).then(response => {
                    this.menuOptions = response.menus;
                    return response;
                });
            },
            /** 根据角色ID查询部门树结构 */
            getRoleDeptTreeselect(roleId) {
                return roleDeptTreeselect(roleId).then(response => {
                    this.deptOptions = response.depts;
                    return response;
                });
            },
            // 角色状态修改
            handleStatusChange(row) {
                let text = row.status === "0" ? "启用" : "停用";
                this.$confirm('确认要"' + text + '""' + row.roleName + '"角色吗?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function() {
                    return changeRoleStatus(row.roleId, row.status);
                }).then(() => {
                    this.msgSuccess(text + "成功");
                }).catch(function() {
                    row.status = row.status === "0" ? "1" : "0";
                });
            },
            // 取消按钮
            cancel() {
                this.open = false;
                this.reset();
            },
            // 取消按钮（数据权限）
            cancelDataScope() {
                this.openDataScope = false;
                this.reset();
            },
            // 表单重置
            reset() {
                if (this.$refs.menu != undefined) {
                    this.$refs.menu.setCheckedKeys([]);
                }
                this.form = {
                    roleId: undefined,
                    roleName: undefined,
                    roleKey: undefined,
                    roleSort: 0,
                    status: "0",
                    menuIds: [],
                    deptIds: [],
                    remark: undefined
                };
                this.resetForm("form");
            },
            /** 搜索按钮操作 */
            handleQuery() {
                this.queryParams.pageNum = 1;
                this.getList();
            },
            /** 重置按钮操作 */
            resetQuery() {
                this.dateRange = [];
                this.resetForm("queryForm");
                this.handleQuery();
            },
            // 多选框选中数据
            handleSelectionChange(selection) {
                this.ids = selection.map(item => item.roleId)
                this.single = selection.length!=1
                this.multiple = !selection.length
            },
            /** 新增按钮操作 */
            handleAdd() {
                this.reset();
                this.getMenuTreeselect();
                this.open = true;
                this.title = "编辑新闻内容";
            },
            /** 修改按钮操作 */
            handleUpdate(row) {
                this.reset();
                const roleId = row.roleId || this.ids
                const roleMenu = this.getRoleMenuTreeselect(roleId);
                getRole(roleId).then(response => {
                    this.form = response.data;
                    this.open = true;
                    this.$nextTick(() => {
                        roleMenu.then(res => {
                            this.$refs.menu.setCheckedKeys(res.checkedKeys);
                        });
                    });
                    this.title = "修改角色";
                });
            },
            /** 分配数据权限操作 */
            handleDataScope(row) {
                this.reset();
                const roleDeptTreeselect = this.getRoleDeptTreeselect(row.roleId);
                getRole(row.roleId).then(response => {
                    this.form = response.data;
                    this.openDataScope = true;
                    this.$nextTick(() => {
                        roleDeptTreeselect.then(res => {
                            this.$refs.dept.setCheckedKeys(res.checkedKeys);
                        });
                    });
                    this.title = "分配数据权限";
                });
            },
            /** 提交按钮 */
            submitForm: function() {
                this.$refs["form"].validate(valid => {
                    console.log(this.content)
                    createNews(this.content).then(res=>{
                        console.log(res)
                    })
                });
            },
            /** 提交按钮（数据权限） */
            submitDataScope: function() {
                if (this.form.roleId != undefined) {
                    this.form.deptIds = this.getDeptAllCheckedKeys();
                    dataScope(this.form).then(response => {
                        if (response.code === 200) {
                            this.msgSuccess("修改成功");
                            this.openDataScope = false;
                            this.getList();
                        }
                    });
                }
            },
            /** 删除按钮操作 */
            handleDelete(row) {
                const roleIds = row.roleId || this.ids;
                this.$confirm('是否确认删除角色编号为"' + roleIds + '"的数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function() {
                    return delRole(roleIds);
                }).then(() => {
                    this.getList();
                    this.msgSuccess("删除成功");
                }).catch(function() {});
            },
            /** 导出按钮操作 */
            handleExport() {
                const queryParams = this.queryParams;
                this.$confirm('是否确认导出所有角色数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function() {
                    return exportRole(queryParams);
                }).then(response => {
                    this.download(response.msg);
                }).catch(function() {});
            },
            onEditorChange(){

            }

        }
    };
</script>

<style>
  .edit_container {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  .ql-editor{
    height:400px;
  }
</style>
