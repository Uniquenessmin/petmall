package com.newer.petmall.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item implements Serializable {

	   private String itemId;
	   private String productId;
	   private BigDecimal listPrice;
	   private BigDecimal unitCost;
	   private int supplierId;
	   private String status;
	   private String attribute1;
	   private String attribute2;
	   private String attribute3;
	   private String attribute4;
	   private String attribute5;
	   private Product product;
	   private int quantity;
	   
}
