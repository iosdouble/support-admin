package com.zk.web.controller.kaquan;

import com.zk.common.annotation.Log;
import com.zk.common.constant.DateInfoTypeConstants;
import com.zk.common.constant.WXUrlConstants;
import com.zk.common.constant.WXcodeTypeConstants;
import com.zk.common.core.controller.BaseController;
import com.zk.common.core.domain.AjaxResult;
import com.zk.common.core.page.TableDataInfo;
import com.zk.common.enums.BusinessType;
import com.zk.common.utils.DateUtils;
import com.zk.common.utils.http.HttpClientUtil;
import com.zk.common.utils.idgenerator.SnowflakeIdUtils;
import com.zk.common.utils.json.JsonUtil;
import com.zk.system.domain.WxkqCardBaseInfo;
import com.zk.system.domain.po.InsertCardBaseInfoPo;
import com.zk.system.domain.po.InsertCreateCardDetailsPo;
import com.zk.system.domain.weixin.accesstoken.AccessToken;
import com.zk.system.domain.weixin.accesstoken.WeixinGetToken;
import com.zk.system.domain.weixin.domain.bean.CreateCard;
import com.zk.system.domain.weixin.domain.bean.GroupOn;
import com.zk.system.domain.weixin.domain.bean.base.BaseCodeInfo;
import com.zk.system.domain.weixin.domain.bean.entity.DateInfo;
import com.zk.system.domain.weixin.domain.bean.entity.SKU;
import com.zk.system.domain.weixin.domain.req.CardRsq;
import com.zk.system.domain.weixin.domain.req.InputCodeRsq;
import com.zk.system.domain.weixin.domain.resp.CreateCardSuccessResp;
import com.zk.system.domain.weixin.domain.vo.CreateCardVo;
import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.domain.weixin.domain.vo.InputCodeVo;
import com.zk.system.service.*;
import org.omg.PortableInterceptor.INACTIVE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Classname WxkqCreateCardController
 * @Description TODO 创建卡券相关
 * @Date 2020/8/18 6:01 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqCreateCardController @see ruoyi
 */

