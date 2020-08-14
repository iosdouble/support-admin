package com.zk.framework.weixin.accesstoken;

import com.zk.common.utils.http.HttpUtil;

import com.zk.common.utils.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WeixinConnnection
 * @Description TODO
 * @Date 2020/8/14 3:17 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WeixinConnnection @see ruoyi
 */
@Component
public class WeixinGetToken {

    private Logger logger = LoggerFactory.getLogger(WeixinGetToken.class);

    @Autowired
    private WeixinConnection weixinConnection;


    public AccessToken getToken() {

        AccessToken token = null;

//        String url = weixinConnection.getUrl() + "?grant_type=client_credential&appid=" + weixinConnection.getAppid()
//                + "&secret=" + weixinConnection.getSecret();
        System.out.println(weixinConnection.getUrl());
        Map params = new HashMap<>();
        params.put("grant_type","client_credential");
        params.put("appid",weixinConnection.getAppid());
        params.put("secret",weixinConnection.getSecret());
        String doGet = HttpUtil.doGet(weixinConnection.getUrl(),params);
        System.out.println(doGet);
        AccessToken accessToken = JsonUtil.toObject(doGet, AccessToken.class);
        System.out.println(accessToken);
        if (accessToken != null) {
            return accessToken;
        } else {
            accessToken = null;
            // 获取token失败
            logger.error("jsonObject为空，获取token失败");
        }
        return accessToken;
    }
}
