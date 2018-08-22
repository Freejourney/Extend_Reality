package com.example.admin.extend_reality;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity implements View.OnClickListener{

    private EditText et_passwd;
    private EditText et_username;
    private TextView tv_signup;
    private Button btn_signin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initview();
    }

    private void initview() {
        et_username = findViewById(R.id.username_et);
        et_passwd = findViewById(R.id.password_et);
        btn_signin = findViewById(R.id.btn_signin);
        tv_signup = findViewById(R.id.tv_signup);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_signin:
                signin();
                finish();
                break;
            case R.id.tv_signup:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
                break;
        }
    }

    private void signin() {
        User user = new User();
        user.setUsername(et_username.getText().toString());
        user.setPassword(et_passwd.getText().toString());
        user.login(new SaveListener<Object>() {
            @Override
            public void done(Object o, BmobException e) {
                if (e == null) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG);
                }
            }
        });
    }
}
