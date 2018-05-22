/***********************************************************************
 * Module:  ReceivingAddress.java
 * Author:  VIC
 * Purpose: Defines the Class ReceivingAddress
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 收货地址 */
public class ReceivingAddress {
   /** ID */
   private Integer RA_ID;
   /** 国家 */
   private String RA_COUNTRY;
   /** 省 */
   private String RA_PROVINCE;
   /** 市 */
   private String RA_CITY;
   /** 详细地址 */
   private String RA_DETAIL;
   /** 收货人姓名 */
   private String RA_PERSON;
   /** 收货人手机 */
   private String RA_PHONE;
   /** 状态 */
   private String STATE;
   /** 用户ID */
   private Integer U_ID;
   /** 创建时间 */
   private Date CREATE_TIME;
   /** 更新时间 */
   private Date UPDATE_TIME;
   
   public Integer getRA_ID() {
      return RA_ID;
   }
   
   /** @param newRA_ID */
   public void setRA_ID(Integer newRA_ID) {
      RA_ID = newRA_ID;
   }
   
   public String getRA_COUNTRY() {
      return RA_COUNTRY;
   }
   
   /** @param newRA_COUNTRY */
   public void setRA_COUNTRY(String newRA_COUNTRY) {
      RA_COUNTRY = newRA_COUNTRY;
   }
   
   public String getRA_PROVINCE() {
      return RA_PROVINCE;
   }
   
   /** @param newRA_PROVINCE */
   public void setRA_PROVINCE(String newRA_PROVINCE) {
      RA_PROVINCE = newRA_PROVINCE;
   }
   
   public String getRA_CITY() {
      return RA_CITY;
   }
   
   /** @param newRA_CITY */
   public void setRA_CITY(String newRA_CITY) {
      RA_CITY = newRA_CITY;
   }
   
   public String getRA_DETAIL() {
      return RA_DETAIL;
   }
   
   /** @param newRA_DETAIL */
   public void setRA_DETAIL(String newRA_DETAIL) {
      RA_DETAIL = newRA_DETAIL;
   }
   
   public String getRA_PERSON() {
      return RA_PERSON;
   }
   
   /** @param newRA_PERSON */
   public void setRA_PERSON(String newRA_PERSON) {
      RA_PERSON = newRA_PERSON;
   }
   
   public String getRA_PHONE() {
      return RA_PHONE;
   }
   
   /** @param newRA_PHONE */
   public void setRA_PHONE(String newRA_PHONE) {
      RA_PHONE = newRA_PHONE;
   }
   
   public String getSTATE() {
      return STATE;
   }
   
   /** @param newSTATE */
   public void setSTATE(String newSTATE) {
      STATE = newSTATE;
   }
   
   public Integer getU_ID() {
      return U_ID;
   }
   
   /** @param newU_ID */
   public void setU_ID(Integer newU_ID) {
      U_ID = newU_ID;
   }
   
   public Date getCREATE_TIME() {
      return CREATE_TIME;
   }
   
   /** @param newCREATE_TIME */
   public void setCREATE_TIME(Date newCREATE_TIME) {
      CREATE_TIME = newCREATE_TIME;
   }
   
   public Date getUPDATE_TIME() {
      return UPDATE_TIME;
   }
   
   /** @param newUPDATE_TIME */
   public void setUPDATE_TIME(Date newUPDATE_TIME) {
      UPDATE_TIME = newUPDATE_TIME;
   }

}