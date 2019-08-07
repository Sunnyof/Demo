package com.sun.demo.request;

import com.sun.demo.data.UserBean;
import com.sun.demo.data.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ILogin {

    @GET("data/cityinfo/101210101.html")
    Call<WeatherData> queryWeather();

}
