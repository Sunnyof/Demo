package com.sun.login.viewmodel;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sun.login.databinding.ActivityLoginBinding;
import com.sun.login.bean.UserBean;
import com.sun.login.model.LoginModel;

import androidx.databinding.ObservableField;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginViewModel {

    private LoginModel loginModel;

    public final ObservableField<String> phone = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    ActivityLoginBinding activityLoginBinding;

    public LoginViewModel(ActivityLoginBinding acctivityLoginBinding) {
        this.activityLoginBinding = acctivityLoginBinding;
        loginModel = new LoginModel();
    }

    Disposable mDisposable;

    public void submit() {

        String password = activityLoginBinding.password.getText().toString();
        String phone = activityLoginBinding.phone.getText().toString();
        Observer<UserBean> observer = new Observer<UserBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(UserBean value) {
                System.out.println("value" + value);
                if ("2".equals(value)) {
                    mDisposable.dispose();
                    return;
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage() + "error");
            }

            @Override
            public void onComplete() {
                ARouter.getInstance().build("/home/index").withString("url","http://baidu.com").navigation();
                System.out.println("onComplete");
            }
        };
        loginModel.thirdLogin(observer, phone, password);

    }

}
