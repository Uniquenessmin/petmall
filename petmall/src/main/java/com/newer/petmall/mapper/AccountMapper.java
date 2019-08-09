package com.newer.petmall.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newer.petmall.domain.Account;

@Mapper
public interface AccountMapper {
	
	/**********************************************************************
	 ********************************查询************************************
	 *******************************************************************/
	
	//用户名--->用户
	@Select("select ACCOUNT.USERID,account.EMAIL,account.NAME,account.STATUS,account.ADDR1 AS address1,account.ADDR2 AS address2," + 
			" account.CITY,account.STATE,account.ZIP,account.COUNTRY,account.PHONE,PROFILE.LANGPREF AS languagePreference," + 
			" PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,CATEGORY.CATID" + 
			" FROM ACCOUNT, PROFILE, SIGNON, CATEGORY WHERE ACCOUNT.USERID = #{username}" +
			" AND SIGNON.USERNAME = ACCOUNT.USERID" + 
			" AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = CATEGORY.CATID;")
	Account getAccountByUsername(String username);
	
	//用户名和密码--->用户
	@Select("select ACCOUNT.USERID,account.EMAIL,account.NAME,account.STATUS,account.ADDR1 AS address1,account.ADDR2 AS address2," + 
			" account.CITY,account.STATE,account.ZIP,account.COUNTRY,account.PHONE,PROFILE.LANGPREF AS languagePreference," + 
			" PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,CATEGORY.CATID" + 
			" FROM ACCOUNT, PROFILE, SIGNON, CATEGORY WHERE ACCOUNT.USERID = #{username}" +
			" AND SIGNON.PASSWORD = #{password} AND SIGNON.USERNAME = ACCOUNT.USERID" + 
			" AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = CATEGORY.CATID;")
	Account getAccountByUsernameAndPassword(String username,String password);
	
	
	/**********************************************************************
	 ********************************更新************************************
	 *******************************************************************/
	
	//更新用户信息（account表）
	@Update("UPDATE ACCOUNT SET "
			+ " EMAIL = #{email},NAME = #{name},STATUS = #{status},ADDR1 = #{address1}," 
			+ " ADDR2 = #{address2,jdbcType=VARCHAR},CITY = #{city},STATE = #{state},ZIP = #{zip},"
			+ " COUNTRY = #{country}, PHONE = #{phone} "
			+ " WHERE USERID = #{username};")
	void updateAccount(Account account); 
	
	//更新profile表信息
	@Update("UPDATE PROFILE SET LANGPREF = #{languagePreference}," + 
			"  FAVCATEGORY = #{favouriteCategoryId}  WHERE USERID = #{username};")
	void updateProfile(Account account);
	
	//更新密码
	@Update("UPDATE SIGNON SET PASSWORD = #{password} WHERE USERNAME = #{username};")
	void updateSignon(Account account);
					
	
	/**********************************************************************
	 ********************************插入************************************
	 *******************************************************************/
	//插入用户信息1（signon表）
	@Insert("INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (#{password}, #{username})")
	void insertSignon(Account account);
	 
	//插入用户信息2（profile表）
	@Insert("INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID,signon_username) " + 
			" VALUES (#{languagePreference}, #{favouriteCategoryId}, #{username}, #{username});")
	void insertProfile(Account account);
	
	  
	//插入用户信息3（account表）
	@Insert("INSERT INTO ACCOUNT (EMAIL, NAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP," + 
			" COUNTRY, PHONE, USERID,signon_username,profile_userid,profile_signon_username)" + 
			" VALUES" + 
			" (#{email}, #{name}, #{status}, #{address1},  #{address2,jdbcType=VARCHAR}, " + 
			" #{city}, #{state}, #{zip}, #{country}, #{phone}, #{username},#{username}, #{username}, #{username});")
	void insertAccount(Account account);
	

}
