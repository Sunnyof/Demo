package com.sun.demo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    //初始化布局文件
    public int setRecourseId() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setRecourseId());
        ButterKnife.bind(this);
    }
}
