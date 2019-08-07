package com.sun.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sun.demo.R;
import com.sun.demo.data.ItemDataBean;
import com.sun.demo.viewmodel.BFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

public class BFragmentAdapter<T extends BFragmentViewModel> extends RecyclerView.Adapter {
    private Context context;
    List mData = new ArrayList<>();

    public void setmData(List mData) {
        this.mData = mData;
    }

    public BFragmentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = null;
        switch (viewType) {
            case 0:
                binding = DataBindingUtil.inflate(
                        LayoutInflater.from(context), R.layout.item_header, parent, false);
                break;
            case 1:
                binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_footer, parent, false);
                break;
            default:
                binding = DataBindingUtil.inflate(
                        LayoutInflater.from(context), R.layout.item_header, parent, false);
                break;
        }

//        if(binding == null){
        System.err.println("-----------" + viewType + "--------");
//        }
        return new CustomViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomViewHolder customViewHolder = (CustomViewHolder) holder;
//        ((CustomViewHolder) holder).mBinding.setVariable(BR.viewModel,)
    }

    @Override
    public int getItemViewType(int position) {
        ItemDataBean itemDataBean = (ItemDataBean) mData.get(position);
        return itemDataBean.getType();
    }

    @Override
    public int getItemCount() {
        System.out.println(mData.size() + "--11--");
        return mData.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mBinding;

        public CustomViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }

}
