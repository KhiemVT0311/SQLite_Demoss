package com.eup.sqlitedemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eup.sqlitedemo.adapter.VirusAdapter;
import com.eup.sqlitedemo.dao.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_VIRUS = 1;
    private RecyclerView lvVirus;
    private VirusAdapter adapter;
    private FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    private void loadData() {
        adapter.setData(AppDatabase.getInstance(this).getVirusDao().getAll());
    }

    private void initView() {
        lvVirus = findViewById(R.id.lv_virus);
        btnAdd = findViewById(R.id.btn_add);
        adapter = new VirusAdapter(getLayoutInflater());
        lvVirus.setAdapter(adapter);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = VirusActivity.getIntent(this, null);
        startActivityForResult(intent, REQUEST_VIRUS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VIRUS && resultCode == RESULT_OK) {
            loadData();
        }
    }
}
