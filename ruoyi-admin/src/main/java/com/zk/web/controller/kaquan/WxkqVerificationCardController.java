package com.zk.web.controller.kaquan;

import com.zk.common.core.controller.BaseController;
import com.zk.common.core.domain.AjaxResult;
import com.zk.common.utils.http.HttpClientUtil;
import com.zk.common.utils.json.JsonUtil;
import com.zk.system.domain.weixin.accesstoken.AccessToken;
import com.zk.system.domain.weixin.accesstoken.WeixinGetToken;
import com.zk.system.domain.weixin.domain.req.ConsumeCardReq;
import com.zk.system.domain.weixin.domain.req.GetCardReq;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname WxkqVerificationCardController
 * @Description TODO 微信卡券核销功能
 * @Date 2020/8/18 6:28 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqVerificationCardController @see ruoyi
 */
@RestController
public class WxkqVerificationCardController extends BaseController {

    @Autowired
    private WeixinGetToken weixinGetToken;

    /**
     * 检查卡券是否可用
     * @return
     */
    @PostMapping("/checkCard")
    public AjaxResult checkCardIsUseable(){

        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/card/code/get?access_token=" + token.getAccess_token();


        GetCardReq getCardReq = new GetCardReq();
        getCardReq.setCard_id("pWHBzs9bUHwU56R8idTgwyV62gXM");
        getCardReq.setCode("744236683645554688");
        getCardReq.setCheck_consume(true);

        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(getCardReq));
        System.out.println(s);
        return AjaxResult.success("OK");
    }

    /**
     * 微信卡券核销详情接口
     */
    @PostMapping("/consumeCard")
    public AjaxResult consumeCardDetailList(){
        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/card/code/consume?access_token=" + token.getAccess_token();

        ConsumeCardReq consumeCardReq = new ConsumeCardReq();
        consumeCardReq.setCard_id("pWHBzs9bUHwU56R8idTgwyV62gXM");
        consumeCardReq.setCode("744236683645554721");

        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(consumeCardReq));
        System.out.println(s);
        return AjaxResult.success("OK");
    }

}
