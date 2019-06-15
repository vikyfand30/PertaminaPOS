package com.tester.pertaminapos;

import com.tester.pertaminapos.model.api.request.ForgotPasswordRequest;
import com.tester.pertaminapos.model.api.request.LoginRequest;
import com.tester.pertaminapos.model.api.request.RegisterRequest;
import com.tester.pertaminapos.model.api.response.ForgotPasswordResponse;
import com.tester.pertaminapos.model.api.response.LoginResponse;
import com.tester.pertaminapos.model.api.response.RegisterResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface ApiService {


    @POST("login")
    Call<LoginResponse> callApiLogin(@HeaderMap Map<String, String> headers,
                                     @Body LoginRequest loginRequest);

    @POST("register")
    Call<RegisterResponse> callApiRegis(@HeaderMap Map<String, String> headers,
                                        @Body RegisterRequest registerRequest);


    @POST("forgot_password")
    Call<ForgotPasswordResponse> callApiForgot(@HeaderMap Map<String, String> headers,
                                               @Body ForgotPasswordRequest forgotPasswordRequest);
}
