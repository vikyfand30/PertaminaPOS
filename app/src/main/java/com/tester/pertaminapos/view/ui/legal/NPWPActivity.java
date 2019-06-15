package com.tester.pertaminapos.view.ui.legal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.tester.pertaminapos.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import app.beelabs.com.codebase.base.BaseActivity;
import butterknife.BindView;

public class NPWPActivity extends BaseActivity {

    Button btn_next;
    Button btn_back;
    DatePickerDialog.OnDateSetListener date;
    Calendar myCalendar;
    EditText txt_tgl_npwp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npwp);

        initView();
        initContent();
    }

    public void initView(){
        btn_next = findViewById(R.id.btn_next);
        btn_back = findViewById(R.id.btn_back);
        txt_tgl_npwp = findViewById(R.id.txt_tgl_npwp);

    }

    public void initContent(){
        myCalendar = Calendar.getInstance();

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }
        };

        txt_tgl_npwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(NPWPActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NPWPActivity.this, AktaPerusahaanActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NPWPActivity.this, SPTPActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tgl_npwp.setText(sdf.format(myCalendar.getTime()));

    }


}
