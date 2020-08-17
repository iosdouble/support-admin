<template>

  <div class="app-container">
    <el-upload
      class="upload-demo"
      ref="upload"
      action="/dev-api/kaqu/upload"
      :on-preview="handlePreview"
      :on-remove="handleRemove"
      :before-upload="beforeUpload"
      :file-list="fileList"
      :auto-upload="false">
      <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
      <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
    </el-upload>
  </div>

</template>

<script>
    import { uploadFile } from "@/api/kaqu/upload";
    export default {
        name: "index",
        data() {
            return {
                uploadUrl:"api/url/url",
                fileList: []
            };
        },
        created() {
            this.getUploadUrl()
        },
        methods: {

            submitUpload() {
                this.$refs.upload.submit();
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file);
            },// 上传文件
            beforeUpload(file) {
                const fd = new FormData()
                fd.append('file', file)// 传文件
                uploadFile(fd).then(response => {
                    this.$message({
                        type: 'success',
                        message: '上传成功'
                    })
                }).catch(err => {
                    console.log(err)
                    this.$message({
                        type: 'error',
                        message: '上传失败'
                    })
                })
            },
            getUploadUrl(){
                this.uploadUrl = "http://localhost:8080"
            }
        }
    }
</script>

<style scoped>

</style>
