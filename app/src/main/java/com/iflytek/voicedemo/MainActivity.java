package com.iflytek.voicedemo;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.iflytek.cloud.SpeechUtility;
import com.iflytek.sunflower.FlowerCollector;

import cn.sharesdk.onekeyshare.OnekeyShare;
import memodemo.ui.LoginActivity;


import static com.iflytek.speech.setting.UrlSettings.PREFER_NAME;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private static final String TAG = MainActivity.class.getSimpleName();
	private Toast mToast;
	private final int URL_REQUEST_CODE = 0X001;
	private Button btn_1;
	private Button btn_2;
	private Button btn_3;
	private Button btn_4;
	private Button btn_5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		initView();
	}


    private void initView() {
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_1.setOnClickListener(this);

		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_2.setOnClickListener(this);

		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_3.setOnClickListener(this);

		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_4.setOnClickListener(this);

		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_5.setOnClickListener(this);

	}

	/*public void onekeyShare(View view) {
		showShare();
	}*/

	/*public void goThirdPartyLogin(View view) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}

	private void showShare() {
		OnekeyShare oks = new OnekeyShare();
		//关闭sso授权
		oks.disableSSOWhenAuthorize();
		// title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
		oks.setTitle("标题");
		// titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
		oks.setTitleUrl("http://sharesdk.cn");
		// text是分享文本，所有平台都需要这个字段
		oks.setText("我是分享文本");
		//分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
		oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
		//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl("http://sharesdk.cn");
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("我是测试评论文本");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite("ShareSDK");
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://sharesdk.cn");

		// 启动分享GUI
		oks.show(this);
	}
*/
	@Override
	public void onClick(View view) {

		Intent intent = null;
		switch (view.getId()) {
			case R.id.btn_1:
				// 语音转写
				intent = new Intent(MainActivity.this, IatDemo.class);
				break;
			case R.id.btn_2:
				// 语法识别
				intent = new Intent(MainActivity.this, AsrDemo.class);
				break;
			case R.id.btn_3:
				// 语义理解
				intent = new Intent(MainActivity.this, WeaDemo.class);
				break;
			case R.id.btn_4:
				// 语音合成
				intent = new Intent(MainActivity.this, TtsDemo.class);
				break;
			case R.id.btn_5:
				// 语音评测
				intent = new Intent(MainActivity.this, IseDemo.class);
				break;
			default:
				break;
		}

		if (intent != null) {
			startActivity(intent);
		}
	}


	private void showTip(final String str) {
		mToast.setText(str);
		mToast.show();
	}

	@Override
	protected void onResume() {
		// 开放统计 移动数据统计分析
		FlowerCollector.onResume(MainActivity.this);
		FlowerCollector.onPageStart(TAG);
		super.onResume();
	}

	@Override
	protected void onPause() {
		// 开放统计 移动数据统计分析
		FlowerCollector.onPageEnd(TAG);
		FlowerCollector.onPause(MainActivity.this);
		super.onPause();
	}

	private void requestPermissions() {
		try {
			if (Build.VERSION.SDK_INT >= 23) {
				int permission = ActivityCompat.checkSelfPermission(this,
						Manifest.permission.WRITE_EXTERNAL_STORAGE);
				if (permission != PackageManager.PERMISSION_GRANTED) {
					ActivityCompat.requestPermissions(this, new String[]
							{Manifest.permission.WRITE_EXTERNAL_STORAGE,
									Manifest.permission.LOCATION_HARDWARE, Manifest.permission.READ_PHONE_STATE,
									Manifest.permission.WRITE_SETTINGS, Manifest.permission.READ_EXTERNAL_STORAGE,
									Manifest.permission.RECORD_AUDIO, Manifest.permission.READ_CONTACTS}, 0x0010);
				}

				if (permission != PackageManager.PERMISSION_GRANTED) {
					ActivityCompat.requestPermissions(this, new String[]{
							Manifest.permission.ACCESS_COARSE_LOCATION,
							Manifest.permission.ACCESS_FINE_LOCATION}, 0x0010);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	private void mscInit(String serverUrl) {
		// 注意：此接口在非主进程调用会返回null对象，如需在非主进程使用语音功能，请增加参数：SpeechConstant.FORCE_LOGIN+"=true"
		// 参数间使用半角“,”分隔。
		// 设置你申请的应用appid,请勿在'='与appid之间添加空格及空转义符

		// 注意： appid 必须和下载的SDK保持一致，否则会出现10407错误
		StringBuffer bf = new StringBuffer();
		bf.append("appid=" + getString(R.string.app_id));
		bf.append(",");
		if (!TextUtils.isEmpty(serverUrl)) {
			bf.append("server_url=" + serverUrl);
			bf.append(",");
		}
		//此处调用与SpeechDemo中重复，两处只调用其一即可
		SpeechUtility.createUtility(this.getApplicationContext(), bf.toString());
		// 以下语句用于设置日志开关（默认开启），设置成false时关闭语音云SDK日志打印
		// Setting.setShowLog(false);
	}

	private void mscUninit() {
		if (SpeechUtility.getUtility() != null) {
			SpeechUtility.getUtility().destroy();
			try {
				new Thread().sleep(40);
			} catch (InterruptedException e) {
				Log.w(TAG, "msc uninit failed" + e.toString());
			}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (URL_REQUEST_CODE == requestCode) {
			Log.d(TAG, "onActivityResult>>");
			try {
				SharedPreferences pref = getSharedPreferences(PREFER_NAME, MODE_PRIVATE);
				String server_url = pref.getString("url_preference", "");
				String domain = pref.getString("url_edit", "");
				Log.d(TAG, "onActivityResult>>domain = " + domain);
				if (!TextUtils.isEmpty(domain)) {
					server_url = "http://" + domain + "/msp.do";
				}
				Log.d(TAG, "onActivityResult>>server_url = " + server_url);
				mscUninit();
				new Thread().sleep(40);
				//mscInit(server_url);
			} catch (Exception e) {
				showTip("reset url failed");
			}

		}
	}
}
