<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:info:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:info:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:info:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:info:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="编号" align="center" prop="id"/>
      <el-table-column label="卡券类型" align="center" prop="cardType"/>
      <el-table-column label="是否自定义Code" align="center" prop="useCustomCode"/>
      <el-table-column label="错误码" align="center" prop="errcode"/>
      <el-table-column label="错误信息" align="center" prop="errmsg"/>
      <el-table-column label="卡券ID" align="center" prop="cardId"/>
      <el-table-column label="创建人" align="center" prop="createBy"/>
      <el-table-column label="创建时间" align="center" prop="createTime"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:info:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleLaunch(scope.row)"
            v-hasPermi="['system:info:remove']"
          >投放
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:info:remove']"
          >删除
          </el-button>

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

    <el-dialog :title="title" :visible.sync="open" width="60%" append-to-body>

      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="商家Logo">
          <el-input v-model="form.logo_url"></el-input>
        </el-form-item>
        <el-form-item label="卡券标题">
          <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="商家名称">
          <el-input v-model="form.brandName"></el-input>
        </el-form-item>
        <el-form-item label="颜色">
          <el-input v-model="form.color"></el-input>
        </el-form-item>
        <el-form-item label="使用提醒">
          <el-input v-model="form.notice"></el-input>
        </el-form-item>
        <el-form-item label="使用说明">
          <el-input v-model="form.description"></el-input>
        </el-form-item>
        <el-form-item label="卡券说明">
          <el-input v-model="form.card_details"></el-input>
        </el-form-item>
        <el-form-item label="卡券类型">
          <el-select v-model="form.cardType" placeholder="请选择卡券类型">
            <el-option label="二维码" value="1"></el-option>
            <el-option label="一维码" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="时间类型">
          <el-select v-model="form.dateType" placeholder="请选择活动区域">
            <el-option label="固定日期" value="1"></el-option>
            <el-option label="固定时长" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="开始时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.sday" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间" v-model="form.stime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="结束时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.eday" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker placeholder="选择时间" v-model="form.etime" style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>

        <el-form-item label="初始容量">
          <el-input v-model="form.quantity"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm">立即创建</el-button>
          <el-button @click="cancel">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
    import {
        listInfo,
        getInfo,
        delInfo,
        addInfo,
        updateInfo,
        exportInfo,
        createCard,
        getInfoList,
        getLaunch
    } from "@/api/kaqu/info";

    export default {
        name: "Info",
        data() {
            return {
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
                // 微信卡券基础信息必填信息 表格数据
                infoList: [],
                // 弹出层标题
                title: "",
                // 是否显示弹出层
                open: false,
                // 查询参数
                queryParams: {
                    pageNum: 1,
                    pageSize: 10,
                    logoUrl: null,
                    codeType: null,
                    brandName: null,
                    title: null,
                    color: null,
                    notice: null,
                    description: null,
                    quantity: null,
                    type: null,
                    beginTimeStamp: null,
                    endTimeStamp: null,
                    fixedTerm: null,
                    fixedBeginTerm: null
                },
                // 表单参数
                form: {},
                // 表单校验
                rules: {}
            };
        },
        created() {
            this.getList();
        },
        methods: {
            /** 查询微信卡券基础信息必填信息 列表 */
            getList() {
                this.loading = true;
                getInfoList().then(response => {
                    this.infoList = response.rows;
                    console.log(response.rows)
                    this.total = response.total;
                    this.loading = false;
                });
            },
            // 取消按钮
            cancel() {
                this.open = false;
                this.reset();
            },
            // 表单重置
            reset() {
                this.form = {
                    id: null,
                    logoUrl: null,
                    codeType: null,
                    brandName: null,
                    title: null,
                    color: null,
                    notice: null,
                    description: null,
                    quantity: null,
                    type: null,
                    beginTimeStamp: null,
                    endTimeStamp: null,
                    fixedTerm: null,
                    fixedBeginTerm: null
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
                this.resetForm("queryForm");
                this.handleQuery();
            },
            // 多选框选中数据
            handleSelectionChange(selection) {
                this.ids = selection.map(item => item.id)
                this.single = selection.length !== 1
                this.multiple = !selection.length
            },
            /** 新增按钮操作 */
            handleAdd() {
                this.reset();
                this.open = true;
                this.title = "选择所要创建的卡券";
            },
            /** 修改按钮操作 */
            handleUpdate(row) {
                this.reset();
                const id = row.id || this.ids
                getInfo(id).then(response => {
                    this.form = response.data;
                    this.open = true;
                    this.title = "修改微信卡券基础信息必填信息 ";
                });
            },
            /** 提交按钮 */
            submitForm() {
                this.$refs["form"].validate(valid => {
                    createCard(this.form).then(response => {
                        console.log(response)
                        this.open = false;
                        this.getList();
                    });
                })
            },
            /** 删除按钮操作 */
            handleDelete(row) {
                const ids = row.id || this.ids;
                this.$confirm('是否确认删除微信卡券基础信息必填信息 编号为"' + ids + '"的数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function () {
                    return delInfo(ids);
                }).then(() => {
                    this.getList();
                    this.msgSuccess("删除成功");
                }).catch(function () {
                });
            },
            /** 投放 **/
            handleLaunch(row) {
                const ids = row.cardId ;
                this.$confirm('是否确认投放微信卡券基础信息必填信息 编号为"' + ids + '"的数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function () {
                    return getLaunch(ids);
                }).then(() => {
                    this.getList();
                    this.msgSuccess("投放成功");
                }).catch(function () {
                });
            },
            /** 导出按钮操作 */
            handleExport() {
                const queryParams = this.queryParams;
                this.$confirm('是否确认导出所有微信卡券基础信息必填信息 数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function () {
                    return exportInfo(queryParams);
                }).then(response => {
                    this.download(response.msg);
                }).catch(function () {
                });
            }
        }
    };
</script>
