package com.zk.web.controller.kaquan;

import com.zk.common.core.controller.BaseController;
import com.zk.common.core.domain.AjaxResult;
import com.zk.common.utils.http.HttpClientUtil;
import com.zk.common.utils.json.JsonUtil;
import com.zk.system.domain.weixin.accesstoken.AccessToken;
import com.zk.system.domain.weixin.accesstoken.WeixinGetToken;
import com.zk.system.domain.weixin.domain.bean.entity.CardItem;
import com.zk.system.domain.weixin.domain.req.CardShopRsq;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname WxkqLaunchCardController
 * @Description TODO 投放卡券相关内容
 * @Date 2020/8/18 6:25 PM
 * @Created by nihui
 * @Version 1.0
 * @Description WxkqLaunchCardController @see ruoyi
 */
@RestController
public class WxkqLaunchCardController extends BaseController {


    @Autowired
    private WeixinGetToken weixinGetToken;

    /**
     * 生成微信卡券货架
     */

    @PostMapping("/initCardShop")
    public AjaxResult createCardShop(){
        AccessToken token = weixinGetToken.getToken();
        String url = "https://api.weixin.qq.com/card/landingpage/create?access_token=" + token.getAccess_token();

        CardShopRsq cardShopRsq = new CardShopRsq();
        cardShopRsq.setBanner("http://mmbiz.qpic.cn/mmbiz_png/B3zBXUpXXBX3y9ibfqWvN7NerZ86CtjT960IjMMOaiaEaNHjBPBicaGo6tMtIn0rqUJp4wuR24PjcO5WgLbNlJORQ/0");
        cardShopRsq.setCan_share(true);
        cardShopRsq.setPage_title("普惠服务");
        cardShopRsq.setScene("SCENE_NEAR_BY");

        CardItem cardItem = new CardItem("pWHBzsx2ZPlC64IvXYe9t4iKNwm0","null");
        CardItem cardItem1 = new CardItem("pWHBzsyP1l8p7_Szp15SH5nv3UC4","null");
        CardItem cardItem2 = new CardItem("pWHBzs9bUHwU56R8idTgwyV62gXM","null");
        CardItem cardItem3 = new CardItem("pWHBzs5NLhP0MYMn4Ia1IUdrbN6s","null");
        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(cardItem);
        cardItemList.add(cardItem1);
        cardItemList.add(cardItem2);
        cardItemList.add(cardItem3);

        cardShopRsq.setCard_list(cardItemList);

        String s = HttpClientUtil.sendPostJsonBody(url, JsonUtil.toJson(cardShopRsq));
        System.out.println(s);
        return AjaxResult.success("OK");
    }

    /**
     * 获取到微信页面方式展示的卡券列表
     */
    @GetMapping("/getCardList")
    public AjaxResult getSelfCardShopList(){
        return AjaxResult.success("OK");
    }

}
