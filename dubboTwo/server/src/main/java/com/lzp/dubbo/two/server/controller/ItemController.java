package com.lzp.dubbo.two.server.controller;

import com.lzp.dubbo.one.api.response.BaseResponse;
import com.lzp.dubbo.one.api.service.IDubboItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 18 14:36
 */
@RestController
public class ItemController {


    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    private static final String prefix = "item";

    @Autowired
    private IDubboItemService iDubboItemService;
    @RequestMapping(value = prefix + "/list",method = RequestMethod.GET)
    public Map<String,Object> list(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","成功!");
        try{
            BaseResponse baseResponse = iDubboItemService.listItems();
            if(baseResponse != null && baseResponse.getCode().equals(0)){
                map.put("data",baseResponse.getData());
            }
        }catch (Exception e) {
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","失败");
        }
        return map;
    }
}
