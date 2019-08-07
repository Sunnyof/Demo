package com.sun.demo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.sun.demo.R;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends Activity {

    @BindView(R.id.red_grv)
    GridView redGridView;

    @BindView(R.id.blue_grv)
    GridView blueGridView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junqi);
        ButterKnife.bind(this);
    }


}
