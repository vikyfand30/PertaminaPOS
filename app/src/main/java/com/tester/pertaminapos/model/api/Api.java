package com.tester.pertaminapos.model.api;

import android.content.Context;

import com.tester.pertaminapos.ApiService;
import com.tester.pertaminapos.IConfig;
import com.tester.pertaminapos.PertaminaPos;
import com.tester.pertaminapos.model.api.request.ForgotPasswordRequest;
import com.tester.pertaminapos.model.api.request.LoginRequest;
import com.tester.pertaminapos.model.api.request.RegisterRequest;
import com.tester.pertaminapos.model.api.response.ForgotPasswordResponse;
import com.tester.pertaminapos.model.api.response.LoginResponse;
import com.tester.pertaminapos.model.api.response.RegisterResponse;

import java.util.HashMap;
import java.util.Map;

import app.beelabs.com.codebase.base.BaseApi;
import retrofit2.Callback;

public class Api extends BaseApi {

    private static Map<String, String> initHeader(Context context) {
        Map<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/json");

        return map;
    }

    private static ApiService initApiDomain(Context context) {
        getInstance().setApiDomain(IConfig.API_BASE_URL);
        return (ApiService) getInstance().setupApi(PertaminaPos.getAppComponent(), ApiService.class, true, 60);
    }

    synchronized public static void onLogin(LoginRequest loginRequest, Context context, Callback callback) {
        initApiDomain(context).callApiLogin(initHeader(context), loginRequest).enqueue((Callback<LoginResponse>) callback);
    }

    synchronized public static void onRegis(RegisterRequest registerRequest, Context context, Callback callback){
        initApiDomain(context).callApiRegis(initHeader(context), registerRequest).enqueue((Callback<RegisterResponse>) callback);
    }

    synchronized public static void onForgot(ForgotPasswordRequest forgotPasswordRequest, Context context, Callback callback){
        initApiDomain(context).callApiForgot(initHeader(context), forgotPasswordRequest).enqueue((Callback<ForgotPasswordResponse>) callback);
    }


}
