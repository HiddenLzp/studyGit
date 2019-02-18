package com.lzp.springboot.controller;

import com.lzp.springboot.pojo.User;
import com.lzp.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @authorHmLzp
 * @create 2019 - 01 - 30 10:10
 */
@RestController
@RequestMapping("user")
@Api(tags = "获取用户信息")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @PathVariable用于将请求URL中的模板变量映射到功能处理方法的参数上。//配置url和方法的一个关系@RequestMapping("item/{itemId}")
     * @param id
     * @return
     */
    @GetMapping("/helloUser/{id}")
    @ApiOperation("根据Id获取用户信息的接口")
    @ApiImplicitParam(name = "id",value = "用户Id",required = true, dataType = "Integer")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/helloUses")
    @ApiOperation("获取所有用户信息的接口")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
