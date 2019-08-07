package com.sun.login.model;


import com.sun.login.request.RetrofitManager;
import com.sun.login.bean.UserBean;
import com.sun.login.request.LoginRequest;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginModel {

    public void thirdLogin(Observer<UserBean> observer, String phone, String password) {

        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("password", password);

        Observable<UserBean> observable1 = RetrofitManager.getRetrofit().create(LoginRequest.class).login(map);
        observable1.subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);

    }

}
