package com.example.admin.extend_reality;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

                break;
            case R.id.tv_signup:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}
