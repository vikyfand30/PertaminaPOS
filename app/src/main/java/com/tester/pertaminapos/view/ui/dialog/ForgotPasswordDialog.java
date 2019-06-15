package com.tester.pertaminapos.view.ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.EditText;

import com.tester.pertaminapos.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import app.beelabs.com.codebase.base.BaseDialog;

public class ForgotPasswordDialog extends BaseDialog {

    @BindView(R.id.emailConfirmEdit)
    EditText emailConfirmEdit;

    private Activity activity;

    public ForgotPasswordDialog(@NonNull Activity activity, int style) {
        super(activity, style);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowContentDialogLayout(R.layout.dialog_forgot_password);

        ButterKnife.bind(this);

    }
}
