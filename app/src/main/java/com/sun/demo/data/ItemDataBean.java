package com.sun.demo.data;

import java.util.List;
import java.util.Map;

public class ItemDataBean {

  private int type;
  private List<UserBean> userBean;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<UserBean> getUserBean() {
        return userBean;
    }

    public void setUserBean(List<UserBean> userBean) {
        this.userBean = userBean;
    }
}
