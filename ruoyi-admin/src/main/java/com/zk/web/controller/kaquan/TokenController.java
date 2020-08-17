package com.zk.web.controller.kaquan;

import com.zk.common.annotation.Log;
import com.zk.common.constant.WXUrlConstants;
import com.zk.common.constant.WXcodeTypeConstants;
import com.zk.common.core.controller.BaseController;
import com.zk.common.core.page.TableDataInfo;
import com.zk.common.enums.BusinessType;
import com.zk.common.utils.http.HttpClientUtil;
import com.zk.common.utils.idgenerator.SnowflakeIdUtils;
import com.zk.common.utils.json.JsonUtil;
import com.zk.framework.weixin.domain.bean.GroupOn;
import com.zk.framework.weixin.domain.req.CardRsq;
import com.zk.framework.weixin.domain.bean.CreateCard;
import com.zk.framework.weixin.accesstoken.AccessToken;
import com.zk.framework.weixin.accesstoken.WeixinGetToken;
import com.zk.framework.weixin.domain.bean.base.BaseCodeInfo;
import com.zk.framework.weixin.domain.bean.entity.ActionInfo;
import com.zk.framework.weixin.domain.bean.entity.Card;
import com.zk.framework.weixin.domain.bean.entity.DateInfo;
import com.zk.framework.weixin.domain.bean.entity.SKU;
import com.zk.framework.weixin.domain.req.*;
import com.zk.framework.weixin.domain.resp.CreateCardSuccessResp;
import com.zk.framework.weixin.domain.vo.CreateCardVo;
import com.zk.system.domain.WxkqCreateCardRecord;
import com.zk.system.service.IWxkqCreateCardRecordService;
import com.zk.system.service.IWxkqMustBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * @Classname TokenController
 * @Description TODO
 * @Date 2020/8/14 3:43 PM
 * @Created by nihui
 * @Version 1.0
 * @Description TokenController @see ruoyi
 */
@RestController
@RequestMapping("/kaqu")
public class TokenController extends BaseController {

    @Autowired
    private WeixinGetToken weixinGetToken;


    @Autowired
    private IWxkqCreateCardRecordService wxkqCreateCardRecordService;

    @Autowired
    private IWxkqMustBaseInfoService wxkqMustBaseInfoService;

//
//    @GetMapping("/getToken")
//    public String getToke() {
////        launchCard();
//
//        // pKGjp0jNzIQqtZp9-fScdQFvGqfI
//
//
//        // pWHBzswN7isz08dXtPRpw7yqqfRw
//
//        createCard();
////        inputCode();
////        checkCodeCount();
////        checkCode();
////        setTestUser();
//        getCode();
//        return "Hello OK!";
//    }

