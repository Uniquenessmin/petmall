package com.newer.petmall.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable{

	  private String productId;
	  private String categoryId;
	  private Category category;
	  private String name;
	  private String description;


}
