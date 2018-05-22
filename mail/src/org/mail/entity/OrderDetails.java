/***********************************************************************
 * Module:  OrderDetails.java
 * Author:  VIC
 * Purpose: Defines the Class OrderDetails
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 订单详情 */
public class OrderDetails {
   /** 订单详情ID */
   private Integer OD_ID;
   /** 商品ID */
   private Integer C_ID;
   /** 商品数量 */
   private Integer C_NUMBER;
   /** 商品单价 */
   private float C_PRICE;
   /** 状态 */
   private String STATE;
   /** 订单ID */
   private Integer O_ID;
   /** 创建时间 */
   private Date CREATE_TIME;
   
   public Integer getOD_ID() {
      return OD_ID;
   }
   
   /** @param newOD_ID */
   public void setOD_ID(Integer newOD_ID) {
      OD_ID = newOD_ID;
   }
   
   public Integer getC_ID() {
      return C_ID;
   }
   
   /** @param newC_ID */
   public void setC_ID(Integer newC_ID) {
      C_ID = newC_ID;
   }
   
   public Integer getC_NUMBER() {
      return C_NUMBER;
   }
   
   /** @param newC_NUMBER */
   public void setC_NUMBER(Integer newC_NUMBER) {
      C_NUMBER = newC_NUMBER;
   }
   
   public float getC_PRICE() {
      return C_PRICE;
   }
   
   /** @param newC_PRICE */
   public void setC_PRICE(float newC_PRICE) {
      C_PRICE = newC_PRICE;
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