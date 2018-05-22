/***********************************************************************
 * Module:  ShopingCart.java
 * Author:  VIC
 * Purpose: Defines the Class ShopingCart
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 购物车 */
public class ShopingCart {
   /** 购物车主键 */
   private Integer SC_ID;
   /** 商品ID */
   private Integer C_ID;
   /** 商品数量 */
   private Integer C_NUMBER;
   /** 商品单价 */
   private float C_PRICE;
   /** 商品名称 */
   private String C_NAME;
   /** 用户ID */
   private Integer U_ID;
   
   public Integer getSC_ID() {
      return SC_ID;
   }
   
   /** @param newSC_ID */
   public void setSC_ID(Integer newSC_ID) {
      SC_ID = newSC_ID;
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
   
   public String getC_NAME() {
      return C_NAME;
   }
   
   /** @param newC_NAME */
   public void setC_NAME(String newC_NAME) {
      C_NAME = newC_NAME;
   }
   
   public Integer getU_ID() {
      return U_ID;
   }
   
   /** @param newU_ID */
   public void setU_ID(Integer newU_ID) {
      U_ID = newU_ID;
   }

}