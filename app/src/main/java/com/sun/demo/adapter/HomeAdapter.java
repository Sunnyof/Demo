package com.sun.demo.adapter;

import com.sun.demo.fragment.HomeFragment;
import com.sun.demo.fragment.ArticleFragment;
import com.sun.demo.fragment.BagFragment;
import com.sun.demo.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments = new ArrayList<>();

    public void initFragmentData() {
        fragments.add(new HomeFragment());
        fragments.add(new BagFragment());
        fragments.add(new ArticleFragment());
        fragments.add(new UserFragment());
    }


    public HomeAdapter(@NonNull FragmentManager fm) {
        super(fm);
        initFragmentData();

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Hello";
    }
}
