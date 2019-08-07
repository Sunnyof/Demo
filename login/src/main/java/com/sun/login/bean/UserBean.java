package com.sun.login.bean;

public class UserBean {
  private int code;
  private String msg;
  private UserData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    class UserData{
      private int user_id;
      private String email;
      private String realname;
      private String paypwd;
      private String birthday;
      private int sex;
      private String user_money;
      private String frozen_money;
      private String distribut_money;
      private int pay_points;

      public int getUser_id() {
          return user_id;
      }

      public void setUser_id(int user_id) {
          this.user_id = user_id;
      }

      public String getEmail() {
          return email;
      }

      public void setEmail(String email) {
          this.email = email;
      }

      public String getRealname() {
          return realname;
      }

      public void setRealname(String realname) {
          this.realname = realname;
      }

      public String getPaypwd() {
          return paypwd;
      }

      public void setPaypwd(String paypwd) {
          this.paypwd = paypwd;
      }

      public String getBirthday() {
          return birthday;
      }

      public void setBirthday(String birthday) {
          this.birthday = birthday;
      }

      public int getSex() {
          return sex;
      }

      public void setSex(int sex) {
          this.sex = sex;
      }

      public String getUser_money() {
          return user_money;
      }

      public void setUser_money(String user_money) {
          this.user_money = user_money;
      }

      public String getFrozen_money() {
          return frozen_money;
      }

      public void setFrozen_money(String frozen_money) {
          this.frozen_money = frozen_money;
      }

      public String getDistribut_money() {
          return distribut_money;
      }

      public void setDistribut_money(String distribut_money) {
          this.distribut_money = distribut_money;
      }

      public int getPay_points() {
          return pay_points;
      }

      public void setPay_points(int pay_points) {
          this.pay_points = pay_points;
      }

    }

    @Override
    public String toString() {
        return "UserBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
