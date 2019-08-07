package com.sun.login.request;

import com.sun.login.bean.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface LoginRequest {

    @POST("Api/Auth/login")
    Observable<UserBean> login(@QueryMap Map<String, String> map);

}
