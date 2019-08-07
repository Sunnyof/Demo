package com.sun.login.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sun.login.R;
import com.sun.login.viewmodel.LoginViewModel;

import com.sun.login.databinding.ActivityLoginBinding;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

@Route(path = "/login/index")
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel viewModel = new LoginViewModel(activityLoginBinding);
        activityLoginBinding.setViewModel(viewModel);
    }
}
