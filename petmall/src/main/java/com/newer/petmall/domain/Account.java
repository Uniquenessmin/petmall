package com.newer.petmall.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Account implements Serializable {
		//该实体对应创建三个表
	
	  private String username;
	  private String password;

	  private String email;
	  private String name;
	  private String status;
	  private String address1;
	  private String address2;
	  private String city;
	  private String state;
	  private String zip;//邮政编码
	  private String country;
	  private String phone;
	  
	  private String favouriteCategoryId;
	  private String languagePreference;
	  private boolean listOption;
	  private boolean bannerOption;
	  private String bannerName;
	  
	  
}
