/***********************************************************************
 * Module:  Order.java
 * Author:  VIC
 * Purpose: Defines the Class Order
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 订单 */
public class Order {
   /** 订单ID */
   private Integer O_ID;
   private float O_PRICE;
   private Date CREATE_TIME;
   private String O_STATE;
   /** 用户ID */
   private Integer U_ID;
   /** 订单号:系统生成 */
   private String O_NUMBER;
   
   public Integer getO_ID() {
      return O_ID;
   }
   
   /** @param newO_ID */
   public void setO_ID(Integer newO_ID) {
      O_ID = newO_ID;
   }
   
   public float getO_PRICE() {
      return O_PRICE;
   }
   
   /** @param newO_PRICE */
   public void setO_PRICE(float newO_PRICE) {
      O_PRICE = newO_PRICE;
   }
   
   public Date getCREATE_TIME() {
      return CREATE_TIME;
   }
   
   /** @param newCREATE_TIME */
   public void setCREATE_TIME(Date newCREATE_TIME) {
      CREATE_TIME = newCREATE_TIME;
   }
   
   public String getO_STATE() {
      return O_STATE;
   }
   
   /** @param newO_STATE */
   public void setO_STATE(String newO_STATE) {
      O_STATE = newO_STATE;
   }
   
   public Integer getU_ID() {
      return U_ID;
   }
   
   /** @param newU_ID */
   public void setU_ID(Integer newU_ID) {
      U_ID = newU_ID;
   }
   
   public String getO_NUMBER() {
      return O_NUMBER;
   }
   
   /** @param newO_NUMBER */
   public void setO_NUMBER(String newO_NUMBER) {
      O_NUMBER = newO_NUMBER;
   }

}