/***********************************************************************
 * Module:  PaymentRecord.java
 * Author:  VIC
 * Purpose: Defines the Class PaymentRecord
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 支付记录 */
public class PaymentRecord {
   private Integer PR_ID;
   /** 支付方式 */
   private String PAYMENT_METHOD;
   /** 支付状态 */
   private String PAYMENT_STATE;
   /** 支付时间 */
   private Date PAYMENT_TIME;
   /** 支付总金额 */
   private float PAYMENT_TOTAL;
   /** 商品数量 */
   private double PAYMENT_NUMBER;
   /** 支付其他 */
   private String PAYMENT_OTHER;
   /** 状态 */
   private String STATE;
   /** 订单ID */
   private Integer O_ID;
   /** 创建时间 */
   private Date CREATE_TIME;
   
   public Integer getPR_ID() {
      return PR_ID;
   }
   
   /** @param newPR_ID */
   public void setPR_ID(Integer newPR_ID) {
      PR_ID = newPR_ID;
   }
   
   public String getPAYMENT_METHOD() {
      return PAYMENT_METHOD;
   }
   
   /** @param newPAYMENT_METHOD */
   public void setPAYMENT_METHOD(String newPAYMENT_METHOD) {
      PAYMENT_METHOD = newPAYMENT_METHOD;
   }
   
   public String getPAYMENT_STATE() {
      return PAYMENT_STATE;
   }
   
   /** @param newPAYMENT_STATE */
   public void setPAYMENT_STATE(String newPAYMENT_STATE) {
      PAYMENT_STATE = newPAYMENT_STATE;
   }
   
   public Date getPAYMENT_TIME() {
      return PAYMENT_TIME;
   }
   
   /** @param newPAYMENT_TIME */
   public void setPAYMENT_TIME(Date newPAYMENT_TIME) {
      PAYMENT_TIME = newPAYMENT_TIME;
   }
   
   public float getPAYMENT_TOTAL() {
      return PAYMENT_TOTAL;
   }
   
   /** @param newPAYMENT_TOTAL */
   public void setPAYMENT_TOTAL(float newPAYMENT_TOTAL) {
      PAYMENT_TOTAL = newPAYMENT_TOTAL;
   }
   
   public double getPAYMENT_NUMBER() {
      return PAYMENT_NUMBER;
   }
   
   /** @param newPAYMENT_NUMBER */
   public void setPAYMENT_NUMBER(double newPAYMENT_NUMBER) {
      PAYMENT_NUMBER = newPAYMENT_NUMBER;
   }
   
   public String getPAYMENT_OTHER() {
      return PAYMENT_OTHER;
   }
   
   /** @param newPAYMENT_OTHER */
   public void setPAYMENT_OTHER(String newPAYMENT_OTHER) {
      PAYMENT_OTHER = newPAYMENT_OTHER;
   }
   
   public String getSTATE() {
      return STATE;
   }
   
   /** @param newSTATE */
   public void setSTATE(String newSTATE) {
      STATE = newSTATE;
   }
   
   public Integer getO_ID() {
      return O_ID;
   }
   
   /** @param newO_ID */
   public void setO_ID(Integer newO_ID) {
      O_ID = newO_ID;
   }
   
   public Date getCREATE_TIME() {
      return CREATE_TIME;
   }
   
   /** @param newCREATE_TIME */
   public void setCREATE_TIME(Date newCREATE_TIME) {
      CREATE_TIME = newCREATE_TIME;
   }

}