package com.lzp.dubbo.one.api.service;

import com.lzp.dubbo.one.api.response.BaseResponse;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 15 14:58
 */
public interface IDubboItemService {
    BaseResponse listItems();

    BaseResponse listPageItems();
}
