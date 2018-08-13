package com.jwx.springcloud.service.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: swagger测试Controller
 *          访问http://localhost:8888/hello/chinese
 * <p>
 * PackageName:com.jwx.springcloud.server.web
 * FileName: HellloController.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/25
 */
@Api(description = "hello测试")
@RefreshScope
@RestController
@RequestMapping("/hello")
public class HellloController {

    @ApiOperation(value="hello测试接口", notes="返回中文你好信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户名", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/chinese" ,method = RequestMethod.POST,produces = "application/json")
    public String sayChineseHello(@RequestParam String user) {
        return "你好，"+user;
    }

    @ApiOperation(value="hello测试接口", notes="返回英文你好信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户名", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/english" ,method = RequestMethod.POST,produces = "application/json")
    public String sayEnglishHello(@RequestParam String user) {
        return "hello，"+user;
    }
}