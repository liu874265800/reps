/***********************************************************************
 * Module:  Auth.java
 * Author:  VIC
 * Purpose: Defines the Class Auth
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 管理后台系统权限 */
public class Auth {
   /** 权限ID */
   private Integer AUTH_ID;
   /** 权限名称 */
   private String AUTH_NAME;
   /** 权限代码 */
   private String AUTH_CODE;
   /** 权限URL */
   private String AUTH_URL;
   /** 创建时间 */
   private Date CREATE_TIME;
   /** 创建人(默认为系统,否则为管理员) */
   private String CREATOR;
   /** 更新时间 */
   private Date UPDATE_TIME;
   /** 更新人(默认为系统,否则为管理员账号) */
   private String UPDATE_CREATOR;
   /** 状态 */
   private String STATE;
   
   public Integer getAUTH_ID() {
      return AUTH_ID;
   }
   
   /** @param newAUTH_ID */
   public void setAUTH_ID(Integer newAUTH_ID) {
      AUTH_ID = newAUTH_ID;
   }
   
   public String getAUTH_NAME() {
      return AUTH_NAME;
   }
   
   /** @param newAUTH_NAME */
   public void setAUTH_NAME(String newAUTH_NAME) {
      AUTH_NAME = newAUTH_NAME;
   }
   
   public String getAUTH_CODE() {
      return AUTH_CODE;
   }
   
   /** @param newAUTH_CODE */
   public void setAUTH_CODE(String newAUTH_CODE) {
      AUTH_CODE = newAUTH_CODE;
   }
   
   public String getAUTH_URL() {
      return AUTH_URL;
   }
   
   /** @param newAUTH_URL */
   public void setAUTH_URL(String newAUTH_URL) {
      AUTH_URL = newAUTH_URL;
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