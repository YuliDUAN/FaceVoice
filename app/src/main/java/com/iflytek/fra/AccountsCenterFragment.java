package com.iflytek.fra;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.Wo.GuanYu.GuanYu;
import com.iflytek.Wo.PingCe.item_identify_result;
import com.iflytek.Wo.QianDao.Signin_Activity;
import com.iflytek.Wo.ShouCang.ShouCang;
import com.iflytek.Wo.WenTi.WeTi;
import com.iflytek.Wo.XiaoXi.XiaoXi;
import com.iflytek.Wo.YiJian.FeedBack;
import com.iflytek.voicedemo.R;


public class AccountsCenterFragment extends Fragment {
    private TextView view_1;
    private TextView view_2;
    private TextView view_3;
    private TextView view_4;
    private TextView view_5;
    private TextView view_6;
    private TextView view_7;
    private TextView view_8;
    private TextView view_9;
    private Context mContext;
    //唯一需要重写的onCreateView（）方法
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //布局映射器映射到右边fragment
        View view = inflater.inflate(R.layout.accountscenterfragment,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView view_1 = (TextView) getActivity().findViewById(R.id.view_1);
        TextView view_2 = (TextView) getActivity().findViewById(R.id.view_2);
        TextView view_3 = (TextView) getActivity().findViewById(R.id.view_3);
        TextView view_4;
        TextView view_5 = (TextView) getActivity().findViewById(R.id.view_5);
        TextView view_6 = (TextView) getActivity().findViewById(R.id.view_6);
        TextView view_7 = (TextView) getActivity().findViewById(R.id.view_7);
        TextView view_8 = (TextView) getActivity().findViewById(R.id.view_8);
        TextView view_9 = (TextView) getActivity().findViewById(R.id.view_9);
        mContext = getActivity();
        view_4 = (TextView)getActivity(). findViewById(R.id.view_4);
        view_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });
        //签到按钮
        view_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Signin_Activity.class);
                startActivity(intent);
            }
});
        //积分商城
        view_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "兑换的商品正在紧张筹备", Toast.LENGTH_LONG).show();
            }
        });
        //签到按钮
        view_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),item_identify_result.class);
                startActivity(intent);
            }
        });
        //我的收藏
        view_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ShouCang.class);
                startActivity(intent);
            }
        });
        //常见问题
        view_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),WeTi.class);
                startActivity(intent);
            }
        });
        //消息提醒
        view_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),XiaoXi.class);
                startActivity(intent);
            }
        });
        //意见反馈
        view_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),FeedBack.class);
                startActivity(intent);
            }
        });
        //关于此APP
        view_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),GuanYu.class);
                startActivity(intent);
            }
        });
    }

    private void initPopWindow(View v) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_popip, null, false);
        TextView tv_wechat_mm = (TextView) view.findViewById(R.id.tv_wechat_mm);
        TextView tv_wechat = (TextView) view.findViewById(R.id.tv_wechat);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        final PopupWindow popWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindow.setAnimationStyle(R.anim.anim_pop);
        //popWindow.setAnimationStyle(R.anim.anim_pop);  //设置加载动画

        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题

        // 弹出菜单后设置透明度
        setWindowAlpha(0.3f);

// 菜单消失后取消透明效果
        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setWindowAlpha(1f);
            }
        });


        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效


        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        //popWindow.showAsDropDown(v, 50, 0);
        popWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
        //设置popupWindow里的按钮的事件
        tv_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "微信~", Toast.LENGTH_SHORT).show();
            }
        });
        tv_wechat_mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "~QQ", Toast.LENGTH_SHORT).show();
                //popWindow.dismiss();
            }
        });
    }
    private void setWindowAlpha(float alpha) {
        WindowManager.LayoutParams lp=getActivity().getWindow().getAttributes();
        lp.alpha = alpha;
        getActivity().getWindow().setAttributes(lp);
    }
}
