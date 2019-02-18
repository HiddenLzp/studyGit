package com.lzp.springboot.controller;

import com.lzp.springboot.service.TimeService;
import com.lzp.springboot.utils.LzpJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 时间
 *
 * @authorHmLzp
 * @create 2019 - 02 - 17 22:35
 */
@RestController
@RequestMapping("time")
@Api(tags = "时间类API")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @ApiOperation("获取当前系统时间")
    @GetMapping("/getCurrentTime")
    public LzpJSONResult getCurrentTime() {
        return LzpJSONResult.ok(timeService.getCurrentTime());
    }

    @ApiOperation("距离新年剩余天数")
    @GetMapping("/cutDownNewYear")
    public LzpJSONResult cutDownNewYear(){
        Integer days = timeService.cutDownNewYear();
        return LzpJSONResult.ok("距离新年还有："+ days +"天！");
    }

    @PostMapping("/diffDay")
    @ApiOperation("计算两者时间区间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "begin",value = "xxxx-xx-xx", required = true, dataType = "String"),
            @ApiImplicitParam(name = "end",value = "xxxx-xx-xx", required = true, dataType = "String"),
    })
    public LzpJSONResult diffDay(@RequestParam(required = true) final String begin,
                                 @RequestParam(required = true)  final String end) {
        try{
            Integer integer = timeService.diffDay(begin, end);
            return LzpJSONResult.ok(begin +"与" +end+"之间相隔："+integer + "天！");
        } catch (Exception e){
            return LzpJSONResult.errorMsg(e.getMessage());
        }
    }

    @PostMapping("/addDaysLater")
    @ApiOperation("N天后")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "days",dataType = "int",required = true,value = "正数为增，负数为减")
    })
    public LzpJSONResult addDays(Integer days) {
        try{
            String s = timeService.addDays(days);
            return LzpJSONResult.ok(s);
        } catch (Exception e) {
            return LzpJSONResult.errorMsg(e.getMessage());
        }
    }
}
