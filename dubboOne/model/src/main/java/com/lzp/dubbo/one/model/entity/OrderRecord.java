package com.lzp.dubbo.one.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @authorHmLzp
 * @create 2019 - 02 - 18 17:09
 */
public class OrderRecord  implements Serializable {

    private Integer id;
    private Integer itemId;
    private Integer total;
    private String cusomerName;
    private Date orderTime;
    private Integer isActive;
    private Date updateTime;

    public OrderRecord() {
    }

    public OrderRecord(Integer id, Integer itemId, Integer total, String cusomerName, Date orderTime, Integer isActive, Date updateTime) {
        this.id = id;
        this.itemId = itemId;
        this.total = total;
        this.cusomerName = cusomerName;
        this.orderTime = orderTime;
        this.isActive = isActive;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OrderRecord{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", total=" + total +
                ", cusomerName='" + cusomerName + '\'' +
                ", orderTime=" + orderTime +
                ", isActive=" + isActive +
                ", updateTime=" + updateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCusomerName() {
        return cusomerName;
    }

    public void setCusomerName(String cusomerName) {
        this.cusomerName = cusomerName;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
