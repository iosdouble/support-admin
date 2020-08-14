package com.ruoyi.web.controller.kaquan;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.WxkqMustBaseInfo;
import com.ruoyi.system.service.IWxkqMustBaseInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 微信卡券基础信息必填信息 Controller
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
@RestController
@RequestMapping("/system/info")
public class WxkqMustBaseInfoController extends BaseController
{
    @Autowired
    private IWxkqMustBaseInfoService wxkqMustBaseInfoService;

    /**
     * 查询微信卡券基础信息必填信息 列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxkqMustBaseInfo wxkqMustBaseInfo)
    {
        startPage();
        List<WxkqMustBaseInfo> list = wxkqMustBaseInfoService.selectWxkqMustBaseInfoList(wxkqMustBaseInfo);
        return getDataTable(list);
    }

    /**
     * 导出微信卡券基础信息必填信息 列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "微信卡券基础信息必填信息 ", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxkqMustBaseInfo wxkqMustBaseInfo)
    {
        List<WxkqMustBaseInfo> list = wxkqMustBaseInfoService.selectWxkqMustBaseInfoList(wxkqMustBaseInfo);
        ExcelUtil<WxkqMustBaseInfo> util = new ExcelUtil<WxkqMustBaseInfo>(WxkqMustBaseInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取微信卡券基础信息必填信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wxkqMustBaseInfoService.selectWxkqMustBaseInfoById(id));
    }

    /**
     * 新增微信卡券基础信息必填信息 
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "微信卡券基础信息必填信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxkqMustBaseInfo wxkqMustBaseInfo)
    {
        return toAjax(wxkqMustBaseInfoService.insertWxkqMustBaseInfo(wxkqMustBaseInfo));
    }

    /**
     * 修改微信卡券基础信息必填信息 
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "微信卡券基础信息必填信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxkqMustBaseInfo wxkqMustBaseInfo)
    {
        return toAjax(wxkqMustBaseInfoService.updateWxkqMustBaseInfo(wxkqMustBaseInfo));
    }

    /**
     * 删除微信卡券基础信息必填信息 
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "微信卡券基础信息必填信息 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxkqMustBaseInfoService.deleteWxkqMustBaseInfoByIds(ids));
    }
}
