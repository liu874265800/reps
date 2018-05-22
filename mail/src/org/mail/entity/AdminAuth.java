/***********************************************************************
 * Module:  AdminAuth.java
 * Author:  VIC
 * Purpose: Defines the Class AdminAuth
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 管理员权限表 */
public class AdminAuth {
   private Integer AA_ID;
   private Integer ADMIN_ID;
   private Integer AUTH_ID;
   
   public Integer getAA_ID() {
      return AA_ID;
   }
   
   /** @param newAA_ID */
   public void setAA_ID(Integer newAA_ID) {
      AA_ID = newAA_ID;
   }
   
   public Integer getADMIN_ID() {
      return ADMIN_ID;
   }
   
   /** @param newADMIN_ID */
   public void setADMIN_ID(Integer newADMIN_ID) {
      ADMIN_ID = newADMIN_ID;
   }
   
   public Integer getAUTH_ID() {
      return AUTH_ID;
   }
   
   /** @param newAUTH_ID */
   public void setAUTH_ID(Integer newAUTH_ID) {
      AUTH_ID = newAUTH_ID;
   }

}