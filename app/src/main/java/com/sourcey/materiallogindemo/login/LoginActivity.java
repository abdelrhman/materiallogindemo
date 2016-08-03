package com.sourcey.materiallogindemo.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sourcey.materiallogindemo.R;
import com.sourcey.materiallogindemo.data.MyServiceRepository;
import com.sourcey.materiallogindemo.util.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = LoginFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.content_frame);
        presenter = new LoginPresenter(new MyServiceRepository(), loginFragment);

    }

}
