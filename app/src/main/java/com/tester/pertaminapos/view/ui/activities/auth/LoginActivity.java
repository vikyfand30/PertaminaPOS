package com.tester.pertaminapos.view.ui.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tester.pertaminapos.IConfig;
import com.tester.pertaminapos.PertaminaPos;
import com.tester.pertaminapos.R;
import com.tester.pertaminapos.presenter.dao.AuthDao;
import com.tester.pertaminapos.model.api.request.LoginRequest;
import com.tester.pertaminapos.model.api.response.LoginResponse;
import com.tester.pertaminapos.view.ui.dialog.ForgotPasswordDialog;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.base.response.BaseResponse;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    EditText txt_email;
    EditText txt_pw;
    Button btn_login;
    TextView tv_forgot;
    TextView tv_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initComponent();
        initContent();


    }

    private void initComponent() {

        txt_email = findViewById(R.id.txt_email);
        txt_pw = findViewById(R.id.txt_pw);
        btn_login = findViewById(R.id.btn_login);
        tv_forgot = findViewById(R.id.forgotPass);
        tv_regist = findViewById(R.id.tv_regist);
    }

    private void initContent() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallApiLogin();

            }
        });



    }

    public void serve(View v)
    {
        Intent i=new Intent();
        i.setClass(this,RegisterActivity.class);
        startActivity(i);
    }

    public void forgot(View v)
    {
        Intent i=new Intent();
        i.setClass(this, ForgotPasswordDialog.class);
        startActivity(i);
    }

    public void onCallApiLogin() {
        final AuthDao dao = new AuthDao(this);
        final LoginRequest model = new LoginRequest();
        model.setEmail(txt_email.getText().toString());
        model.setPassword(txt_pw.getText().toString());
        showApiProgressDialog(PertaminaPos.getAppComponent(), new AuthDao(this) {
            @Override
            public void call() {
                dao.onLogin(model, LoginActivity.this, BaseDao.getInstance(LoginActivity.this,
                        IConfig.KEY_API_LOGIN).callback);
            }
        });
    }

    @Override
    protected void onApiResponseCallback(BaseResponse br, int responseCode, Response response) {
        super.onApiResponseCallback(br, responseCode, response);
        if (response.isSuccessful()) {
            if (responseCode == IConfig.KEY_API_LOGIN) {
                LoginResponse data = (LoginResponse) br;
                if (data.getCode() == 200) {

                    String email = data.getData().getEmail();
                    String password = data.getData().getPassword();

                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, data.getCode() + ":" + data.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
