package com.sun.demo.viewmodel;

import com.sun.demo.adapter.BFragmentAdapter;
import com.sun.demo.data.ItemDataBean;
import com.sun.demo.databinding.FragmentOneBinding;

import java.util.List;


import androidx.databinding.ObservableField;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class BFragmentViewModel {

    FragmentOneBinding foBinding;
    private BFragmentAdapter bFragmentAdapter;
    private List<ItemDataBean> itemDataBeans;

    public ObservableField<List<BFragmentViewModelItem>> listObservableField = new ObservableField<>();


    public BFragmentViewModel(FragmentOneBinding foBinding, BFragmentAdapter bFragmentAdapter) {
        this.foBinding = foBinding;
        this.bFragmentAdapter = bFragmentAdapter;
    }


    public void changePage(Observer observer, int position) {
        observer.onNext(position);
    }

    public void showText() {

        Observer<List<ItemDataBean>> observer = new Observer<List<ItemDataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<ItemDataBean> value) {
                System.out.println(value.size()+"---");
                bFragmentAdapter.setmData(value);
                foBinding.recycleview.setAdapter(bFragmentAdapter);
//                bFragmentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        new BFragmentModel().getData(observer);

    }

}
