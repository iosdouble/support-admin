package com.zk.system.service;

import com.zk.system.domain.WxkqUploadImageInfo;
import com.zk.system.domain.weixin.domain.vo.UploadImageVo;

import java.util.List;

/**
 * @Classname IWxkqUploadImageInfoService
 * @Description TODO
 * @Date 2020/8/17 4:36 PM
 * @Created by nihui
 * @Version 1.0
 * @Description IWxkqUploadImageInfoService @see ruoyi
 */
public interface IWxkqUploadImageInfoService {

    public int insertUploadImageInfo();

    public List<WxkqUploadImageInfo> getImageList();
}
