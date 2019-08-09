package com.newer.petmall.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import lombok.Data;

@Data
public class Order implements Serializable {
	  private int orderId;
	  private String username;
	  private Date orderDate;
	  
	  private String shipAddress1;
	  private String shipAddress2;
	  private String shipCity;
	  private String shipState;
	  private String shipZip;
	  private String shipCountry;

	  private String billAddress1;
	  private String billAddress2;
	  private String billCity;
	  private String billState;
	  private String billZip;
	  private String billCountry;
	  private String courier;
	  private BigDecimal totalPrice;
	  private String billToName;
	  private String billToLastName;
	  
	  private String shipToName;
	  private String shipToLastName;
	  private String creditCard;
	  private String expiryDate;
	  private String cardType;
	  private String locale;
	  private String status;
	  private List<LineItem> lineItems = new ArrayList<LineItem>();

	 
	  /**
	   * 初始化订单
	   * @param account
	   * @param cart
	   */
	  public void initOrder(Account account, Cart cart) {

	    username = account.getName();
	    orderDate = new Date();

	    shipToName = account.getName();
	    
	    shipAddress1 = account.getAddress1();
	    shipAddress2 = account.getAddress2();
	    shipCity = account.getCity();
	    shipState = account.getState();
	    shipZip = account.getZip();
	    shipCountry = account.getCountry();

	    billToName = account.getName();
	   
	    billAddress1 = account.getAddress1();
	    billAddress2 = account.getAddress2();
	    billCity = account.getCity();
	    billState = account.getState();
	    billZip = account.getZip();
	    billCountry = account.getCountry();

	    totalPrice = cart.getSubTotal();

	    creditCard = "999 9999 9999 9999";
	    expiryDate = "12/03";
	    cardType = "Visa";
	    courier = "UPS";
	    locale = "CA";
	    status = "P";

	    Iterator<CartItem> i = cart.getAllCartItems();
	    while (i.hasNext()) {
	      CartItem cartItem = (CartItem) i.next();
	      addLineItem(cartItem);
	    }

	  }

	  public void addLineItem(CartItem cartItem) {
	    LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
	    addLineItem(lineItem);
	  }

	  public void addLineItem(LineItem lineItem) {
	    lineItems.add(lineItem);
	  }


}
