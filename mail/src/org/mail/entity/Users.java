/***********************************************************************
 * Module:  Users.java
 * Author:  VIC
 * Purpose: Defines the Class Users
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 用户 */
public class Users {
   /** 用户ID */
   private Integer USERID;
   /** 用户名 */
   private String UNAME;
   /** 用户登录账号 */
   private String UACCOUNT;
   /** 用户登录密码 */
   private String UPASSWORD;
   /** 用户性别 */
   private String USEX;
   /** 用户年龄 */
   private Integer UAGE;
   /** 用户头像 */
   private String UHEAD;
   /** 用户邮箱 */
   private String UEMAIL;
   /** 用户手机 */
   private String UPHONE;
   /** 用户状态 */
   private String STATE;
   /** 注册时间 */
   private Date CREATETIME;
   
   public Integer getUSERID() {
      return USERID;
   }
   
   /** @param newUSERID */
   public void setUSERID(Integer newUSERID) {
      USERID = newUSERID;
   }
   
   public String getUNAME() {
      return UNAME;
   }
   
   /** @param newUNAME */
   public void setUNAME(String newUNAME) {
      UNAME = newUNAME;
   }
   
   public String getUACCOUNT() {
      return UACCOUNT;
   }
   
   /** @param newUACCOUNT */
   public void setUACCOUNT(String newUACCOUNT) {
      UACCOUNT = newUACCOUNT;
   }
   
   public String getUPASSWORD() {
      return UPASSWORD;
   }
   
   /** @param newUPASSWORD */
   public void setUPASSWORD(String newUPASSWORD) {
      UPASSWORD = newUPASSWORD;
   }
   
   public String getUSEX() {
      return USEX;
   }
   
   /** @param newUSEX */
   public void setUSEX(String newUSEX) {
      USEX = newUSEX;
   }
   
   public Integer getUAGE() {
      return UAGE;
   }
   
   /** @param newUAGE */
   public void setUAGE(Integer newUAGE) {
      UAGE = newUAGE;
   }
   
   public String getUHEAD() {
      return UHEAD;
   }
   
   /** @param newUHEAD */
   public void setUHEAD(String newUHEAD) {
      UHEAD = newUHEAD;
   }
   
   public String getUEMAIL() {
      return UEMAIL;
   }
   
   /** @param newUEMAIL */
   public void setUEMAIL(String newUEMAIL) {
      UEMAIL = newUEMAIL;
   }
   
   public String getUPHONE() {
      return UPHONE;
   }
   
   /** @param newUPHONE */
   public void setUPHONE(String newUPHONE) {
      UPHONE = newUPHONE;
   }
   
   public String getSTATE() {
      return STATE;
   }
   
   /** @param newSTATE */
   public void setSTATE(String newSTATE) {
      STATE = newSTATE;
   }
   
   public Date getCREATETIME() {
      return CREATETIME;
   }
   
   /** @param newCREATETIME */
   public void setCREATETIME(Date newCREATETIME) {
      CREATETIME = newCREATETIME;
   }

}