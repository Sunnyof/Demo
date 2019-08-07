package com.sun.demo.activity;

import android.os.Bundle;

import com.sun.demo.R;
import com.sun.demo.databinding.ActivityWeatherBinding;
import com.sun.demo.viewmodel.LoginViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class WeatherActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    private ActivityWeatherBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);
        loginViewModel = new LoginViewModel();
        binding.setViewModel(loginViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
