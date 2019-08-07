package com.sun.demo.viewmodel;

import com.sun.demo.RetrofitManager;
import com.sun.demo.data.WeatherData;
import com.sun.demo.data.WeatherInfo;
import com.sun.demo.request.ILogin;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel {

    public final ObservableBoolean loading = new ObservableBoolean(false);
    public final ObservableBoolean loadingSuccess = new ObservableBoolean(false);
    public final ObservableBoolean loadingFailure = new ObservableBoolean(false);
    public final ObservableField<String> city = new ObservableField<>();
    public final ObservableField<String> temp1 = new ObservableField<>();
    public final ObservableField<String> temp2 = new ObservableField<>();
    public final ObservableField<String> weather = new ObservableField<>();
    public final ObservableField<String> time = new ObservableField<>();
    public final ObservableField<String> cityId = new ObservableField<>();

    Call<WeatherData> mCall;

    public void queryWeather() {
        loading.set(true);
        loadingSuccess.set(false);
        loadingFailure.set(false);

        mCall = RetrofitManager.getRetrofit().create(ILogin.class).queryWeather();

        mCall.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                System.out.println(response.code()+"---");
                WeatherInfo weatherInfo = response.body().getWeatherinfo();
                city.set(weatherInfo.getCity());
                cityId.set(weatherInfo.getCityid());
                temp1.set(weatherInfo.getTemp1());
                temp2.set(weatherInfo.getTemp2());
                weather.set(weatherInfo.getWeather());
                time.set(weatherInfo.getPtime());

                loading.set(false);
                loadingSuccess.set(true);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                loading.set(false);
                loadingFailure.set(true);
            }
        });
    }

    public void cancelRequest() {
        if (mCall != null) {
            mCall.cancel();
        }
    }
}
