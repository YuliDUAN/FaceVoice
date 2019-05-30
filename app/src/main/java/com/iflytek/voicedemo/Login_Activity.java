package com.iflytek.voicedemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.fra.Fra_Activity;
import com.iflytek.voicedemo.denlv.Reg_Activity;
import com.iflytek.voicedemo.denlv.UserService;
import com.iflytek.voicedemo.faceonline.OnlineFaceDemo;
import com.iflytek.voicedemo.vocalverify.VocalVerifyDemo;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_enter;
    private TextView tv_register;
    private EditText et_phone;
    private EditText et_pwd;
    private ImageView iv_renlian;
    private ImageView iv_shengwen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initView();
    }



    /**
     * 初始化
     */
    private void initView() {
        iv_renlian=(ImageView) findViewById(R.id.iv_renlian);
        iv_renlian.setOnClickListener(this);

        iv_shengwen=(ImageView) findViewById(R.id.iv_shengwen);
        iv_shengwen.setOnClickListener(this);

        btn_enter = (Button) findViewById(R.id.btn_enter);
        btn_enter.setOnClickListener(this);

        tv_register= (TextView) findViewById(R.id.tv_register);
        tv_register.setOnClickListener(this);

        et_phone= (EditText) findViewById(R.id.et_phone);
        et_phone.setOnClickListener(this);

        et_pwd= (EditText) findViewById(R.id.et_pwd);
        et_pwd.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_enter:
                String name=et_phone.getText().toString();
                String pass=et_pwd.getText().toString();
                Log.i("TAG",name+"_"+pass);
                UserService uService=new UserService(Login_Activity.this);
                boolean flag=uService.login(name, pass);
                if(flag){
                    Log.i("TAG","登录成功");
                    Intent intent=new Intent(Login_Activity.this,Fra_Activity.class);
                    startActivity(intent);
                    Toast.makeText(Login_Activity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    this.finish();
                }else{
                    Log.i("TAG","登录失败");
                    Toast.makeText(Login_Activity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_register:
                Intent intent=new Intent(Login_Activity.this,Reg_Activity.class);
                startActivity(intent);
                break;
            case R.id.iv_renlian:
                intent = new Intent(Login_Activity.this,OnlineFaceDemo.class);
                startActivity(intent);
                break;

            case R.id.iv_shengwen:
                intent = new Intent(Login_Activity.this,VocalVerifyDemo.class);
                startActivity(intent);
                break;

        }
    }

}
