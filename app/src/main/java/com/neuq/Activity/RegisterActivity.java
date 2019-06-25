package com.neuq.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.neuq.R;

import fr.ganfra.materialspinner.MaterialSpinner;

public class RegisterActivity extends AppCompatActivity {
    private static MaterialSpinner materialSpinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUi();
    }

    public void initUi() {
        String[] ITEMS = {"电商职工", "拣货员", "内控把关"};
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        materialSpinner=findViewById(R.id.spinner7);
        materialSpinner.setAdapter(adapter);
    }
}
