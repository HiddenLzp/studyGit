package com.lzp.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.base.Strings;
import com.lzp.dubbo.one.api.enums.StatusCode;
import com.lzp.dubbo.one.api.request.PushOrderDto;
import com.lzp.dubbo.one.api.response.BaseResponse;
import com.lzp.dubbo.one.api.service.IDubboRecordService;
import com.lzp.dubbo.one.model.entity.ItemInfo;
import com.lzp.dubbo.one.model.mapper.ItemInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 18 17:21
 */
@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 30000)
@Path("push/record")
public class IDubboRecordServiceImpl implements IDubboRecordService {

    private static final Logger log = LoggerFactory.getLogger(IDubboRecordServiceImpl.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;
    @Override
    @Path("push")
    public BaseResponse pushOrder(PushOrderDto dto) {
        if(dto.getItemId() == null || dto.getItemId() <= 0 ||
                Strings.isNullOrEmpty(dto.getCusomerName()) ||
            dto.getTotal() == null || dto.getTotal() <= 0){
            return new BaseResponse(StatusCode.InvalidParams);
        }

        BaseResponse baseResponse = new BaseResponse();
        try{
            //TODO: 实际的业务逻辑

            //TODO: 校验商品信息是否存在
            ItemInfo itemInfoById = itemInfoMapper.getItemInfoById(dto.getItemId());
            if(itemInfoById == null){
                return new BaseResponse(StatusCode.ItemNotExit);
            }
        } catch (Exception e){
            e.printStackTrace();
            baseResponse = new BaseResponse(StatusCode.Fail);
        }
        return baseResponse;
    }
}
