package com.eup.sqlitedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.eup.sqlitedemo.dao.AppDatabase;
import com.eup.sqlitedemo.model.Virus;
import com.eup.sqlitedemo.utils.Validator;

public class VirusActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName;
    private EditText edtCauTruc;
    private EditText edtNgay;
    private EditText edtVacXin;
    private Button btnOk;
    private Virus virus = new Virus();

    public static Intent getIntent(Context context, Virus virus) {
        Intent intent = new Intent(context, VirusActivity.class);
        if (virus != null) {
            intent.putExtra(Virus.class.getName(), virus);
        }
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virus);
        Intent intent = getIntent();
        if (intent.hasExtra(Virus.class.getName())) {
            virus = (Virus) intent
                    .getSerializableExtra(Virus.class.getName());
        }
        initViews();
    }

    private void initViews() {
        edtName = findViewById(R.id.edt_name);
        edtCauTruc = findViewById(R.id.edt_cautruc);
        edtNgay = findViewById(R.id.edt_ngay);
        edtVacXin = findViewById(R.id.edt_vacxin);
        edtName.setText(virus.getName());
        edtNgay.setText(virus.getNgayXuatHien());
        edtCauTruc.setText(virus.getCauTruc());
        edtVacXin.setText(virus.getVacXin());
        btnOk = findViewById(R.id.btn_them);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (Validator.isEmpty(edtName, edtCauTruc, edtNgay, edtVacXin)) {
            return;
        }
        virus.setName(edtName.getText().toString());
        virus.setCauTruc(edtCauTruc.getText().toString());
        virus.setNgayXuatHien(edtNgay.getText().toString());
        virus.setVacXin(edtVacXin.getText().toString());
        if (virus.getId() > 0) {
            AppDatabase.getInstance(this).getVirusDao().update(virus);
        } else {
            AppDatabase.getInstance(this).getVirusDao().insert(virus);
        }
        setResult(RESULT_OK);
        finish();
    }
}

