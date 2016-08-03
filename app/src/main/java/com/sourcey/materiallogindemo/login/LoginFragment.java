package com.sourcey.materiallogindemo.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sourcey.materiallogindemo.R;
import com.sourcey.materiallogindemo.home.HomeActivity;
import com.sourcey.materiallogindemo.signup.SignupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by talat on 28-07-2016.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.input_email)
    EditText etEmail;
    @BindView(R.id.input_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginContract.Presenter loginPresenter;
    private ProgressDialog progressDialog;


    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, root);
        progressDialog = new ProgressDialog(this.getContext(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(getContext().getString(R.string.login_progeress_message));
        return root;
    }


    @OnClick(R.id.btn_login)
    public void login() {
        loginPresenter.login(etEmail.getText().toString(), etPassword.getText().toString());

    }

    @OnClick(R.id.link_signup)
    public void signUp() {
        loginPresenter.signUp();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP && resultCode == getActivity().RESULT_OK) {
            loginPresenter.openHome();
            this.getActivity().finish();

        }
    }

    @Override
    public void setLoginButton(boolean active) {
        btnLogin.setEnabled(active);
    }

    @Override
    public void setProgressDialog(boolean active) {
        if (active)
            progressDialog.show();
        else
            progressDialog.dismiss();

    }

    @Override
    public void setEmailError(String errorMessage) {
        etEmail.setError(errorMessage);

    }

    @Override
    public void setPasswordError(String errorMessage) {
        etPassword.setError(errorMessage);

    }

    @Override
    public void showSignupView() {
        Intent intent = new Intent(this.getContext(), SignupActivity.class);
        startActivityForResult(intent, REQUEST_SIGNUP);
    }

    @Override
    public void showHomeView() {
        startActivity(new Intent(this.getContext(), HomeActivity.class));
        getActivity().finish();
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        loginPresenter = presenter;
    }
}
