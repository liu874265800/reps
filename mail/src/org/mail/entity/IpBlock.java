/***********************************************************************
 * Module:  IpBlock.java
 * Author:  VIC
 * Purpose: Defines the Class IpBlock
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** IP黑名单 */
public class IpBlock {
   /** ID */
   private Integer IB_ID;
   /** IP地址 */
   private String IB_IP;
   /** 创建时间 */
   private Date CREATE_TIME;
   /** 创建人 */
   private String CREATOR;
   /** 更新时间 */
   private Date UPDATE_TIME;
   /** 更新人 */
   private String UPDATE_CREATOR;
   /** 状态 */
   private String STATE;
   
   public Integer getIB_ID() {
      return IB_ID;
   }
   
   /** @param newIB_ID */
   public void setIB_ID(Integer newIB_ID) {
      IB_ID = newIB_ID;
   }
   
   public String getIB_IP() {
      return IB_IP;
   }
   
   /** @param newIB_IP */
   public void setIB_IP(String newIB_IP) {
      IB_IP = newIB_IP;
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