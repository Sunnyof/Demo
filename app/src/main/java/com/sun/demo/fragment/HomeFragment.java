package com.sun.demo.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sun.demo.R;
import com.sun.demo.adapter.BFragmentAdapter;
import com.sun.demo.data.ItemDataBean;
import com.sun.demo.databinding.FragmentOneBinding;
import com.sun.demo.viewmodel.BFragmentViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;

public class HomeFragment extends Fragment {

    private Observer observer;
    private RecyclerView recyclerView;
    BFragmentViewModel fragmentViewModel;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.fragment_one, container, false);
        FragmentOneBinding fragmentOneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);
        BFragmentAdapter adapter = new BFragmentAdapter(getContext());
        fragmentViewModel = new BFragmentViewModel(fragmentOneBinding, adapter);
        fragmentOneBinding.setViewModel(fragmentViewModel);
        View view = fragmentOneBinding.getRoot();
        fragmentOneBinding.recycleview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        fragmentOneBinding.recycleview.setAdapter(adapter);
        fragmentViewModel.showText();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
