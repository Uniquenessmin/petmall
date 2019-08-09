package com.newer.petmall.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartItem implements Serializable {

	private Item item;
	private int quantity;
	private boolean inStock;// 是否有货
	private BigDecimal total;

	public void incrementQuantity() {
		quantity++;
		calculateTotal();
	}

	private void calculateTotal() {
		if (item != null && item.getListPrice() != null) {
			total = item.getListPrice().multiply(new BigDecimal(quantity));
		} else {
			total = null;
		}
	}



}
