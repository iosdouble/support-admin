package com.zk.system.service.impl;

import com.zk.system.domain.WxkqUploadImageInfo;
import com.zk.system.domain.WxkqUploadImageInfoExample;
import com.zk.system.mapper.WxkqUploadImageInfoMapper;
import com.zk.system.service.IWxkqUploadImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname WxkqUploadImageInfoServiceImpl
 * @Description TODO
 * @Date 2020/8/17 4:36 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqUploadImageInfoServiceImpl @see ruoyi
 */
@Service
public class WxkqUploadImageInfoServiceImpl implements IWxkqUploadImageInfoService {

    @Autowired
    private WxkqUploadImageInfoMapper wxkqUploadImageInfoMapper;
    @Override
    public int insertUploadImageInfo() {
        return 0;
    }

    @Override
    public List<WxkqUploadImageInfo> getImageList() {
        WxkqUploadImageInfoExample wxkqUploadImageInfoExample = new WxkqUploadImageInfoExample();
        List<WxkqUploadImageInfo> wxkqUploadImageInfos = wxkqUploadImageInfoMapper.selectByExample(wxkqUploadImageInfoExample);
        return wxkqUploadImageInfos;
    }
}
