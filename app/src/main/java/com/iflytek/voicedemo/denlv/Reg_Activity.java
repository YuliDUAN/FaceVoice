package com.iflytek.voicedemo.denlv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.iflytek.voicedemo.Login_Activity;
import com.iflytek.voicedemo.R;

public class Reg_Activity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText age;
    RadioGroup sex;
    Button register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        findViews();
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String sexstr = ((RadioButton) Reg_Activity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
                Log.i("TAG", name + "_" + pass + "_"  );
                if("".equals(name)||"".equals(pass)){
                    Toast.makeText(Reg_Activity.this, "注册失败", Toast.LENGTH_LONG).show();
                }else{
                    UserService uService = new UserService(Reg_Activity.this);
                    User user = new User();
                    user.setUsername(name);
                    user.setPassword(pass);
                    user.setSex(sexstr);
                    uService.register(user);
                    Toast.makeText(Reg_Activity.this, "注册成功", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(Reg_Activity.this,Login_Activity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void findViews() {
        username = (EditText) findViewById(R.id.usernameRegister);
        password = (EditText) findViewById(R.id.passwordRegister);
        sex = (RadioGroup) findViewById(R.id.sexRegister);
        register = (Button) findViewById(R.id.Register);
    }
}