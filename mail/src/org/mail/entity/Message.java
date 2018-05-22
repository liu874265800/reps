/***********************************************************************
 * Module:  Message.java
 * Author:  VIC
 * Purpose: Defines the Class Message
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 注册短信，订单短信，支付短信，验证码短信 */
public class Message {
   private Integer M_ID;
   private String M_TITLE;
   private String M_CONTENT;
   private String M_PHONE;
   private Date M_SEND_TIME;
   private String M_SEND_STATE;
   private String M_TYPE;
   private Date CREATE_TIME;
   private String CREATOR;
   private String STATE;
   
   public Integer getM_ID() {
      return M_ID;
   }
   
   /** @param newM_ID */
   public void setM_ID(Integer newM_ID) {
      M_ID = newM_ID;
   }
   
   public String getM_TITLE() {
      return M_TITLE;
   }
   
   /** @param newM_TITLE */
   public void setM_TITLE(String newM_TITLE) {
      M_TITLE = newM_TITLE;
   }
   
   public String getM_CONTENT() {
      return M_CONTENT;
   }
   
   /** @param newM_CONTENT */
   public void setM_CONTENT(String newM_CONTENT) {
      M_CONTENT = newM_CONTENT;
   }
   
   public String getM_PHONE() {
      return M_PHONE;
   }
   
   /** @param newM_PHONE */
   public void setM_PHONE(String newM_PHONE) {
      M_PHONE = newM_PHONE;
   }
   
   public Date getM_SEND_TIME() {
      return M_SEND_TIME;
   }
   
   /** @param newM_SEND_TIME */
   public void setM_SEND_TIME(Date newM_SEND_TIME) {
      M_SEND_TIME = newM_SEND_TIME;
   }
   
   public String getM_SEND_STATE() {
      return M_SEND_STATE;
   }
   
   /** @param newM_SEND_STATE */
   public void setM_SEND_STATE(String newM_SEND_STATE) {
      M_SEND_STATE = newM_SEND_STATE;
   }
   
   public String getM_TYPE() {
      return M_TYPE;
   }
   
   /** @param newM_TYPE */
   public void setM_TYPE(String newM_TYPE) {
      M_TYPE = newM_TYPE;
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
   
   public String getSTATE() {
      return STATE;
   }
   
   /** @param newSTATE */
   public void setSTATE(String newSTATE) {
      STATE = newSTATE;
   }

}