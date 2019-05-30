package com.iflytek.Wo.QianDao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.voicedemo.R;

import java.util.ArrayList;

/**
 * Created by DK on 2018/11/15.
 */

public class Signin_Activity extends AppCompatActivity {
    private MysigninView msigninView;
    private TextView txt;
    private ArrayList<SigninBean> signinBen = new ArrayList<>();
    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wo_qiandao);
        Init();

        InitData();
        InitListtener();
    }

    private void InitListtener() {
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag) {
                    msigninView.startSignAnimation(2);
                    flag=false;
                    txt.setBackground(getResources().getDrawable(R.drawable.wo_yiqian));
                }else{
                    Toast.makeText(Signin_Activity.this,"当前已签到，不允许重复签到",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void InitData() {
        signinBen.add(new SigninBean(SigninBean.STEP_COMPLETED, 1));
        signinBen.add(new SigninBean(SigninBean.STEP_COMPLETED, 2));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 10));
        msigninView.setStepNum(signinBen);
    }

    private void Init() {
        msigninView= (MysigninView) findViewById(R.id.signin_view);
        txt = (TextView) findViewById(R.id.txt_click);
    }
}
