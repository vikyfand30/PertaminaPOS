package com.tester.pertaminapos.presenter.dao;

import com.tester.pertaminapos.model.api.Api;
import com.tester.pertaminapos.model.api.request.ForgotPasswordRequest;
import com.tester.pertaminapos.model.api.request.LoginRequest;
import com.tester.pertaminapos.model.api.request.RegisterRequest;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import retrofit2.Callback;

public class AuthDao extends BaseDao {
    public AuthDao(Object obj) {
        super(obj);
    }

    public void onLogin(LoginRequest model, BaseActivity ac, Callback callback) {
        Api.onLogin(model, ac, callback);
    }

    public void onRegis(RegisterRequest model, BaseActivity ac, Callback callback){
        Api.onRegis(model, ac, callback);
    }

    public void onForgot(ForgotPasswordRequest model, BaseActivity ac, Callback callback){
        Api.onForgot(model, ac, callback);
    }
}
