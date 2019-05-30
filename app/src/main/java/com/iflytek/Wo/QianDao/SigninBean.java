package com.iflytek.Wo.QianDao;

/**
 * Created by DK on 2018/11/15.
 */
import java.io.Serializable;

/**
 * 存放签到的bean
 */
public class SigninBean implements Serializable{
    /**
     * 未完成
     */
    public static final int STEP_UNDO = -1;
    /**
     * 正在进行
     */
    public static final int STEP_CURRENT = 0;
    /**
     * 已完成
     */
    public static final int STEP_COMPLETED = 1;

    private int state;
    private int number;

    public SigninBean(int state, int number) {
        this.state = state;
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int stepCompleted, int state) {
        this.state = state;
    }
}
