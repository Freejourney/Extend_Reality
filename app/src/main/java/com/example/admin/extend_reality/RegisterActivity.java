package com.example.admin.extend_reality;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

class RegisterActivity extends Activity{

    private EditText et_username;
    private EditText et_password;
    private EditText et_confirm_password;
    private Button btn_signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init() {
        et_username = findViewById(R.id.username_et);
        et_password = findViewById(R.id.password_et);
        et_confirm_password = findViewById(R.id.confirm_in_et_password);
        btn_signup = findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!et_password.getText().toString().equals(et_confirm_password.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "密码不一致请重新输入", Toast.LENGTH_LONG);
                } else {
                    User user = new User();
                    user.setUsername(et_username.getText().toString());
                    user.setPassword(et_password.getText().toString());
                    user.signUp(new SaveListener<Object>() {
                        @Override
                        public void done(Object o, BmobException e) {
                            if (e == null) {
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_LONG);
                            }
                        }
                    });
                }
            }
        });
    }
}
