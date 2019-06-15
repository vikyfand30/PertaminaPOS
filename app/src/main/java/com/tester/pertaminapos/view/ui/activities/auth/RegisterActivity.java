package com.tester.pertaminapos.view.ui.activities.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

import com.tester.pertaminapos.IConfig;
import com.tester.pertaminapos.PertaminaPos;
import com.tester.pertaminapos.R;
import com.tester.pertaminapos.presenter.dao.AuthDao;
import com.tester.pertaminapos.model.api.request.RegisterRequest;
import com.tester.pertaminapos.model.api.response.RegisterResponse;
import com.tester.pertaminapos.view.ui.formValidation.FormValidation;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import app.beelabs.com.codebase.base.response.BaseResponse;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity {

    EditText txt_email;
    EditText txt_pw;
    EditText txt_rpw;
    Button btn_register;
    TextView tv_login;

    private boolean isSignUpFormEnable = true;
    private boolean isFormValidationSuccess = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        initComponent();
    }

    public void initComponent(){
        txt_email = findViewById(R.id.txt_email);
        txt_pw = findViewById(R.id.txt_pw);
        txt_rpw = findViewById(R.id.txt_rpw);
        btn_register = findViewById(R.id.btn_register);
        tv_login = findViewById(R.id.tv_login);

        addTextWatcher(txt_email);
        addTextWatcher(txt_pw);
        addTextWatcher(txt_rpw);

                btn_register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(isFormValidationSuccess){
                            onCallApiRegis();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Password Anda Tidak Sama", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void login(View v)
    {
        Intent i=new Intent();
        i.setClass(this, LoginActivity.class);
        startActivity(i);
    }

    private void onCallApiRegis(){
            final AuthDao dao = new AuthDao(this);
            final RegisterRequest model = new RegisterRequest();
            model.setEmail(txt_email.getText().toString());
            model.setPassword(txt_pw.getText().toString());
        showApiProgressDialog(PertaminaPos.getAppComponent(), new AuthDao(this) {
            @Override
            public void call() {
                dao.onRegis(model, RegisterActivity.this, BaseDao.getInstance(RegisterActivity.this,
                        IConfig.KEY_API_REGIS).callback);
            }
        });
    }

    @Override
    protected void onApiResponseCallback(BaseResponse br, int responseCode, Response response) {
        super.onApiResponseCallback(br, responseCode, response);
            if (response.isSuccessful()) {
                if (responseCode == IConfig.KEY_API_REGIS) {
                    RegisterResponse data = (RegisterResponse) br;
                    if (data.getCode() == 200) {

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Data Anda Belum Benar", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    }


    private void validateForm() {
        String pass = txt_pw.getText().toString();
        String pass2 = txt_rpw.getText().toString();

        if (FormValidation.required(pass) && FormValidation.validPass(pass)
                && FormValidation.required(pass2) && FormValidation.validPass(pass2) && (pass.equals(pass2))) {
            isFormValidationSuccess = true;
        } else {
            isFormValidationSuccess = false;
        }
    }

    public void addTextWatcher(final EditText input) {
        input.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isSignUpFormEnable) {
                    validateForm();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }
}
