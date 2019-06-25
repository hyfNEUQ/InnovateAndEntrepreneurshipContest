package com.neuq.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.dd.processbutton.iml.ActionProcessButton;
import com.neuq.R;

import fr.ganfra.materialspinner.MaterialSpinner;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private MaterialSpinner materialSpinner = null;
    private ActionProcessButton login = null;
    private ActionProcessButton register = null;
    private static final String[] ITEMS = {"电商职工", "拣货员", "内控把关"};
    private ArrayAdapter<String> adapter;
    private static Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.context = this;
        initUi();
    }

    public void initUi() {
        materialSpinner = findViewById(R.id.spinner7);
        login = findViewById(R.id.btnSignIn);
        login.setOnClickListener(this);
        register = findViewById(R.id.btnRegisterAndLogin);
        register.setOnClickListener(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        materialSpinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        int position = materialSpinner.getSelectedItemPosition();
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnSignIn:
                if (position==0) {
                    //电商职工
                    intent.setClass(this, CommerceEmployees.class);
                } else if (position==1) {
                    intent.setClass(this, PickingStaffActivity.class);
                    //拣货员
                } else {
                    intent.setClass(this, GuardPassActivity.class);
                    //内控把关
                }
                startActivity(intent);
                break;
            case R.id.btnRegisterAndLogin:
                //注册界面
                intent.setClass(this, RegisterActivity.class);
                startActivity(intent);
        }
    }

}
