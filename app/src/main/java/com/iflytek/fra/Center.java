package com.iflytek.fra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.voicedemo.AsrDemo;
import com.iflytek.voicedemo.IatDemo;
import com.iflytek.voicedemo.IseDemo;
import com.iflytek.voicedemo.R;
import com.iflytek.voicedemo.TtsDemo;
import com.iflytek.voicedemo.WeaDemo;
import com.iflytek.youdu.Youdu;

import java.util.ArrayList;

import static com.mob.tools.utils.DeviceHelper.getApplication;

/**
 * 实现了轮播图效果
 */

public class Center extends Fragment {
    private static final int REQUEST_CODE_ACCURATE_BASIC = 107;
    private AlertDialog.Builder alertDialog;
    private boolean hasGotToken = false;
    private ViewPager vp;
    private LinearLayout ll_point;
    private TextView tv_desc;
    private int[] imageResIds; //存放图片资源id的数组
    private ArrayList<ImageView> imageViews; //存放图片的集合
    private String[] contentDescs; //图片内容描述
    private int lastPosition;
    public boolean isRunning = false; //viewpager是否在自动轮询

    //唯一需要重写的onCreateView（）方法
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //布局映射器映射到左边fragment
        View view = inflater.inflate(R.layout.main,container,false);
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //initViews();
        //M--model数据
//        initData();
        //C--control控制器(即适配器)
//        initAdapter();
            //开启图片的自动轮询
      /*      new Thread() {
                @Override
                public void run() {
                    isRunning = true;
                    while (isRunning) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(getActivity()!=null) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() { //在子线程中开启子线程
                                    //往下翻一页（setCurrentItem方法用来设置ViewPager的当前页）
                                    vp.setCurrentItem(vp.getCurrentItem() + 1);
                                }
                            });
                        }
                    }
                }
            }.start();*/

      Button btn_1 = (Button) getActivity().findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),IatDemo.class);
                startActivity(intent);
            }
        });
      Button btn_2 = (Button) getActivity().findViewById(R.id.btn_2);
      btn_2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getActivity(),Youdu.class);
              startActivity(intent);
          }
      });

      @SuppressLint("WrongViewCast") Button btn_3 = (Button) getActivity().findViewById(R.id.btn_3);
      btn_3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getActivity(),WeaDemo.class);
              startActivity(intent);
          }
      });

      Button btn_4 = (Button) getActivity().findViewById(R.id.btn_4);
      btn_4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getActivity(),TtsDemo.class);
              startActivity(intent);
          }
      });

      Button btn_5 = (Button) getActivity().findViewById(R.id.btn_5);
      btn_5.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getActivity(),IseDemo.class);
              startActivity(intent);
          }
      });

      /*  Button btn_6 = (Button) getActivity().findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d(String.valueOf(getActivity()),"duakuang jniusawhsuw");

                Intent intent = new Intent(getActivity(), CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                        CameraActivity.CONTENT_TYPE_GENERAL);
                startActivityForResult(intent, REQUEST_CODE_ACCURATE_BASIC);
            }
        });*/
        Button btn_6 = (Button) getActivity().findViewById(R.id.btn_6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),AsrDemo.class);
                startActivity(intent);
            }
        });


    }




    /*
        初始化视图
     */
   /* private void initViews() {
        //初始化放小圆点的控件
        ll_point = (LinearLayout)getActivity().findViewById(R.id.ll_point);
        //初始化ViewPager控件
        vp = (ViewPager)getActivity().findViewById(R.id.vp);
        //设置ViewPager的滚动监听
        vp.setOnPageChangeListener(this);
        //显示图片描述信息的控件
        tv_desc = (TextView)getActivity().findViewById(R.id.tv_desc);
    }*/

    /*
      初始化数据
     */
   /* private void initData() {
        //初始化填充ViewPager的图片资源
        imageResIds = new int[]{R.drawable.image01,R.drawable.image02,R.drawable.image03,R.drawable.image04,R.drawable.image05};
        //图片的描述信息aa
        contentDescs = new String[]{
                "我深知我不努力什么都不是",
                "旁观者的姓名永远爬不到比赛的计分板上",
                "真正能走过风雨的，唯热爱与坚守",
                "如果说青春也有缺点，那就是消逝得太快",
                "成大事，不恤小耻；立大功，不拘小谅"
        };
        //保存图片资源的集合
        imageViews = new ArrayList<>();
        ImageView imageView;
        View pointView;
        //循环遍历图片资源，然后保存到集合中
        for (int i = 0; i < imageResIds.length; i++){
            //添加图片到集合中
            imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageResIds[i]);
            imageViews.add(imageView);

            //加小白点，指示器（这里的小圆点定义在了drawable下的选择器中了，也可以用小图片代替）
            pointView = new View(getActivity());
            pointView.setBackgroundResource(R.drawable.point_selector); //使用选择器设置背景
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(8, 8);
            if (i != 0){
                //如果不是第一个点，则设置点的左边距
                layoutParams.leftMargin = 10;
            }
            pointView.setEnabled(false); //默认都是暗色的
//            ll_point.addView(pointView, layoutParams);
        }
    }*/

/*    *//*
      初始化适配器
     *//*
    private void initAdapter() {
//        ll_point.getChildAt(0).setEnabled(true); //初始化控件时，设置第一个小圆点为亮色
        tv_desc.setText(contentDescs[0]); //设置第一个图片对应的文字
        lastPosition = 0; //设置之前的位置为第一个
        vp.setAdapter(new MyPagerAdapter());
        //设置默认显示中间的某个位置（这样可以左右滑动），这个数只有在整数范围内，可以随便设置
        vp.setCurrentItem(5000000); //显示5000000这个位置的图片
    }

    *//*
      自定义适配器，继承自PagerAdapter
     *//*
    class MyPagerAdapter extends PagerAdapter {

        //返回显示数据的总条数，为了实现无限循环，把返回的值设置为最大整数
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        //指定复用的判断逻辑，固定写法：view == object
        @Override
        public boolean isViewFromObject(View view, Object object) {
            //当创建新的条目，又反回来，判断view是否可以被复用(即是否存在)
            return view == object;
        }

        //返回要显示的条目内容
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //container  容器  相当于用来存放imageView
            //从集合中获得图片
            int newPosition = position % 5; //数组中总共有5张图片，超过数组长度时，取摸，防止下标越界
            ImageView imageView = imageViews.get(newPosition);
            //把图片添加到container中
            container.addView(imageView);
            //把图片返回给框架，用来缓存
            return imageView;
        }

        //销毁条目
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //object:刚才创建的对象，即要销毁的对象
            container.removeView((View) object);
        }
    }

    //--------------以下是设置ViewPager的滚动监听所需实现的方法--------
    //页面滑动
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //新的页面被选中
    @Override
    public void onPageSelected(int position) {
        //当前的位置可能很大，为了防止下标越界，对要显示的图片的总数进行取余
        int newPosition = position % 5;
        //设置描述信息
        tv_desc.setText(contentDescs[newPosition]);
        //设置小圆点为高亮或暗色
        ll_point.getChildAt(lastPosition).setEnabled(false);
        ll_point.getChildAt(newPosition).setEnabled(true);
        lastPosition = newPosition; //记录之前的点
    }

    //页面滑动状态发生改变
    @Override
    public void onPageScrollStateChanged(int state) {

    }*/

}
