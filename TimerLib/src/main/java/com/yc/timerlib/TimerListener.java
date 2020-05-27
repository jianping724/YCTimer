package com.yc.timerlib;

/**
 * 倒计时监听器
 */
public interface TimerListener {

    /**
     * 当倒计时开始
     */
    void onStart();

    /**
     * 当倒计时结束
     */
    void onFinish();

    /**
     * @param millisUntilFinished 剩余时间
     */
    void onTick(long millisUntilFinished);

}
