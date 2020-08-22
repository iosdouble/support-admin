package com.zk.web.controller.news;

import com.zk.common.core.controller.BaseController;
import com.zk.common.core.domain.AjaxResult;
import com.zk.common.core.domain.model.LoginUser;
import com.zk.common.core.page.TableDataInfo;
import com.zk.common.utils.json.JsonUtil;
import com.zk.system.domain.GhNewsRes;
import com.zk.system.domain.GhNewsResWithBLOBs;
import com.zk.system.domain.vo.CreateNewsVo;
import com.zk.system.service.IGhNewsResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.List;

/**
 * @Classname NewsCreateController
 * @Description TODO
 * @Date 2020/8/22 9:38 AM
 * @Created by nihui
 * @Version 1.0
 * @Description NewsCreateController @see ruoyi
 */
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private IGhNewsResService ghNewsResService;

    @PostMapping("/create")
    public AjaxResult createNews(@RequestBody CreateNewsVo createNewsVo){

        int i = ghNewsResService.insertNewsInfo(createNewsVo);

        return AjaxResult.success();
    }

    @GetMapping("/getAll")
    public TableDataInfo getAllNewsInfo(){
        startPage();
        List<GhNewsResWithBLOBs> allNewS = ghNewsResService.findAllNewS();
        return getDataTable(allNewS);
    }
}
