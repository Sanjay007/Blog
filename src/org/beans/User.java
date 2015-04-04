/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.beans;

/**
 *
 * @author s.yadav
 */
public class User {
 private   int uid;
 private String userId;
 private   String email;
 private  String userName;
 private   String passWord;
 private  String role;
 private   String domain;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    
   

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    public Object [] getRow(){
        return new Object[]{this.uid,this.userId,this.email,this.userName,this.passWord, this.role, this.domain};
    }
      public String getIdAsString(){
      
          return String.valueOf(this.uid);
      }
}
