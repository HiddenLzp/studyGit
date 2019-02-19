package com.lzp.dubbo.one.model.mapper;

import com.lzp.dubbo.one.model.entity.ItemInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItemInfoMapper {

	public ItemInfo getItemInfoById(@Param(value = "id") Integer id)throws Exception;

	public List<ItemInfo> getItemInfoListByMap(Map<String, Object> param)throws Exception;

	public Integer getItemInfoCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItemInfo(ItemInfo itemInfo)throws Exception;

	public Integer updateItemInfo(ItemInfo itemInfo)throws Exception;

	public Integer deleteItemInfoById(@Param(value = "id") Long id)throws Exception;
	/*查询列表*/
	public List<ItemInfo> selectAll();

	public List<ItemInfo> selectByParams(@Param("search") String search);

}
