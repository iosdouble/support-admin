<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="卡券商户Logo" prop="logoUrl">
        <el-input
          v-model="queryParams.logoUrl"
          placeholder="请输入卡券商户Logo"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="码型" prop="codeType">
        <el-select v-model="queryParams.codeType" placeholder="请选择码型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="商户名" prop="brandName">
        <el-input
          v-model="queryParams.brandName"
          placeholder="请输入商户名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="卡券名" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入卡券名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="卡券颜色" prop="color">
        <el-input
          v-model="queryParams.color"
          placeholder="请输入卡券颜色"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="卡券使用提醒" prop="notice">
        <el-input
          v-model="queryParams.notice"
          placeholder="请输入卡券使用提醒"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="卡券适用说明" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入卡券适用说明"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="卡券库存数量" prop="quantity">
        <el-input
          v-model="queryParams.quantity"
          placeholder="请输入卡券库存数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用时间类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择使用时间类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="开始时间" prop="beginTimeStamp">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.beginTimeStamp"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间" prop="endTimeStamp">
        <el-date-picker clearable size="small" style="width: 200px"
                        v-model="queryParams.endTimeStamp"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="领取多少时间有效" prop="fixedTerm">
        <el-input
          v-model="queryParams.fixedTerm"
          placeholder="请输入领取多少时间有效"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="领取多少天开始生效" prop="fixedBeginTerm">
        <el-input
          v-model="queryParams.fixedBeginTerm"
          placeholder="请输入领取多少天开始生效"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:info:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="卡券商户Logo" align="center" prop="logoUrl" />
      <el-table-column label="码型" align="center" prop="codeType" />
      <el-table-column label="商户名" align="center" prop="brandName" />
      <el-table-column label="卡券名" align="center" prop="title" />
      <el-table-column label="卡券颜色" align="center" prop="color" />
      <el-table-column label="卡券使用提醒" align="center" prop="notice" />
      <el-table-column label="卡券适用说明" align="center" prop="description" />
      <el-table-column label="卡券库存数量" align="center" prop="quantity" />
      <el-table-column label="使用时间类型" align="center" prop="type" />
      <el-table-column label="开始时间" align="center" prop="beginTimeStamp" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.beginTimeStamp, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" align="center" prop="endTimeStamp" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTimeStamp, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="领取多少时间有效" align="center" prop="fixedTerm" />
      <el-table-column label="领取多少天开始生效" align="center" prop="fixedBeginTerm" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:info:remove']"
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

    <!-- 添加或修改微信卡券基础信息必填信息 对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="卡券商户Logo" prop="logoUrl">
          <el-input v-model="form.logoUrl" placeholder="请输入卡券商户Logo" />
        </el-form-item>
        <el-form-item label="码型">
          <el-select v-model="form.codeType" placeholder="请选择码型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="商户名" prop="brandName">
          <el-input v-model="form.brandName" placeholder="请输入商户名" />
        </el-form-item>
        <el-form-item label="卡券名" prop="title">
          <el-input v-model="form.title" placeholder="请输入卡券名" />
        </el-form-item>
        <el-form-item label="卡券颜色" prop="color">
          <el-input v-model="form.color" placeholder="请输入卡券颜色" />
        </el-form-item>
        <el-form-item label="卡券使用提醒" prop="notice">
          <el-input v-model="form.notice" placeholder="请输入卡券使用提醒" />
        </el-form-item>
        <el-form-item label="卡券适用说明" prop="description">
          <el-input v-model="form.description" placeholder="请输入卡券适用说明" />
        </el-form-item>
        <el-form-item label="卡券库存数量" prop="quantity">
          <el-input v-model="form.quantity" placeholder="请输入卡券库存数量" />
        </el-form-item>
        <el-form-item label="使用时间类型">
          <el-select v-model="form.type" placeholder="请选择使用时间类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="开始时间" prop="beginTimeStamp">
          <el-date-picker clearable size="small" style="width: 200px"
                          v-model="form.beginTimeStamp"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="endTimeStamp">
          <el-date-picker clearable size="small" style="width: 200px"
                          v-model="form.endTimeStamp"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="领取多少时间有效" prop="fixedTerm">
          <el-input v-model="form.fixedTerm" placeholder="请输入领取多少时间有效" />
        </el-form-item>
        <el-form-item label="领取多少天开始生效" prop="fixedBeginTerm">
          <el-input v-model="form.fixedBeginTerm" placeholder="请输入领取多少天开始生效" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
    import { listInfo, getInfo, delInfo, addInfo, updateInfo, exportInfo } from "@/api/system/info";

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
                rules: {
                }
            };
        },
        created() {
            this.getList();
        },
        methods: {
            /** 查询微信卡券基础信息必填信息 列表 */
            getList() {
                this.loading = true;
                listInfo(this.queryParams).then(response => {
                    this.infoList = response.rows;
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
                this.single = selection.length!==1
                this.multiple = !selection.length
            },
            /** 新增按钮操作 */
            handleAdd() {
                this.reset();
                this.open = true;
                this.title = "添加微信卡券基础信息必填信息 ";
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
                    if (valid) {
                        if (this.form.id != null) {
                            updateInfo(this.form).then(response => {
                                if (response.code === 200) {
                                    this.msgSuccess("修改成功");
                                    this.open = false;
                                    this.getList();
                                }
                            });
                        } else {
                            addInfo(this.form).then(response => {
                                if (response.code === 200) {
                                    this.msgSuccess("新增成功");
                                    this.open = false;
                                    this.getList();
                                }
                            });
                        }
                    }
                });
            },
            /** 删除按钮操作 */
            handleDelete(row) {
                const ids = row.id || this.ids;
                this.$confirm('是否确认删除微信卡券基础信息必填信息 编号为"' + ids + '"的数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function() {
                    return delInfo(ids);
                }).then(() => {
                    this.getList();
                    this.msgSuccess("删除成功");
                }).catch(function() {});
            },
            /** 导出按钮操作 */
            handleExport() {
                const queryParams = this.queryParams;
                this.$confirm('是否确认导出所有微信卡券基础信息必填信息 数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function() {
                    return exportInfo(queryParams);
                }).then(response => {
                    this.download(response.msg);
                }).catch(function() {});
            }
        }
    };
</script>
