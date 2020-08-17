package com.zk.common.constant;

/**
 * @Classname WXUrlConstants
 * @Description TODO
 * @Date 2020/8/17 9:13 AM
 * @Created by nihui
 * @Version 1.0
 * @Description WXUrlConstants @see ruoyi
 */
public class WXUrlConstants {

    /**
     * 上传卡券背景图
     */
    public static final String UPLOAD_IMAGE = "https://api.weixin.qq.com/cgi-bin/media/uploadimg";

    /**
     * 创建卡券地址
     */
    public static final String CREATE_CARD = "https://api.weixin.qq.com/card/create";

    /**
     * 导入卡券Code
     */
    public static final String INPUT_CARD_CODE = "http://api.weixin.qq.com/card/code/deposit";

    /**
     * 投放卡券
     */

    public static final String  LAUNCH_CARD = "https://api.weixin.qq.com/card/qrcode/create";

    /**
     * 查询导入Code信息
     */
    public static final String QUEUE_CORD_STATUS = "http://api.weixin.qq.com/card/code/getdepositcount";

    /**
     * 核查Card
     */
    public static final String CHECK_CARD = "http://api.weixin.qq.com/card/code/checkcode";

    /**
     * 查询卡券状态
     */
    public static final String QUEUE_CARD_STATUS = "https://api.weixin.qq.com/card/code/get";

    /**
     * 配置白名单
     */

    public static final String SET_WHITE_LIST = "https://api.weixin.qq.com/card/testwhitelist/set";

    /**
     * 核销卡券接口
     */
    public static final String VERIFICATION_CARD = "https://api.weixin.qq.com/card/code/consume";

}