@RestController
@RequestMapping("/card")
public class WxkqCreateCardController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(WxkqCreateCardController.class);
    @Autowired
    private WeixinGetToken weixinGetToken;
    @Autowired
    private IWxkqCreateCardRecordService wxkqCreateCardRecordService;
    @Autowired
    private IWxkqCreateCardDetailsInfoService wxkqCreateCardDetailsInfoService;
    @Autowired
    private IWxkqCardBaseInfoService wxkqCardBaseInfoService;

    /**
     * 1、创建卡券接口
     */
    @PostMapping("/createCard")
    @Log(title = "创建卡券基本信息", businessType = BusinessType.INSERT)
    public AjaxResult createCard(@RequestBody CreateCardVo createCardVo) {
        logger.debug("create card info {}", JsonUtil.toJson(createCardVo));
        AccessToken token = weixinGetToken.getToken();
        String url = WXUrlConstants.CREATE_CARD + "?access_token=" + token.getAccess_token();
        logger.debug("api interface is { }", WXUrlConstants.CREATE_CARD);

        CreateCard createCard = new CreateCard();
        CardRsq card = new CardRsq();
        card.setCard_type("GROUPON");

        SKU sku = new SKU(createCardVo.getQuantity());
        DateInfo dateInfo = new DateInfo();
        dateInfo.setType(DateInfoTypeConstants.DATE_TYPE_FIXTIME_RANGE);
        Date startTime = DateUtils.dateTimeUTC(createCardVo.getStartTime());
        Date endTime = DateUtils.dateTimeUTC(createCardVo.getEndTime());
        dateInfo.setBegin_timestamp(Long.valueOf(DateUtils.dateToStamp(DateUtils.dateTimeUTC(createCardVo.getStartTime()))));
        dateInfo.setEnd_timestamp(Long.valueOf(DateUtils.dateToStamp(DateUtils.dateTimeUTC(createCardVo.getEndTime()))));

        BaseCodeInfo baseCodeInfo = new BaseCodeInfo();
//        baseCodeInfo.setLogo_url(createCardVo.getLogo_url());
        baseCodeInfo.setLogo_url("http://mmbiz.qpic.cn/mmbiz_png/B3zBXUpXXBX3y9ibfqWvN7NerZ86CtjT960IjMMOaiaEaNHjBPBicaGo6tMtIn0rqUJp4wuR24PjcO5WgLbNlJORQ/0");

        baseCodeInfo.setCode_type(WXcodeTypeConstants.CODE_TYPE_QRCODE);
        baseCodeInfo.setTitle(createCardVo.getTitle());
        baseCodeInfo.setBrand_name(createCardVo.getBrandName());
        baseCodeInfo.setColor(createCardVo.getColor());
        baseCodeInfo.setNotice(createCardVo.getNotice());
        baseCodeInfo.setDescription(createCardVo.getDescription());
//        baseCodeInfo.setUse_custom_code(true);
//        baseCodeInfo.setGet_custom_code_mode("GET_CUSTOM_CODE_MODE_DEPOSIT");
        baseCodeInfo.setSku(sku);
        baseCodeInfo.setDate_info(dateInfo);
        GroupOn groupOn = new GroupOn();
        groupOn.setDeal_detail(createCardVo.getCard_details());
        groupOn.setBase_info(baseCodeInfo);
        card.setGroupon(groupOn);
        createCard.setCard(card);
        logger.info("init parameter body {}", JsonUtil.toJson(createCard));



        String result = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(createCard));
        CreateCardSuccessResp createCardSuccessResp = JsonUtil.toObject(result, CreateCardSuccessResp.class);

        String insertRecord = wxkqCreateCardRecordService.insertRecord(createCardSuccessResp);

        InsertCardBaseInfoPo insertCardBaseInfoPo = new InsertCardBaseInfoPo();

        insertCardBaseInfoPo.setCard_id(insertRecord);
        insertCardBaseInfoPo.setBrand_name(createCardVo.getBrandName());
        insertCardBaseInfoPo.setCode_type(WXcodeTypeConstants.CODE_TYPE_QRCODE);
        insertCardBaseInfoPo.setTitle(createCardVo.getTitle());
        insertCardBaseInfoPo.setQuantity(createCardVo.getQuantity());
        insertCardBaseInfoPo.setUse_custom_code(false);
        insertCardBaseInfoPo.setBegin_time_stamp(startTime);
        insertCardBaseInfoPo.setEnd_time_stamp(endTime);
        insertCardBaseInfoPo.setUrser_name("system");

        Long aLong = wxkqCardBaseInfoService.insertCardBaseInfo(insertCardBaseInfoPo);

        InsertCreateCardDetailsPo insertCreateCardDetailsPo = new InsertCreateCardDetailsPo();
        insertCreateCardDetailsPo.setCreateBy("system");
        insertCreateCardDetailsPo.setCardType(card.getCard_type());
        insertCreateCardDetailsPo.setDetail(JsonUtil.toJson(createCard));
        insertCreateCardDetailsPo.setOptionId(aLong);

        wxkqCreateCardDetailsInfoService.insertCreateCardDetails(insertCreateCardDetailsPo);

        return AjaxResult.success("OK");
    }

    @GetMapping("/list")
    @Log(title = "获取卡券详情列表", businessType = BusinessType.INSERT)
    public TableDataInfo getCreateCardInfoList() {
        startPage();
        List<WxkqCardBaseInfo> wxkqCardBaseInfos = wxkqCardBaseInfoService.getAllInfo();
        return getDataTable(wxkqCardBaseInfos);
    }


    /**
     * 导入Code
     * @param card_id
     * @return
     */
    @GetMapping("/inputCode")
    public AjaxResult inputCardCode(@RequestParam("card_id") String card_id){
        AccessToken token = weixinGetToken.getToken();
        String url = WXUrlConstants.INPUT_CARD_CODE+"?access_token=" + token.getAccess_token();
        InputCodeRsq inputCode = new InputCodeRsq();
        inputCode.setCard_id(card_id);
        int count = 100;
        List<String> codes = new ArrayList<>();
        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1, 1);
        for (int i = 0; i < count; i++) {
            long l = snowflakeIdUtils.nextId();
            codes.add(String.valueOf(l));
        }
        inputCode.setCode(codes);
        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(inputCode));
        System.out.println(s);
        return AjaxResult.success("OK");
    }


    /**
     * 更新卡券
     * @return
     */

    @GetMapping("/updateCard")
    public String updateCard(){
        return null;
    }

    /**
     * 更新库存
     * @return
     */
    @GetMapping("/updateQuantity")
    public String updateQuantity(){
        return null;
    }
}
