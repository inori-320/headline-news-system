package com.lty.controller;

import com.lty.pojo.Headline;
import com.lty.service.HeadlineService;
import com.lty.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
