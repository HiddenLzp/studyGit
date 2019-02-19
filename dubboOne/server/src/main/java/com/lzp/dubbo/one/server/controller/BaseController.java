package com.lzp.dubbo.one.server.controller;

import com.lzp.dubbo.one.api.enums.StatusCode;
import com.lzp.dubbo.one.api.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 15 11:05
 */
@RestController
public class BaseController {

    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    private static final String prefix="base";

    /**
     * 测试的hello world
     * @param param
     * @return
     */
    @RequestMapping(value = prefix + "/one",method = RequestMethod.GET)
    public BaseResponse ont(@RequestParam String param){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);

        try{
            baseResponse.setData(param);
        }catch (Exception e){
            e.printStackTrace();
            baseResponse = new BaseResponse(StatusCode.Fail);
        }
        return baseResponse;
    }
}
