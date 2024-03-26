package com.lty.controller;

import com.lty.pojo.Headline;
import com.lty.service.HeadlineService;
import com.lty.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lty
 */
@RestController
@CrossOrigin
@RequestMapping("headline")
public class HeadlineController {
    @Autowired
    private HeadlineService service;
    @PostMapping("publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token){
        return service.publish(headline, token);
    }

    @PostMapping("findHeadlineByHid")
    public Result findHeadlineByHid(Integer hid){
        Headline headline = service.getById(hid);
        Map<String, Headline> data = new HashMap<>();
        data.put("headline", headline);
        return Result.ok(data);
    }

    @PostMapping("update")
    public Result update(@RequestBody Headline headline){
        return service.update(headline);
    }

    @PostMapping("removeByHid")
    public Result removeByHid(Integer hid){
        service.removeById(hid);
        return Result.ok(null);
    }
}
