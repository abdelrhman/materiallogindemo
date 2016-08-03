package com.sourcey.materiallogindemo.login;

import com.sourcey.materiallogindemo.BasePresenter;
import com.sourcey.materiallogindemo.BaseView;

/**
 * Created by talat on 29-07-2016.
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void setLoginButton(boolean active);

        void setProgressDialog(boolean active);

        void setEmailError(String errorMessage);

        void setPasswordError(String errorMessage);

        void showSignupView();

        void showHomeView();


    }

    interface Presenter extends BasePresenter {
        void login(String email, String password);

        void signUp();

        void openHome();
    }
}
