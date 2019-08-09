package com.newer.petmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newer.petmall.domain.LineItem;

@Mapper
public interface LineItemMapper {
	//插入
	@Insert("INSERT INTO lineorder values " + 
			" (#{lineNumber},#{orderId}, #{itemId}, #{quantity}, #{unitPrice});")
	void insertLineItem(LineItem lineItem);
	
	//获得订单项列表
	@Select("SELECT *  FROM LINEITEM WHERE ORDERID = #{orderId}")
	List<LineItem> getLineItemsByOrderId(int orderId);

	

}
