package com.lzp.dubbo.one.api.service;

import com.lzp.dubbo.one.api.request.PushOrderDto;
import com.lzp.dubbo.one.api.response.BaseResponse;

public interface IDubboRecordService {
    public BaseResponse pushOrder(PushOrderDto dto);
}
