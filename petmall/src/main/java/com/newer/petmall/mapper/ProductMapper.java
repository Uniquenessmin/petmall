package com.newer.petmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newer.petmall.domain.Product;

@Mapper
public interface ProductMapper {

	//种类--->商品列表
	@Select(" SELECT PRODUCTID, NAME, DESCN as description,CATID" + 
			" FROM PRODUCT WHERE CATID = #{catid};")
	List<Product> getProductListByCategory(String catid);

	//商品号--->单个商品
	@Select(" SELECT PRODUCTID, NAME, DESCN as description, CATID " + 
			" FROM PRODUCT WHERE PRODUCTID = #{productId}")
	Product getProduct(String productId);

	//关键字--->商品列（搜索）
	@Select(" SELECT PRODUCTID, NAME, DESCN as description, CATID " + 
			" FROM PRODUCTWHERE lower(name) like #{keywords} or lower(CATID) like #{keywords}")
	List<Product> searchProductList(String keywords);
}
