package com.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Component("User")
public class User implements Serializable,Cloneable{
     /** 用户Id */
    //@JSONField(name="userId")
    private String userId ;
    /** 用户名 */
    //@JSONField(name="userName")
    private String userName ;
    /** 用户密码 */
    @JSONField(name="passWord", serialize = false)
    private String passWord ;
    /** 乐观锁 */
    private Integer revision ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;

    /** 用户Id */
    public String getUserId(){
        return this.userId;
    }
    /** 用户Id */
    public void setUserId(String userId){
        this.userId = userId;
    }
    /** 用户名 */
    public String getUserName(){
        return this.userName;
    }
    /** 用户名 */
    public void setUserName(String userName){
        this.userName = userName;
    }
    /** 用户密码 */
    public String getPassWord(){
        return this.passWord;
    }
    /** 用户密码 */
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    /** 乐观锁 */
    public Integer getRevision(){
        return this.revision;
    }
    /** 乐观锁 */
    public void setRevision(Integer revision){
        this.revision = revision;
    }
    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", revision=" + revision +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}