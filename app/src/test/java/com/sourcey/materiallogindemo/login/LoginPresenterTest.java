package com.sourcey.materiallogindemo.login;

import com.sourcey.materiallogindemo.data.MyServiceRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Unit tests for the implementation of {@link LoginPresenter}
 */
public class LoginPresenterTest {


    String validEmail = "a@v.com";
    String validPassword = "123456789";

    String inValidEmail = "not valid";
    String inValidPassword = "123";
    @Mock
    MyServiceRepository repository;

    @Mock
    LoginContract.View loginView;

    private LoginPresenter loginPresenter;

    @Before
    public void setupLoginPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(repository, loginView);
    }


    @Test
    public void clickOnLogin_loginSuccess() {
        loginPresenter.login(validEmail, validPassword);
        verify(loginView).setLoginButton(false);
    }

}
