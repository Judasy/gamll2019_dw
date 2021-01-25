package com.wang.gmall.dw.dw_logger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo1Controller {

    @ResponseBody
    @RequestMapping("applog")
    public String testDemo(String log){
        System.out.println(log);
        return log;
    }
}