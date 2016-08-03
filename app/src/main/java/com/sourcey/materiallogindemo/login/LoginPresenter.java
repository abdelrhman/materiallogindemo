package com.sourcey.materiallogindemo.login;

import com.sourcey.materiallogindemo.data.MyServiceRepository;
import com.sourcey.materiallogindemo.util.ValidationUtils;

/**
 * Created by talat on 29-07-2016.
 */
public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View loginView;
    MyServiceRepository repository;

    public LoginPresenter(MyServiceRepository repository, LoginContract.View view) {
        this.loginView = view;
        this.repository = repository;
        loginView.setPresenter(this);
    }

    @Override
    public void login(String email, String password) {

        loginView.setLoginButton(false);
        if(!isValid(email, password)){
            loginView.setLoginButton(true);
            return;
        }
        loginView.setProgressDialog(true);
        repository.getUserToken(new MyServiceRepository.ServiceCallback() {
            @Override
            public void success(String token) {
                loginView.setLoginButton(true);
                loginView.setProgressDialog(false);
                loginView.showHomeView();
            }

            @Override
            public void fail() {
                loginView.setLoginButton(true);
                loginView.setProgressDialog(false);

            }
        });

    }

    private boolean isValid(String email, String password) {
        ValidationUtils validationUtils = new ValidationUtils();
        if(!validationUtils.isEmailValid(email)){
            loginView.setEmailError("Enter a valid email");
            return false;
        }else{
            loginView.setEmailError(null);
        }

        if(!validationUtils.isPasswordValid(password)){
            loginView.setPasswordError("Enter a valid password");
            return false;
        }else{
            loginView.setPasswordError(null);
        }

        return true;
    }

    @Override
    public void signUp() {
        loginView.showSignupView();
    }

    @Override
    public void openHome() {
        loginView.showHomeView();
    }

    @Override
    public void start() {

    }
}
