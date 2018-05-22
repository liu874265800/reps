/***********************************************************************
 * Module:  DataScreMethod.java
 * Author:  VIC
 * Purpose: Defines the Class DataScreMethod
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 数据加密方式 */
public class DataScreMethod {
   /** ID */
   private double DSM_ID;
   /** 加密方式:MD5 */
   private String DSM_METHOD;
   /** 创建时间 */
   private Date CREATE_TIME;
   /** 创建人: 管理员账号 */
   private String CREATOR;
   /** 更新时间 */
   private Date UPDATE_TIME;
   /** 更新人:管理员账号 */
   private String UPDATE_CREATOR;
   /** 状态 */
   private String STATE;
   
   public double getDSM_ID() {
      return DSM_ID;
   }
   
   /** @param newDSM_ID */
   public void setDSM_ID(double newDSM_ID) {
      DSM_ID = newDSM_ID;
   }
   
   public String getDSM_METHOD() {
      return DSM_METHOD;
   }
   
   /** @param newDSM_METHOD */
   public void setDSM_METHOD(String newDSM_METHOD) {
      DSM_METHOD = newDSM_METHOD;
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