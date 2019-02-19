package com.lzp.dubbo.one.api.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 18 17:16
 */
@Getter
@Setter
@ToString
public class PushOrderDto implements Serializable {
    private Integer itemId;//商品id
    private Integer total;//下单数量
    private String cusomerName;//客户姓名
 }
