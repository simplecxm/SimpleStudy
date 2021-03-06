package com.simple4h.sample.controller;

import com.simple4h.autoconfiguration.service.AutoService;
import com.simple4h.sample.feign.IDemoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author Create By Simple4H
 * date 2020-09-30 16:06
 */
@RestController
@RequestMapping("/sample/")
@RefreshScope
public class SampleController {

    @Autowired
    private IDemoFeignService iDemoFeignService;

    @Autowired
    private AutoService autoService;

    @Value("author")
    private String author;

    @GetMapping("get")
    public String get() {
        return iDemoFeignService.getUserInfo2();
    }

    @GetMapping("auto")
    public String auto() {
        return autoService.sayWhat();
    }

    @GetMapping("consulConfig")
    public String consulConfig() {
        return author;
    }
}