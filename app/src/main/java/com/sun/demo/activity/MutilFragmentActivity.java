package com.sun.demo.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.sun.demo.R;
import com.sun.demo.fragment.ChangFragment;
import com.sun.demo.fragment.TestFragment;

import androidx.annotation.Nullable;

public class MutilFragmentActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutilfragment);
        android.app.FragmentManager manager = getFragmentManager();
        android.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment1, new TestFragment());
        transaction.commit();
//        View fragment = findViewById(R.id.fragment1);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                android.app.FragmentManager manager = getFragmentManager();
                android.app.FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment1, new ChangFragment());
                transaction.commit();
            }
        }, 2000);

    }

    Handler handler = new Handler();

}
