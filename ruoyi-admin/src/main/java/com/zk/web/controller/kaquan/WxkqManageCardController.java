package com.zk.web.controller.kaquan;

import com.alibaba.fastjson.JSONObject;
import com.zk.common.constant.WXUrlConstants;
import com.zk.common.core.controller.BaseController;
import com.zk.common.utils.http.HttpClientUtil;
import com.zk.common.utils.idgenerator.SnowflakeIdUtils;
import com.zk.common.utils.json.JsonUtil;
import com.zk.system.domain.WxkqGetCardStatusRecord;
import com.zk.system.domain.weixin.accesstoken.AccessToken;
import com.zk.system.domain.weixin.accesstoken.WeixinGetToken;
import com.zk.system.domain.weixin.domain.req.GetCardReq;
import com.zk.system.domain.weixin.domain.resp.GetCardDetailSuccessResp;
import com.zk.system.service.IWxkqCreateCardRecordService;
import com.zk.system.service.IWxkqGetCardStatusRecordService;
import com.zk.system.service.IWxkqLaunchCardRecordService;
import com.zk.system.service.IWxkqUploadImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname WxkqManageCardController
 * @Description TODO 管理卡券
 * @Date 2020/8/18 6:27 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqManageCardController @see ruoyi
 */
@RestController
public class WxkqManageCardController extends BaseController {


    @Autowired
    private WeixinGetToken weixinGetToken;

    @Autowired
    private IWxkqGetCardStatusRecordService wxkqGetCardStatusRecordService;


    /**
     * 1 查询Code接口
     * <p>
     * 2 获取用户已领取卡券接口
     * <p>
     * 3 查看卡券详情
     * <p>
     * 4 删除卡券接口
     * <p>
     * 5 设置卡券失效接口
     */

    /**
     * 1 查询Code状态
     * @return
     */
    @GetMapping("/getCardStatus")
    public String getCardDetailsInfo() {
        AccessToken token = weixinGetToken.getToken();
        String url = WXUrlConstants.QUEUE_CARD_STATUS + "?access_token=" + token.getAccess_token();


        GetCardReq getCardReq = new GetCardReq();
        getCardReq.setCard_id("pWHBzs9bUHwU56R8idTgwyV62gXM");
        getCardReq.setCode("744236683645554688");
        getCardReq.setCheck_consume(false);

        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(getCardReq));
        System.out.println(s);

        GetCardDetailSuccessResp getCardDetailSuccessResp = JsonUtil.toObject(s, GetCardDetailSuccessResp.class);

        WxkqGetCardStatusRecord wxkqGetCardStatusRecord = new WxkqGetCardStatusRecord();
        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1, 1);
        wxkqGetCardStatusRecord.setId(snowflakeIdUtils.nextId());
        wxkqGetCardStatusRecord.setErrcode(getCardDetailSuccessResp.getErrcode());
        wxkqGetCardStatusRecord.setErrmsg(getCardDetailSuccessResp.getErrmsg());
        wxkqGetCardStatusRecord.setCardId(getCardDetailSuccessResp.getCard().getCard_id());
        wxkqGetCardStatusRecord.setBeginTime(String.valueOf(getCardDetailSuccessResp.getCard().getBegin_time()));
        wxkqGetCardStatusRecord.setEndTime(String.valueOf(getCardDetailSuccessResp.getCard().getEnd_time()));
        wxkqGetCardStatusRecord.setCode(Long.valueOf(getCardDetailSuccessResp.getCard().getCode()));
        wxkqGetCardStatusRecord.setOpenid(getCardDetailSuccessResp.getOpenid());
        if (getCardDetailSuccessResp.getCan_consume()) {
            wxkqGetCardStatusRecord.setCanConsume(1);
        } else {
            wxkqGetCardStatusRecord.setCanConsume(0);
        }
        wxkqGetCardStatusRecord.setUserCardStatus(1);
        wxkqGetCardStatusRecord.setOuterStr(getCardDetailSuccessResp.getOuter_str());
        wxkqGetCardStatusRecord.setUnionid(getCardDetailSuccessResp.getUnionid());
        wxkqGetCardStatusRecordService.insertCardStatusRecord(wxkqGetCardStatusRecord);

        return "OK";
    }


    /**
     * 查询卡券详情
     *
     * https://api.weixin.qq.com/card/get?access_token=TOKEN
     * @return
     */
    @GetMapping("/getCardDetails")
    public String getCardDetails(@RequestParam(value = "card_id") String card_id){
        AccessToken token = weixinGetToken.getToken();
        String url =  "https://api.weixin.qq.com/card/get" + "?access_token=" + token.getAccess_token();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("card_id",card_id);
        String s = HttpClientUtil.sendPostJsonBody(url, jsonObject.toJSONString());
        System.out.println(s);

        return null;
    }



}
