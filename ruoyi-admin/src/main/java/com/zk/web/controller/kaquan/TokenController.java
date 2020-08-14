package com.zk.web.controller.kaquan;

import com.zk.framework.weixin.Card;
import com.zk.framework.weixin.accesstoken.WeixinGetToken;
import com.zk.framework.weixin.domain.AdvancedCodeInfo;
import com.zk.framework.weixin.domain.CodeInfo;
import com.zk.framework.weixin.domain.GroupOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @Classname TokenController
 * @Description TODO
 * @Date 2020/8/14 3:43 PM
 * @Created by nihui
 * @Version 1.0
 * @Description TokenController @see ruoyi
 */
@RestController
public class TokenController {

    @Autowired
    private WeixinGetToken weixinGetToken;

    @GetMapping("/getToken")
    public Card getToke(){

       return new Card();
    }
}
