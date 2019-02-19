package com.lzp.dubbo.one.model.entity;
import java.io.Serializable;
import java.util.Date;
/***
*   商品信息表
*/
public class ItemInfo implements Serializable {
	//主键
	private Integer id;
	//商品编码
	private String code;
	//名称
	private String name;
	//销售价
	private Double price;
	//是否有效(1=是；0=否)
	private Integer isActive;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public ItemInfo() {
	}

	public ItemInfo(Integer id, String code, String name, Double price, Integer isActive, Date createTime, Date updateTime) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.isActive = isActive;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
}