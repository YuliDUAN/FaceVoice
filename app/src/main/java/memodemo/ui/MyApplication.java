package memodemo.ui;

import android.app.Application;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化ShareSDK
        //ShareSDK.initSDK(this);
    }
}