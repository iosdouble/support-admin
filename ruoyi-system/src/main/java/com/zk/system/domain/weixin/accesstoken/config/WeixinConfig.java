package com.zk.system.domain.weixin.accesstoken.config;

import com.zk.system.domain.weixin.accesstoken.WeixinConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname WeixinConfig
 * @Description TODO
 * @Date 2020/8/14 3:12 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WeixinConfig @see ruoyi
 */
@Configuration
public class WeixinConfig {

    @Autowired
    private WeixinProperties weixinProperties;


    @Bean
    public WeixinConnection getWeixinConnection(){
        WeixinConnection weixinConnection = new WeixinConnection();
        weixinConnection.setUrl(weixinProperties.getUrl());
        weixinConnection.setAppid(weixinProperties.getAppid());
        weixinConnection.setSecret(weixinProperties.getSecret());
        return weixinConnection;
    }
}
