package com.lzp.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authorHmLzp
 * @create 2019 - 01 - 29 18:37
 */
@RestController
@Api(tags = "测试接口-API")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation("hello的测试接口")
    @ApiImplicitParam(name = "name",value = "姓名",required = true,dataType = "String")
    public String index(@RequestParam(required = true) final String name){
        return "hello" + name;
    }

    @PostMapping("/sum")
    @ApiOperation("两个整数求和接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a",value = "参数a", required = true, dataType = "int"),
            @ApiImplicitParam(name = "b",value = "参数b", required = true, dataType = "int"),
    })
    public String sum(@RequestParam(required = true) final Integer a
            ,@RequestParam(required = true) final Integer b){
        int sum = a + b;
        return "a + b = " + sum ;
    }
}
