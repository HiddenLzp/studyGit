package com.lzp.dubbo.one.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzp.dubbo.one.api.enums.StatusCode;
import com.lzp.dubbo.one.api.response.BaseResponse;
import com.lzp.dubbo.one.api.service.IDubboItemService;
import com.lzp.dubbo.one.model.entity.ItemInfo;
import com.lzp.dubbo.one.model.mapper.ItemInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import java.util.List;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 15 15:00
 */
@Service(protocol = {"dubbo","rest"},validation = "true",version = "1.0",timeout = 3000)
@Path("lzpOne")
public class IDubboItemServiceImpl implements IDubboItemService {

    private static final Logger log = LoggerFactory.getLogger(IDubboItemServiceImpl.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;
    /**
     * 列表查询服务-实际的业务实现逻辑
     * @return
     */
    @Override
    @Path("item/list")
    public BaseResponse listItems() {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        try{
            List<ItemInfo> itemInfos = itemInfoMapper.selectAll();
            System.out.println(itemInfos);
            baseResponse.setData(itemInfos);
        }catch (Exception e){
            log.error("列表查询服务-实际的业务实现逻辑，发生异常！"+e.fillInStackTrace());
            baseResponse = new BaseResponse(StatusCode.Fail);
        }
        return baseResponse;
    }

    /**
     * 列表分页查询
     * @return
     */
    @Override
    @Path("item/page/list")
    public BaseResponse listPageItems() {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        return baseResponse;
    }
}
