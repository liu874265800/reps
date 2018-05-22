/***********************************************************************
 * Module:  AdminOperateRecord.java
 * Author:  VIC
 * Purpose: Defines the Class AdminOperateRecord
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 管理员操作记录 */
public class AdminOperateRecord {
   private Integer AOR_ID;
   /** 操作人(管理员账号) */
   private String CREATOR;
   /** 操作目标(例如:添加商品,来源于权限表数据) */
   private String OPERATE_TARGET;
   /** 操作时间 */
   private Date OPERATE_TIME;
   /** 操作详情 */
   private String OPERATE_DETAIL;
   
   public Integer getAOR_ID() {
      return AOR_ID;
   }
   
   /** @param newAOR_ID */
   public void setAOR_ID(Integer newAOR_ID) {
      AOR_ID = newAOR_ID;
   }
   
   public String getCREATOR() {
      return CREATOR;
   }
   
   /** @param newCREATOR */
   public void setCREATOR(String newCREATOR) {
      CREATOR = newCREATOR;
   }
   
   public String getOPERATE_TARGET() {
      return OPERATE_TARGET;
   }
   
   /** @param newOPERATE_TARGET */
   public void setOPERATE_TARGET(String newOPERATE_TARGET) {
      OPERATE_TARGET = newOPERATE_TARGET;
   }
   
   public Date getOPERATE_TIME() {
      return OPERATE_TIME;
   }
   
   /** @param newOPERATE_TIME */
   public void setOPERATE_TIME(Date newOPERATE_TIME) {
      OPERATE_TIME = newOPERATE_TIME;
   }
   
   public String getOPERATE_DETAIL() {
      return OPERATE_DETAIL;
   }
   
   /** @param newOPERATE_DETAIL */
   public void setOPERATE_DETAIL(String newOPERATE_DETAIL) {
      OPERATE_DETAIL = newOPERATE_DETAIL;
   }

}