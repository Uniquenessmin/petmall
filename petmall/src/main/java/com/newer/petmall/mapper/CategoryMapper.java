package com.newer.petmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newer.petmall.domain.Category;

@Mapper
public interface CategoryMapper {

	@Select("select * from Category;")
	List<Category> getCategoryList();

	@Select("select * from Category where catid = #{categoryId};")
	Category getCategory(String categoryId);
}
