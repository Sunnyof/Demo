package com.sun.demo.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.sun.demo.R;

import java.util.zip.Inflater;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class TabView {

    public static View getTabView(Context context, int position) {

        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_tab, null, false);

//        View view = View.inflate(context, R.layout.view_tab, null);
        View view = LayoutInflater.from(context).inflate(R.layout.view_tab, null, false);
        TextView textView = view.findViewById(R.id.tab_text);
        textView.setText(position + "-");
        return view;

    }

}
