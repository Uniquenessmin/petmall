package com.newer.petmall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.petmall.domain.CartItem;
import com.newer.petmall.domain.Item;

@Mapper
public interface ItemMapper {

	//??????????
	//更新 购物车某商品项的个数
	@Update("UPDATE ITEM SET QTY = QTY - #{increment}  WHERE ITEMID = #{itemId};")
	void updateQuantity(Map<String, Object> param);

	
	//查询 库存
	@Select("SELECT QTY AS value FROM ITEM WHERE ITEMID =#{itemId};")
	int getQuantity(String itemId);

	
	//获得 某商品的商品项列表
	@Select(" select I.ITEMID, LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID AS \"product.productId\"," + 
			" NAME AS \"product.name\",DESCN AS \"product.description\",CATID AS \"product.categoryId\",STATUS," + 
			" ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5,QTY AS quantity " + 
			" from ITEM I,  PRODUCT P where P.PRODUCTID = I.PRODUCTID and I.PRODUCTID = #{productId};")
	List<Item> getItemListByProduct(String productId);

	
	
	//获得商品项
	@Select(" select I.ITEMID, LISTPRICE,UNITCOST,SUPPLIER AS supplierId,I.PRODUCTID AS \"product.productId\"," + 
			" NAME AS \"product.name\",DESCN AS \"product.description\",CATID AS \"product.categoryId\",STATUS," + 
			" ATTR1 AS attribute1,ATTR2 AS attribute2,ATTR3 AS attribute3,ATTR4 AS attribute4,ATTR5 AS attribute5,QTY AS quantity " + 
			" from ITEM I,  PRODUCT P where P.PRODUCTID = I.PRODUCTID and I.ITEMID = #{itemId};")
	Item getItem(String itemId);
}
