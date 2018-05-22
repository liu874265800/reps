/***********************************************************************
 * Module:  Commodity.java
 * Author:  VIC
 * Purpose: Defines the Class Commodity
 ***********************************************************************/

package org.mail.entity;
import java.util.*;

/** 商品 */
public class Commodity {
   /** 商品ID */
   private Integer id;
   /** 商品名称 */
   private String name;
   /** 商品地址 */
   private String url;
   /** 商品描述 */
   private String describe;
   /** 商品关键字 */
   private String keywords;
   /** 商品价格 */
   private String price;
   /** 商品图片: 图片存储的相对路径或绝对路径 */
   private String pic;
   /** 商品状态: 新建/上架/下架/删除 */
   private String state;
   /** 创建时间(当前系统时间) */
   private Date createTime;
   /** 创建人(管理员账号) */
   private String creator;
   /** 更新时间(当前系统时间) */
   private Date updateTime;
   /** 更新人(管理员账号) */
   private String updateAreator;
   
   public Integer getId() {
      return id;
   }
   
   /** @param newId */
   public void setId(Integer newId) {
      id = newId;
   }
   
   public String getName() {
      return name;
   }
   
   /** @param newName */
   public void setName(String newName) {
      name = newName;
   }
   
   public String getUrl() {
      return url;
   }
   
   /** @param newUrl */
   public void setUrl(String newUrl) {
      url = newUrl;
   }
   
   public String getDescribe() {
      return describe;
   }
   
   /** @param newDescribe */
   public void setDescribe(String newDescribe) {
      describe = newDescribe;
   }
   
   public String getKeywords() {
      return keywords;
   }
   
   /** @param newKeywords */
   public void setKeywords(String newKeywords) {
      keywords = newKeywords;
   }
   
   public String getPrice() {
      return price;
   }
   
   /** @param newPrice */
   public void setPrice(String newPrice) {
      price = newPrice;
   }
   
   public String getPic() {
      return pic;
   }
   
   /** @param newPic */
   public void setPic(String newPic) {
      pic = newPic;
   }
   
   public String getState() {
      return state;
   }
   
   /** @param newState */
   public void setState(String newState) {
      state = newState;
   }
   
   public Date getCreateTime() {
      return createTime;
   }
   
   /** @param newCreateTime */
   public void setCreateTime(Date newCreateTime) {
      createTime = newCreateTime;
   }
   
   public String getCreator() {
      return creator;
   }
   
   /** @param newCreator */
   public void setCreator(String newCreator) {
      creator = newCreator;
   }
   
   public Date getUpdateTime() {
      return updateTime;
   }
   
   /** @param newUpdateTime */
   public void setUpdateTime(Date newUpdateTime) {
      updateTime = newUpdateTime;
   }
   
   public String getUpdateAreator() {
      return updateAreator;
   }
   
   /** @param newUpdateAreator */
   public void setUpdateAreator(String newUpdateAreator) {
      updateAreator = newUpdateAreator;
   }

}