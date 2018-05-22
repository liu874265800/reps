/***********************************************************************
 * Module:  Email.java
 * Author:  VIC
 * Purpose: Defines the Class Email
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 系统邮件，注册邮件，订单邮件 */
public class Email {
   private Integer E_ID;
   private String E_TITLE;
   private String E_CONTENT;
   private String E_EMAIL;
   private Date E_SEND_TIME;
   private Date CREATE_TIME;
   private String CREATOR;
   private String E_SEND_STATE;
   private String STATE;
   private String E_TYPE;
   
   public Integer getE_ID() {
      return E_ID;
   }
   
   /** @param newE_ID */
   public void setE_ID(Integer newE_ID) {
      E_ID = newE_ID;
   }
   
   public String getE_TITLE() {
      return E_TITLE;
   }
   
   /** @param newE_TITLE */
   public void setE_TITLE(String newE_TITLE) {
      E_TITLE = newE_TITLE;
   }
   
   public String getE_CONTENT() {
      return E_CONTENT;
   }
   
   /** @param newE_CONTENT */
   public void setE_CONTENT(String newE_CONTENT) {
      E_CONTENT = newE_CONTENT;
   }
   
   public String getE_EMAIL() {
      return E_EMAIL;
   }
   
   /** @param newE_EMAIL */
   public void setE_EMAIL(String newE_EMAIL) {
      E_EMAIL = newE_EMAIL;
   }
   
   public Date getE_SEND_TIME() {
      return E_SEND_TIME;
   }
   
   /** @param newE_SEND_TIME */
   public void setE_SEND_TIME(Date newE_SEND_TIME) {
      E_SEND_TIME = newE_SEND_TIME;
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
   
   public String getE_SEND_STATE() {
      return E_SEND_STATE;
   }
   
   /** @param newE_SEND_STATE */
   public void setE_SEND_STATE(String newE_SEND_STATE) {
      E_SEND_STATE = newE_SEND_STATE;
   }
   
   public String getSTATE() {
      return STATE;
   }
   
   /** @param newSTATE */
   public void setSTATE(String newSTATE) {
      STATE = newSTATE;
   }
   
   public String getE_TYPE() {
      return E_TYPE;
   }
   
   /** @param newE_TYPE */
   public void setE_TYPE(String newE_TYPE) {
      E_TYPE = newE_TYPE;
   }

}