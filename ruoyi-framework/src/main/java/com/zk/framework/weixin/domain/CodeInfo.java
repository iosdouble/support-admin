package com.zk.framework.weixin.domain;

import com.zk.framework.weixin.domain.bean.base.BaseCodeInfo;
import com.zk.framework.weixin.domain.bean.entity.DateInfo;
import com.zk.framework.weixin.domain.bean.entity.SKU;

import java.util.List;

/**
 * @Classname CodeInfo
 * @Description TODO
 * @Date 2020/8/14 4:37 PM
 * @Created by nihui
 * @Version 1.0
 * @Description CodeInfo @see ruoyi
 */
public class CodeInfo extends BaseCodeInfo {
    // 是否使用自定义Code码
    private boolean use_custom_code = true;
    // 卡券自定义预存模式
    private String get_custom_code_mode;

    // 是否指定 用户领取
    private boolean bind_openid;

    // 客服电话
    private String service_phone;

    // 商家ID
    private List<Long> location_id_list;

    // 设置本卡券支持全部门店
    private boolean use_all_locations;

    // 卡券顶部 居中按钮
    private String center_title;
    private String sub_center_title;

    // 每个人领取卡券数量限制
    private Integer get_limit = 1;
    // 每个人可核销的数量限制
    private Integer use_limit = 1;
    // 卡券领取页面是否可分享
    private boolean can_share = false;
    // 卡券是否可转让
    private boolean can_give_friend = false;

    public CodeInfo(String logo_url, String code_type, String brand_name, String name, String color, String notice, String description, SKU sku, DateInfo date_info, Integer fixed_term, Integer fixed_begin_term, boolean use_custom_code, String get_custom_code_mode, boolean bind_openid, String service_phone, List<Long> location_id_list, boolean use_all_locations, String center_title, String sub_center_title, Integer get_limit, Integer use_limit, boolean can_share, boolean can_give_friend) {
        super(logo_url, code_type, brand_name, name, color, notice, description, sku, date_info, fixed_term, fixed_begin_term);
        this.use_custom_code = use_custom_code;
        this.get_custom_code_mode = get_custom_code_mode;
        this.bind_openid = bind_openid;
        this.service_phone = service_phone;
        this.location_id_list = location_id_list;
        this.use_all_locations = use_all_locations;
        this.center_title = center_title;
        this.sub_center_title = sub_center_title;
        this.get_limit = get_limit;
        this.use_limit = use_limit;
        this.can_share = can_share;
        this.can_give_friend = can_give_friend;
    }

    public CodeInfo() {
    }

    public boolean isUse_custom_code() {
        return use_custom_code;
    }

    public void setUse_custom_code(boolean use_custom_code) {
        this.use_custom_code = use_custom_code;
    }

    public String getGet_custom_code_mode() {
        return get_custom_code_mode;
    }

    public void setGet_custom_code_mode(String get_custom_code_mode) {
        this.get_custom_code_mode = get_custom_code_mode;
    }

    public boolean isBind_openid() {
        return bind_openid;
    }

    public void setBind_openid(boolean bind_openid) {
        this.bind_openid = bind_openid;
    }

    public String getService_phone() {
        return service_phone;
    }

    public void setService_phone(String service_phone) {
        this.service_phone = service_phone;
    }

    public List<Long> getLocation_id_list() {
        return location_id_list;
    }

    public void setLocation_id_list(List<Long> location_id_list) {
        this.location_id_list = location_id_list;
    }

    public boolean isUse_all_locations() {
        return use_all_locations;
    }

    public void setUse_all_locations(boolean use_all_locations) {
        this.use_all_locations = use_all_locations;
    }

    public String getCenter_title() {
        return center_title;
    }

    public void setCenter_title(String center_title) {
        this.center_title = center_title;
    }

    public String getSub_center_title() {
        return sub_center_title;
    }

    public void setSub_center_title(String sub_center_title) {
        this.sub_center_title = sub_center_title;
    }

    public Integer getGet_limit() {
        return get_limit;
    }

    public void setGet_limit(Integer get_limit) {
        this.get_limit = get_limit;
    }

    public Integer getUse_limit() {
        return use_limit;
    }

    public void setUse_limit(Integer use_limit) {
        this.use_limit = use_limit;
    }

    public boolean isCan_share() {
        return can_share;
    }

    public void setCan_share(boolean can_share) {
        this.can_share = can_share;
    }

    public boolean isCan_give_friend() {
        return can_give_friend;
    }

    public void setCan_give_friend(boolean can_give_friend) {
        this.can_give_friend = can_give_friend;
    }
}
