package com.sun.internet;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ILogin<T> {
    @POST("json.stml?city=上海")
    Call<T> getWeather();

}
