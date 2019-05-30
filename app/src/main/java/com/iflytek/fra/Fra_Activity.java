/*
* 初始化主界面
* */
package com.iflytek.fra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.iflytek.voicedemo.R;
import com.iflytek.voicedemo.Resource;

import java.util.Timer;
import java.util.TimerTask;

import static com.iflytek.voicedemo.R.id.fl_content;

public class Fra_Activity extends FragmentActivity {
    private FragmentManager mFragmentManager;
    private RadioGroup radioGroup;
    private Center center;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fra);
         center=new Center();
        //获取FragmentManager
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        Fragment fragment=center;
        transaction.replace(fl_content, fragment);
        transaction.commit();

        //获取radioGroup控件
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        //监听点击按钮事件,实现不同Fragment之间的切换
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                Fragment fragment =getInstanceByIndex(checkedId);
                transaction.replace(fl_content, fragment);
                transaction.commit();
            }
        });

    }

    //双击退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exitByDoubleClick();
        }
        return false;
    }
    boolean isExit=false;
    private void exitByDoubleClick() {
        Timer tExit = null;
        if (!isExit) {
            isExit = true;
            Toast.makeText(Fra_Activity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;//取消退出
                }
            }, 2000);// 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
        } else {
            finish();
            System.exit(0);
        }
    }
    
    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment=null;
        switch (index) {
            case R.id.rb_accountscenter:
                fragment=new AccountsCenterFragment();
                break;
            case R.id.rb_center:
                fragment=new Center();
                break;
            case R.id.rb_resourcecenter:
                fragment=new Resource();
                break;
            /*case R.id.rb_liaotain :
                fragment=new LiaoTianShi();
                break;*/
        }
        return fragment;
    }
}
