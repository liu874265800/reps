/***********************************************************************
 * Module:  SystemSetup.java
 * Author:  VIC
 * Purpose: Defines the Class SystemSetup
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 系统设置 */
public class SystemSetup {
   /** ID */
   private Integer SS_ID;
   /** 系统名称 */
   private String SS_NAME;
   /** 系统首页 */
   private String SS_HOME;
   /** 系统关键字 */
   private String SS_KETWORDS;
   /** 系统描述 */
   private String SS_DESCRIBE;
   /** 系统域名 */
   private String SS_DOMAIN;
   /** 系统IP */
   private String SS_IP;
   /** 创建时间 */
   private Date CREATE_TIME;
   /** 创建人(管理员账号) */
   private String CREATOR;
   /** 更新时间 */
   private Date UPDATE_TIME;
   /** 更新人 */
   private String UPDATE_CREATOR;
   /** 状态 */
   private String STATE;
   
   public Integer getSS_ID() {
      return SS_ID;
   }
   
   /** @param newSS_ID */
   public void setSS_ID(Integer newSS_ID) {
      SS_ID = newSS_ID;
   }
   
   public String getSS_NAME() {
      return SS_NAME;
   }
   
   /** @param newSS_NAME */
   public void setSS_NAME(String newSS_NAME) {
      SS_NAME = newSS_NAME;
   }
   
   public String getSS_HOME() {
      return SS_HOME;
   }
   
   /** @param newSS_HOME */
   public void setSS_HOME(String newSS_HOME) {
      SS_HOME = newSS_HOME;
   }
   
   public String getSS_KETWORDS() {
      return SS_KETWORDS;
   }
   
   /** @param newSS_KETWORDS */
   public void setSS_KETWORDS(String newSS_KETWORDS) {
      SS_KETWORDS = newSS_KETWORDS;
   }
   
   public String getSS_DESCRIBE() {
      return SS_DESCRIBE;
   }
   
   /** @param newSS_DESCRIBE */
   public void setSS_DESCRIBE(String newSS_DESCRIBE) {
      SS_DESCRIBE = newSS_DESCRIBE;
   }
   
   public String getSS_DOMAIN() {
      return SS_DOMAIN;
   }
   
   /** @param newSS_DOMAIN */
   public void setSS_DOMAIN(String newSS_DOMAIN) {
      SS_DOMAIN = newSS_DOMAIN;
   }
   
   public String getSS_IP() {
      return SS_IP;
   }
   
   /** @param newSS_IP */
   public void setSS_IP(String newSS_IP) {
      SS_IP = newSS_IP;
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
   
   public String getUPDATE_CREATOR() {
      return UPDATE_CREATOR;
   }
   
   /** @param newUPDATE_CREATOR */
   public void setUPDATE_CREATOR(String newUPDATE_CREATOR) {
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