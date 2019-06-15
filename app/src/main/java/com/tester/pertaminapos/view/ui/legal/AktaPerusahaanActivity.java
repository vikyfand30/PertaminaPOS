package com.tester.pertaminapos.view.ui.legal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.tester.pertaminapos.R;
import com.tester.pertaminapos.view.ui.personal.ContactActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import app.beelabs.com.codebase.base.BaseActivity;

public class AktaPerusahaanActivity extends BaseActivity {

    EditText txt_distributor;
    EditText txt_no_akta;
    EditText txt_jenis_akta;
    EditText txt_tgl_akta;
    EditText txt_akta_pengesahan;
    Button btn_back;
    Button btn_next;
    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    DatePickerDialog.OnDateSetListener dates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akta);

        initView();
        initContent();
    }


    public void initView() {
        txt_distributor = findViewById(R.id.txt_distributor);
        txt_no_akta = findViewById(R.id.txt_no_akta);
        txt_jenis_akta = findViewById(R.id.txt_jenis_akta);
        txt_tgl_akta = findViewById(R.id.txt_tgl_akta);
        txt_akta_pengesahan = findViewById(R.id.txt_akta_pengesahan);
        btn_back = findViewById(R.id.btn_back);
        btn_next = findViewById(R.id.btn_next);
    }

    public void initContent() {
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

        dates = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabels();

            }
        };

        txt_tgl_akta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AktaPerusahaanActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        txt_akta_pengesahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AktaPerusahaanActivity.this, dates, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AktaPerusahaanActivity.this, NPWPActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AktaPerusahaanActivity.this, ContactActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_tgl_akta.setText(sdf.format(myCalendar.getTime()));

    }

    private void updateLabels() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        txt_akta_pengesahan.setText(sdf.format(myCalendar.getTime()));
    }

}

