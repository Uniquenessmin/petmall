package com.newer.petmall.domain;

import java.io.Serializable;

import lombok.Data;


@Data
public class Category implements Serializable {
	  private String categoryId;
	  private String name;
	  private String description1;
	  private String description2;
	  
	  public String toString() {
	    return categoryId;
	  }
	
}
