package com.newer.petmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newer.petmall.domain.Order;

@Mapper
public interface OrderMapper {

	@Select("SELECT * FROM orders WHERE userid = #{username} ORDER BY ORDERDATE")
	List<Order> getOrdersByUsername(String username);

	@Select("SELECT * FROM orders WHERE orderid = #{orderId}")
	Order getOrder(int orderId);

	
	@Insert(" INSERT INTO ORDERS (USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE," + 
			" SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY," + 
			" COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME," + 
			" CREDITCARD, EXPRDATE, CARDTYPE, LOCALE,status)" + 
			" VALUES(#{username}, #{orderDate}, #{shipAddress1}, #{shipAddress2,jdbcType=VARCHAR}, #{shipCity}," + 
			" #{shipState}, #{shipZip}, #{shipCountry}, #{billAddress1}, #{billAddress2,jdbcType=VARCHAR}, #{billCity}," + 
			" #{billState}, #{billZip}, #{billCountry}, #{courier}, #{totalPrice}, #{billToFirstName}, #{billToLastName}," + 
			" #{shipToFirstName}, #{shipToLastName}, #{creditCard}, #{expiryDate}, #{cardType}, #{locale},#{status})")
	void insertOrder(Order order);

	

}
