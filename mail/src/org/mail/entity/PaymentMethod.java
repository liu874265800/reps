/***********************************************************************
 * Module:  PaymentMethod.java
 * Author:  VIC
 * Purpose: Defines the Class PaymentMethod
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 支付方式，支付平台，支付渠道 */
public class PaymentMethod {
   /** ID */
   private Integer PM_ID;
   /** 支付方式名称 */
   private String PM_NAME;
   /** 支付KEY */
   private String PM_KEY;
   /** 支付通知URL */
   private String PM_NOTICE;
   /** 支付URL */
   private String PM_URL;
   /** 支付Token */
   private String PM_TOKEN;
   /** 支付其他参数 */
   private String PM_OTHER;
   /** 状态 */
   private String STATE;
   /** 创建时间 */
   private Date CREATE_TIME;
   /** 创建人 */
   private String CREATOR;
   /** 更新时间 */
   private Date UPDATE_TIME;
   /** 更新人 */
   private String UPDATE_CREATOR;
   
   public Integer getPM_ID() {
      return PM_ID;
   }
   
   /** @param newPM_ID */
   public void setPM_ID(Integer newPM_ID) {
      PM_ID = newPM_ID;
   }
   
   public String getPM_NAME() {
      return PM_NAME;
   }
   
   /** @param newPM_NAME */
   public void setPM_NAME(String newPM_NAME) {
      PM_NAME = newPM_NAME;
   }
   
   public String getPM_KEY() {
      return PM_KEY;
   }
   
   /** @param newPM_KEY */
   public void setPM_KEY(String newPM_KEY) {
      PM_KEY = newPM_KEY;
   }
   
   public String getPM_NOTICE() {
      return PM_NOTICE;
   }
   
   /** @param newPM_NOTICE */
   public void setPM_NOTICE(String newPM_NOTICE) {
      PM_NOTICE = newPM_NOTICE;
   }
   
   public String getPM_URL() {
      return PM_URL;
   }
   
   /** @param newPM_URL */
   public void setPM_URL(String newPM_URL) {
      PM_URL = newPM_URL;
   }
   
   public String getPM_TOKEN() {
      return PM_TOKEN;
   }
   
   /** @param newPM_TOKEN */
   public void setPM_TOKEN(String newPM_TOKEN) {
      PM_TOKEN = newPM_TOKEN;
   }
   
   public String getPM_OTHER() {
      return PM_OTHER;
   }
   
   /** @param newPM_OTHER */
   public void setPM_OTHER(String newPM_OTHER) {
      PM_OTHER = newPM_OTHER;
   }
   
   public String getSTATE() {
      return STATE;
   }
   
   /** @param newSTATE */
   public void setSTATE(String newSTATE) {
      STATE = newSTATE;
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

}