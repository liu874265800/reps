/***********************************************************************
 * Module:  Admin.java
 * Author:  VIC
 * Purpose: Defines the Class Admin
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 后台管理员 */
public class Admin {
   private int A_ID;
   /** 管理员登录账号 */
   private String A_ACCOUNT;
   /** 管理员登录密码 */
   private String A_PASSWORD;
   /** 管理员邮箱 */
   private Date A_EAMIL;
   /** 管理员手机 */
   private Integer A_PHONE;
   /** 管理员头像 */
   private Date A_HEAD;
   /** 创建时间 */
   private Date CREATE_TIME;
   /** 创建人默认为系统) */
   private String CREATOR;
   /** 更新时间 */
   private Date UPDATE_TIME;
   /** 更新时间 */
   private Date UPDATE_CREATOR;
   /** 状态 */
   private String STATE;
   
   public int getA_ID() {
      return A_ID;
   }
   
   /** @param newA_ID */
   public void setA_ID(int newA_ID) {
      A_ID = newA_ID;
   }
   
   public String getA_ACCOUNT() {
      return A_ACCOUNT;
   }
   
   /** @param newA_ACCOUNT */
   public void setA_ACCOUNT(String newA_ACCOUNT) {
      A_ACCOUNT = newA_ACCOUNT;
   }
   
   public String getA_PASSWORD() {
      return A_PASSWORD;
   }
   
   /** @param newA_PASSWORD */
   public void setA_PASSWORD(String newA_PASSWORD) {
      A_PASSWORD = newA_PASSWORD;
   }
   
   public Date getA_EAMIL() {
      return A_EAMIL;
   }
   
   /** @param newA_EAMIL */
   public void setA_EAMIL(Date newA_EAMIL) {
      A_EAMIL = newA_EAMIL;
   }
   
   public Integer getA_PHONE() {
      return A_PHONE;
   }
   
   /** @param newA_PHONE */
   public void setA_PHONE(Integer newA_PHONE) {
      A_PHONE = newA_PHONE;
   }
   
   public Date getA_HEAD() {
      return A_HEAD;
   }
   
   /** @param newA_HEAD */
   public void setA_HEAD(Date newA_HEAD) {
      A_HEAD = newA_HEAD;
   }
   
   public Date getCREATE_TIME() {
      return CREATE_TIME;
   }
   
   /** @param newCREATE_TIME */
   public void setCREATE_TIME(Date newCREATE_TIME) {
      CREATE_TIME = newCREATE_TIME;
   }
   
   public String getCREATOR() {
      return CREATOR;
   }
   
   /** @param newCREATOR */
   public void setCREATOR(String newCREATOR) {
      CREATOR = newCREATOR;
   }
   
   public Date getUPDATE_TIME() {
      return UPDATE_TIME;
   }
   
   /** @param newUPDATE_TIME */
   public void setUPDATE_TIME(Date newUPDATE_TIME) {
      UPDATE_TIME = newUPDATE_TIME;
   }
   
   public Date getUPDATE_CREATOR() {
      return UPDATE_CREATOR;
   }
   
   /** @param newUPDATE_CREATOR */
   public void setUPDATE_CREATOR(Date newUPDATE_CREATOR) {
      UPDATE_CREATOR = newUPDATE_CREATOR;
   }
   
   public String getSTATE() {
      return STATE;
   }
   
   /** @param newSTATE */
   public void setSTATE(String newSTATE) {
      STATE = newSTATE;
   }

}