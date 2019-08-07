package com.sun.demo.viewmodel;

import com.sun.demo.data.ItemDataBean;
import com.sun.demo.data.UserBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class BFragmentModel {

    public void getData(Observer observer) {

        List<ItemDataBean> itemDataBeans = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ItemDataBean itemDataBean = new ItemDataBean();
            List<UserBean> userBeans = new ArrayList<>();
            itemDataBean.setType(i);
            for (int j = 0; j < 2; j++) {
                UserBean userBean = new UserBean();
                userBean.setAge(j + i);
                userBeans.add(userBean);
            }
            itemDataBeans.add(itemDataBean);
        }

        observer.onNext(itemDataBeans);

    }

}
