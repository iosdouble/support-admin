package com.zk.system.domain.weixin.domain.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Classname UploadImageVo
 * @Description TODO
 * @Date 2020/8/19 8:43 AM
 * @Created by nihui
 * @Version 1.0
 * @Description UploadImageVo @see ruoyi
 */
public class UploadImageVo {

    private String imageUse;
    private String imageBusiness;
    private String remark;
    private MultipartFile file;

    public UploadImageVo() {
    }

    public UploadImageVo(String imageUse, String imageBusiness, String remark, MultipartFile file) {
        this.imageUse = imageUse;
        this.imageBusiness = imageBusiness;
        this.remark = remark;
        this.file = file;
    }

    public String getImageUse() {
        return imageUse;
    }

    public void setImageUse(String imageUse) {
        this.imageUse = imageUse;
    }

    public String getImageBusiness() {
        return imageBusiness;
    }

    public void setImageBusiness(String imageBusiness) {
        this.imageBusiness = imageBusiness;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
