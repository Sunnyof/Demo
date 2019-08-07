package com.sun.demo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.tabs.TabLayout;
import com.sun.demo.R;
import com.sun.demo.adapter.HomeAdapter;
import com.sun.demo.widget.TabView;

import java.net.DatagramSocket;
import java.net.SocketException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

@Route(path = "/home/index")
public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.home_viewpager)
    ViewPager viewPager;

    @BindView(R.id.home_tab)
    TabLayout tabLayout;

    @Autowired
    int type;

    private Observer observer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ARouter.getInstance().inject(this);
        ButterKnife.bind(this);
        viewPager.setAdapter(new HomeAdapter(getSupportFragmentManager()));
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < 3; i++) {
            tabLayout.getTabAt(i).setCustomView(TabView.getTabView(this, i));
        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.tab_text);
                ImageView imageView = tab.getCustomView().findViewById(R.id.tab_img);
                imageView.setBackgroundColor(Color.BLUE);
                textView.setText(tab.getPosition() + "");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public  void startUDPSocket() throws SocketException {
        DatagramSocket client = new DatagramSocket(1883);
    }


}