    @PostMapping("/createCard")
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "微信卡券基础信息必填信息 ", businessType = BusinessType.INSERT)
    public String createCard(@RequestBody CreateCardVo createCardVo) {
        System.out.println(createCardVo.toString());

        AccessToken token = weixinGetToken.getToken();
        String url = WXUrlConstants.CREATE_CARD + "?access_token=" + token.getAccess_token();

        SKU sku = new SKU(0);
        DateInfo dateInfo = new DateInfo();
        dateInfo.setType("DATE_TYPE_FIX_TIME_RANGE");
        dateInfo.setBegin_timestamp(1578670800L);
        dateInfo.setEnd_timestamp(1602344400L);

        BaseCodeInfo baseCodeInfo = new BaseCodeInfo();
        baseCodeInfo.setLogo_url("http://mmbiz.qpic.cn/mmbiz_png/B3zBXUpXXBX3y9ibfqWvN7NerZ86CtjT960IjMMOaiaEaNHjBPBicaGo6tMtIn0rqUJp4wuR24PjcO5WgLbNlJORQ/0");
        baseCodeInfo.setCode_type(WXcodeTypeConstants.CODE_TYPE_QRCODE);
        baseCodeInfo.setTitle("微信卡券");
        baseCodeInfo.setBrand_name("微信餐厅");
        baseCodeInfo.setColor("Color010");
        baseCodeInfo.setNotice("使用时向服务员出示此券");
        baseCodeInfo.setDescription("不可与其他优惠同享");
        baseCodeInfo.setUse_custom_code(true);
        baseCodeInfo.setGet_custom_code_mode("GET_CUSTOM_CODE_MODE_DEPOSIT");
        baseCodeInfo.setSku(sku);
        baseCodeInfo.setDate_info(dateInfo);
        GroupOn groupOn = new GroupOn();
        groupOn.setDeal_detail("示例");
        groupOn.setBase_info(baseCodeInfo);
        CardRsq card = new CardRsq();
        card.setGroupon(groupOn);
        card.setCard_type("GROUPON");
        CreateCard createCard = new CreateCard();
        createCard.setCard(card);
        System.out.println(JsonUtil.toJson(createCard));
        String str = JsonUtil.toJson(createCard);


        WxkqCreateCardRecord wxkqCreateCardRecord = new WxkqCreateCardRecord();

        String s1 = HttpClientUtil.sendPostJsonBody(url, str);
        CreateCardSuccessResp createCardSuccessResp = JsonUtil.toObject(s1, CreateCardSuccessResp.class);
        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1, 1);
        wxkqCreateCardRecord.setId(snowflakeIdUtils.nextId());
        wxkqCreateCardRecord.setCardId(createCardSuccessResp.getCard_id());
        wxkqCreateCardRecord.setCardType(card.getCard_type());
        wxkqCreateCardRecord.setCreateBy("system");
        wxkqCreateCardRecord.setUseCustomCode(0);
        wxkqCreateCardRecord.setCreateTime(new Date());
        wxkqCreateCardRecord.setErrcode(createCardSuccessResp.getErrcode());
        wxkqCreateCardRecord.setErrmsg(createCardSuccessResp.getErrmsg());
        wxkqCreateCardRecord.setCardId(createCardSuccessResp.getCard_id());
        wxkqCreateCardRecord.setStatus(0);
        wxkqCreateCardRecord.setDelFlag(0);
        wxkqCreateCardRecordService.insertRecord(wxkqCreateCardRecord);


        System.out.println(s1);

        return "OK";
    }

    @GetMapping("/list")
    public TableDataInfo getCreateCardInfoList(){
        startPage();
        List<WxkqCreateCardRecord> wxkqCreateCardRecords = wxkqCreateCardRecordService.queueAll();
        return getDataTable(wxkqCreateCardRecords);
    }

    /**
     * 上传图片接口
     * <p>
     * https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN
     */

    private static void uploadimage() {
        //图片路径
        String filepath = "doc/logo1.png";
        //把自己的access_token放在等号后面
        String urlStr = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=36_OaGwEyxhfkwUKF4qD5TdCNy29dxx3K1Qld1U7pRVnwVIlwMclYat1uXrhFZYUS-INQ1KNAOpc34wVRsFLvWODm0viVhFPLFCMaizD5feugE41_pt9NZyYuz_QqCdvkrQShlOShgHogp2x6a_KDCcAGAVON";

        Map<String, String> textMap = new HashMap<String, String>();
        textMap.put("name", "testname");
        Map<String, String> fileMap = new HashMap<String, String>();
        fileMap.put("userfile", filepath);
        String ret = formUpload(urlStr, textMap, fileMap);
        System.out.println(ret);
    }

    /**
     * 上传图片
     */
    public static String formUpload(String urlStr, Map<String, String> textMap, Map<String, String> fileMap) {
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // text
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator iter = textMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }
            // file
            if (fileMap != null) {
                Iterator iter = fileMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();
                    String contentType = new MimetypesFileTypeMap().getContentType(file);
                    if (filename.endsWith(".png")) {
                        contentType = "image/png";
                    }
                    if (contentType == null || contentType.equals("")) {
                        contentType = "application/octet-stream";
                    }
                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename
                            + "\"\r\n");
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");
                    out.write(strBuf.toString().getBytes());
                    DataInputStream in = new DataInputStream(new FileInputStream(file));
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();
            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("发送POST请求出错。" + urlStr);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }

    /**
     * 实现图片上传功能
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String filePath = "F:\\Workspase\\BackController\\src\\main\\webapp\\jsp\\pic\\"; // 上传后的路径
        //fileName = UUID.randomUUID() + suffixName; // 存库的时候使用
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }


    /**
     * 预存模式创建卡券
     * <p>
     * https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN
     */

    public void createCard() {
        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/card/create?access_token=" + token.getAccess_token();

        SKU sku = new SKU(0);
        DateInfo dateInfo = new DateInfo();
        dateInfo.setType("DATE_TYPE_FIX_TIME_RANGE");
        dateInfo.setBegin_timestamp(1578670800L);
        dateInfo.setEnd_timestamp(1602344400L);

        BaseCodeInfo baseCodeInfo = new BaseCodeInfo();
        baseCodeInfo.setLogo_url("http://mmbiz.qpic.cn/mmbiz_png/B3zBXUpXXBX3y9ibfqWvN7NerZ86CtjT960IjMMOaiaEaNHjBPBicaGo6tMtIn0rqUJp4wuR24PjcO5WgLbNlJORQ/0");
//        baseCodeInfo.setCode_type("CODE_TYPE_TEXT");
        baseCodeInfo.setTitle("微信卡券");
        baseCodeInfo.setBrand_name("微信餐厅");
        baseCodeInfo.setColor("Color010");
        baseCodeInfo.setNotice("使用时向服务员出示此券");
        baseCodeInfo.setDescription("不可与其他优惠同享");
        baseCodeInfo.setUse_custom_code(true);
        baseCodeInfo.setGet_custom_code_mode("GET_CUSTOM_CODE_MODE_DEPOSIT");
        baseCodeInfo.setSku(sku);
        baseCodeInfo.setDate_info(dateInfo);
        GroupOn groupOn = new GroupOn();
        groupOn.setDeal_detail("示例");
        groupOn.setBase_info(baseCodeInfo);
        CardRsq card = new CardRsq();
        card.setGroupon(groupOn);
        card.setCard_type("GROUPON");
        CreateCard createCard = new CreateCard();
        createCard.setCard(card);
        System.out.println(JsonUtil.toJson(createCard));
        String str = JsonUtil.toJson(createCard);


        WxkqCreateCardRecord wxkqCreateCardRecord = new WxkqCreateCardRecord();
        try {
            String s1 = HttpClientUtil.sendPostJsonBody(url, str);
            CreateCardSuccessResp createCardSuccessResp = JsonUtil.toObject(s1, CreateCardSuccessResp.class);
            SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1, 1);
            wxkqCreateCardRecord.setId(snowflakeIdUtils.nextId());
            wxkqCreateCardRecord.setCardId(createCardSuccessResp.getCard_id());
            wxkqCreateCardRecord.setCardType(card.getCard_type());
            wxkqCreateCardRecord.setCreateBy("system");
            wxkqCreateCardRecord.setUseCustomCode(0);
            wxkqCreateCardRecord.setCreateTime(new Date());
            wxkqCreateCardRecord.setErrcode(createCardSuccessResp.getErrcode());
            wxkqCreateCardRecord.setErrmsg(createCardSuccessResp.getErrmsg());
            wxkqCreateCardRecord.setCardId(createCardSuccessResp.getCard_id());
            wxkqCreateCardRecord.setStatus(0);
            wxkqCreateCardRecord.setDelFlag(0);
            wxkqCreateCardRecordService.insertRecord(wxkqCreateCardRecord);


            System.out.println(s1);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /**
     * 配置审核通过接口
     */

    /**
     * 创建二维码投放
     * https://api.weixin.qq.com/card/qrcode/create?access_token=TOKEN
     */

    public void launchCard() {


        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/card/qrcode/create?access_token=" + token.getAccess_token();

        LaunchCodeRsq launchCode = new LaunchCodeRsq();
        launchCode.setAction_name("QR_CARD");
        launchCode.setExpire_seconds(1800L);

        Card card = new Card();
        card.setCard_id("pWHBzswN7isz08dXtPRpw7yqqfRw");
        card.setCode("744232112244264960");
        card.setOpenid("oFS7Fjl0WsZ9AMZqrI80nbIq8xrA");
        card.setIs_unique_code(false);
        card.setOuter_str("12b");
        ActionInfo actionInfo = new ActionInfo();
        actionInfo.setCard(card);
        launchCode.setAction_info(actionInfo);
        System.out.println(JsonUtil.toJson(launchCode));
        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(launchCode));
        System.out.println(s);


    }

    /**
     * 导入Code
     * http://api.weixin.qq.com/card/code/deposit?access_token=ACCESS_TOKEN
     */

    public void inputCode() {
        AccessToken token = weixinGetToken.getToken();
        String url = "http://api.weixin.qq.com/card/code/deposit?access_token=" + token.getAccess_token();
        InputCodeRsq inputCode = new InputCodeRsq();
        inputCode.setCard_id("pWHBzs9bUHwU56R8idTgwyV62gXM");
        List<String> codes = new ArrayList<>();
        SnowflakeIdUtils snowflakeIdUtils = new SnowflakeIdUtils(1, 1);
        for (int i = 0; i < 80; i++) {
            long l = snowflakeIdUtils.nextId();
            codes.add(String.valueOf(l));
        }
        inputCode.setCode(codes);
        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(inputCode));
        System.out.println(s);

    }

    /**
     * 查询导入的Code
     * http://api.weixin.qq.com/card/code/getdepositcount?access_token=ACCESS_TOKEN
     */
    public void checkCodeCount() {

        AccessToken token = weixinGetToken.getToken();
        String url = "http://api.weixin.qq.com/card/code/getdepositcount?access_token=" + token.getAccess_token();

        GetCodeReq getCodeReq = new GetCodeReq();
        getCodeReq.setCard_id("pWHBzs9bUHwU56R8idTgwyV62gXM");

        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(getCodeReq));
        System.out.println(s);

        // {"errcode":0,"errmsg":"ok","count":80}


    }

    /**
     * 核查Code
     * http://api.weixin.qq.com/card/code/checkcode?access_token=ACCESS_TOKEN
     */
    public void checkCode() {

        AccessToken token = weixinGetToken.getToken();
        String url = "http://api.weixin.qq.com/card/code/checkcode?access_token=" + token.getAccess_token();

        CheckCodeReq checkCodeReq = new CheckCodeReq();
        checkCodeReq.setCard_id("pWHBzs9bUHwU56R8idTgwyV62gXM");
        List<String> codelist = new ArrayList<>();
        String str = "744236683645554688,744236683645554689,744236683645554690,744236683645554691,744236683645554692,744236683645554693,744236683645554694,744236683645554695,744236683645554696,744236683645554697,744236683645554698,744236683645554699,744236683645554700,744236683645554701,744236683645554702,744236683645554703,744236683645554704,744236683645554705,744236683645554706,744236683645554707,744236683645554708,744236683645554709,744236683645554710,744236683645554711,744236683645554712,744236683645554713,744236683645554714,744236683645554715,744236683645554716,744236683645554717,744236683645554718,744236683645554719,744236683645554720,744236683645554721,744236683645554722,744236683645554723,744236683645554724,744236683645554725,744236683645554726,744236683645554727,744236683645554728,744236683645554729,744236683645554730,744236683645554731,744236683645554732,744236683645554733,744236683645554734,744236683645554735,744236683645554736,744236683645554737,744236683645554738,744236683645554739,744236683645554740,744236683645554741,744236683645554742,744236683645554743,744236683645554744,744236683645554745,744236683645554746,744236683645554747,744236683645554748,744236683645554749,744236683645554750,744236683645554751,744236683645554752,744236683645554753,744236683645554754,744236683645554755,744236683645554756,744236683645554757,744236683645554758,744236683645554759,744236683645554760,744236683645554761,744236683645554762,744236683645554763,744236683645554764,744236683645554765,744236683645554766,744236683645554767";
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            codelist.add(split[i]);
        }
        checkCodeReq.setCode(codelist);

        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(checkCodeReq));
        System.out.println(s);


    }


    /**
     * 查询卡券是否成功
     * https://api.weixin.qq.com/card/code/get?access_token=TOKEN
     */

    public void getCode() {

        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/card/code/get?access_token=" + token.getAccess_token();


//        GetCardReq getCardReq = new GetCardReq();
//        getCardReq.setCard_id("pWHBzs9bUHwU56R8idTgwyV62gXM");
//        getCardReq.setCode("744236683645554766");
//        getCardReq.setCheck_consume(true);
//
//        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(getCardReq));
//        System.out.println(s);

    }


    /**
     * 配置卡券白名单
     * https://api.weixin.qq.com/card/testwhitelist/set?access_token=TOKEN
     */

    public void setTestUser() {

        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/card/testwhitelist/set?access_token=" + token.getAccess_token();
        List<String> openids = new ArrayList<>();
        openids.add("");
        List<String> usernames = new ArrayList<>();
        usernames.add("");
        SetTestUserRsq setTestUser = new SetTestUserRsq();
        setTestUser.setOpenid(openids);
        setTestUser.setUsername(usernames);
        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(setTestUser));
        System.out.println(s);


    }


    /**
     * 核销卡券
     *
     * https://api.weixin.qq.com/card/code/consume?access_token=TOKEN
     */
}
