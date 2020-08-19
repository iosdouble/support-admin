package com.zk.web.controller.kaquan;

import com.zk.common.annotation.Log;
import com.zk.common.constant.WXUrlConstants;
import com.zk.common.constant.WXcodeTypeConstants;
import com.zk.common.core.controller.BaseController;
import com.zk.common.core.domain.AjaxResult;
import com.zk.common.core.page.TableDataInfo;
import com.zk.common.enums.BusinessType;
import com.zk.common.utils.DateUtils;
import com.zk.common.utils.http.HttpClientUtil;
import com.zk.common.utils.json.JsonUtil;
import com.zk.system.domain.po.InsertCreateCardDetailsPo;
import com.zk.system.domain.weixin.accesstoken.AccessToken;
import com.zk.system.domain.weixin.accesstoken.WeixinGetToken;
import com.zk.system.domain.weixin.domain.bean.CreateCard;
import com.zk.system.domain.weixin.domain.bean.GroupOn;
import com.zk.system.domain.weixin.domain.bean.base.BaseCodeInfo;
import com.zk.system.domain.weixin.domain.bean.entity.DateInfo;
import com.zk.system.domain.weixin.domain.bean.entity.SKU;
import com.zk.system.domain.weixin.domain.req.CardRsq;
import com.zk.system.domain.weixin.domain.resp.CreateCardSuccessResp;
import com.zk.system.domain.weixin.domain.vo.CreateCardVo;
import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
public class WxkqCreateCardController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(WxkqCreateCardController.class);
    @Autowired
    private WeixinGetToken weixinGetToken;
    @Autowired
    private IWxkqCreateCardRecordService wxkqCreateCardRecordService;
    @Autowired
    private IWxkqCreateCardDetailsInfoService wxkqCreateCardDetailsInfoService;

    /**
     * 1、创建卡券接口
     */
    @PostMapping("/createCard")
    @Log(title = "创建卡券基本信息", businessType = BusinessType.INSERT)
    public AjaxResult createCard(@RequestBody CreateCardVo createCardVo) {
        logger.debug("create card info {}", JsonUtil.toJson(createCardVo));
        AccessToken token = weixinGetToken.getToken();
        String url = WXUrlConstants.CREATE_CARD + "?access_token=" + token.getAccess_token();
        logger.debug("api interface is { }",WXUrlConstants.CREATE_CARD);

        CreateCard createCard = new CreateCard();
        CardRsq card = new CardRsq();
        card.setCard_type("GROUPON");

        SKU sku = new SKU(createCardVo.getQuantity());
        DateInfo dateInfo = new DateInfo();
        dateInfo.setType(createCardVo.getDateType());
        dateInfo.setBegin_timestamp(Long.valueOf(DateUtils.dateToStamp(createCardVo.getStartTime())));
        dateInfo.setEnd_timestamp(Long.valueOf(DateUtils.dateToStamp(createCardVo.getEndTime())));

        BaseCodeInfo baseCodeInfo = new BaseCodeInfo();
        baseCodeInfo.setLogo_url(createCardVo.getLogo_url());
        baseCodeInfo.setCode_type(WXcodeTypeConstants.CODE_TYPE_QRCODE);
        baseCodeInfo.setTitle(createCardVo.getTitle());
        baseCodeInfo.setBrand_name(createCardVo.getBrandName());
        baseCodeInfo.setColor(createCardVo.getColor());
        baseCodeInfo.setNotice(createCardVo.getNotice());
        baseCodeInfo.setDescription(createCardVo.getDescription());
        baseCodeInfo.setUse_custom_code(true);
        baseCodeInfo.setGet_custom_code_mode("GET_CUSTOM_CODE_MODE_DEPOSIT");
        baseCodeInfo.setSku(sku);
        baseCodeInfo.setDate_info(dateInfo);
        GroupOn groupOn = new GroupOn();
        groupOn.setDeal_detail(createCardVo.getCard_details());
        groupOn.setBase_info(baseCodeInfo);
        card.setGroupon(groupOn);
        createCard.setCard(card);
        logger.info("init parameter body {}",JsonUtil.toJson(createCard));

        InsertCreateCardDetailsPo insertCreateCardDetailsPo = new InsertCreateCardDetailsPo();
        insertCreateCardDetailsPo.setCreateBy("system");
        insertCreateCardDetailsPo.setCardType(card.getCard_type());
        insertCreateCardDetailsPo.setDetail(JsonUtil.toJson(createCard));


        String result = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(createCard));
        CreateCardSuccessResp createCardSuccessResp = JsonUtil.toObject(result, CreateCardSuccessResp.class);
        wxkqCreateCardRecordService.insertRecord(createCardSuccessResp);
        wxkqCreateCardDetailsInfoService.insertCreateCardDetails(insertCreateCardDetailsPo);
        return AjaxResult.success("OK");
    }

    @GetMapping("/list")
    @Log(title = "获取成功卡券列表", businessType = BusinessType.INSERT)
    public TableDataInfo getCreateCardInfoList(){
        startPage();
        List<WxkqCreateCardRecord> wxkqCreateCardRecords = wxkqCreateCardRecordService.queueAll();
        return getDataTable(wxkqCreateCardRecords);
    }



    /**
     * 2、获取创建成功卡券列表
     */

    /**
     * 3、本地存储卡券详细信息接口
     */



    /**
     * 4、调用微信端查询卡券详情接口
     */


    /**
     * 5、卡券更新接口
     */

    /**
     * 6、导入code码操作
     */
}
