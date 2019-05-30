package com.iflytek.Wo.YiJian;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.iflytek.voicedemo.R;
/**
 * Created by DK on 2018/11/16.
 */


public class FeedBack extends Activity {
    EditText help_feedback=null;
    private  Button but;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wo_yijian);

        //获取按钮
        Button but_help_feedback=(Button)findViewById(R.id.but_help_feedback);
        help_feedback=(EditText)findViewById(R.id.help_feedback);

        //添加点击事件 ，保存文本信息，并生成提示，同时跳转到主界面
        but_help_feedback.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v){
                String Context =help_feedback.getText().toString();;
               Toast.makeText(FeedBack.this, "感谢您的反馈,我们会尽快处理您的意见。", Toast.LENGTH_SHORT).show();
                finish();
                //将要实现保存EditText中输入的内容



            }
        });
    }
}