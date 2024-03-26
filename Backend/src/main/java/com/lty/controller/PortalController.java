package com.lty.controller;

import com.lty.mapper.TypeMapper;
import com.lty.pojo.vo.PortalVo;
import com.lty.service.HeadlineService;
import com.lty.service.TypeService;
import com.lty.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lty
 */
@RestController
@RequestMapping("portal")
@CrossOrigin
public class PortalController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private HeadlineService headlineService;
    @GetMapping("findAllTypes")
    public Result findAllTypes(){
        return typeService.findAllTypes();
    }

    @PostMapping("findNewsPage")
    public Result findNewsPage(@RequestBody PortalVo portalVo){
        return headlineService.findNewsPage(portalVo);
    }

    @PostMapping("showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid){
        return headlineService.showHeadlineDetail(hid);
    }
}
