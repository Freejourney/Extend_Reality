package com.example.admin.extend_reality;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

public class LoginActivity extends Activity {

    private EditText et_passwd;
    private EditText et_username;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initview();
    }

    private void initview() {
        et_username = findViewById(R.id.username_et);
        et_passwd = findViewById(R.id.password_et);
    }
}
