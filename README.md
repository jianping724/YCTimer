# YCTimer倒计时工具
#### 目录介绍
- 01.实现倒计时的方式
- 02.使用封装计时器
- 03.各种倒计时器分析
- 04.CountDownTimer解读


### 01.实现倒计时的方式
- 01.使用Handler实现倒计时
    - mHandler + runnable ，这种是最常见的一种方式。
- 02.使用CountDownTimer实现倒计时
    - 也是利用mHandler + runnable，在此基础上简单封装一下。使用场景更强大，比如一个页面有多个倒计时器，用这个就很方便……
- 03.利用Timer实现定时器
    - 使用Timer + TimerTask实现倒计时
- 04.使用chronometer控件倒计时
    - 新出的继承TextView组件
- 05.利用动画实现倒计时
    - 这种方式用的比较少，但也是一种思路。主要是设置动画时间，在onAnimationUpdate监听设置倒计时处理


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
- 注意在页面销毁的时候
    ```
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer!=null){
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }
    ```


### 03.各种倒计时器分析



