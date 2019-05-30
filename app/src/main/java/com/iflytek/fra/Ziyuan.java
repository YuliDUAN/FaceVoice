package com.iflytek.fra;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by 聚贤阁--康少 on 2018/11/19.
 */

public class Ziyuan extends Drawable {
    private String aName;
    private String aSpeak;

    private int aIncon;
    public Ziyuan(String aName,String aSpeak, int aIncon)
    {
        this.aName=aName;
        this.aIncon=aIncon;
        this.aSpeak=aSpeak;
    }
    public String getaName()
    {
        return  aName;
    }
    public String getaSpeak()
    {
        return  aSpeak;
    }
    public int getaIncon()
    {
        return  aIncon;
    }
    public void setaName(String aName)
    {
        this.aName=aName;
    }
    public void setaSpeak(String aSpeak)
    {
        this.aSpeak=aSpeak;
    }
    public void setaIncon(int aIncon)
    {
        this.aIncon=aIncon;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {

    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
