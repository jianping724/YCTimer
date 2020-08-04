# YCTimer倒计时工具
#### 目录介绍
- 01.实现倒计时的方式
- 02.使用封装计时器
- 03.各种倒计时器分析


### 01.实现倒计时的方式
- 01.使用Handler实现倒计时
    - mHandler + runnable ，这种是最常见的一种方式。
- 02.使用CountDownTimer实现倒计时
- 03.利用Timer实现定时器
- 04.使用chronometer控件倒计时
- 05.利用动画实现倒计时



### 02.使用封装计时器
- 使用CountDownTimer实现倒计时。看CountDownTimer源码可知，也是通过对handler封装实现的
    ```
    mCountDownTimer = new CountDownTimer();
    //设置倒计时总时间
    mCountDownTimer.setMillisInFuture(MAX_TIME);
    //设置倒计时间隔值
    mCountDownTimer.setCountdownInterval(1000);
    //设置倒计时监听
    mCountDownTimer.setCountDownListener(new TimerListener() {
        @Override
        public void onStart() {
        }

        @Override
        public void onFinish() {
            mTvTime.setText("完成!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTvTime.setText(CountTimeTools.getCountTimeByLong(millisUntilFinished));
        }
    });
    ```
- 关于开始，暂停，恢复，移除等操作
    ```
    //开始
    mCountDownTimer.start();
    //结束销毁
    mCountDownTimer.cancel();
    //暂停
    mCountDownTimer.pause();
    //恢复暂停
    mCountDownTimer.resume();
    ```


### 03.各种倒计时器分析










