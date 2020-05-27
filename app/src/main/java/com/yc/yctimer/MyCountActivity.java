package com.yc.yctimer;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yc.timerlib.TimerListener;
import com.yc.timerlib.CountDownTimer;
import com.yc.timerlib.CountTimeTools;

public class MyCountActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTime;
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;


    private static final long MAX_TIME = 120000;
    private long curTime = 0;
    private boolean isPause = false;
    private CountDownTimer mCountDownTimer;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        initView();
        initCountDownTimer(MAX_TIME);
    }

    private void initCountDownTimer(long time) {
        mCountDownTimer = new CountDownTimer();
        mCountDownTimer.setMillisInFuture(MAX_TIME);
        mCountDownTimer.setCountdownInterval(1000);
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
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer!=null){
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }

    private void initView() {
        mTvTime = findViewById(R.id.tv_time);
        mTv1 = findViewById(R.id.tv_1);
        mTv2 = findViewById(R.id.tv_2);
        mTv3 = findViewById(R.id.tv_3);
        mTv4 = findViewById(R.id.tv_4);

        mTv1.setOnClickListener(this);
        mTv2.setOnClickListener(this);
        mTv3.setOnClickListener(this);
        mTv4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_1:
                //开始
                mCountDownTimer.start();
                break;
            case R.id.tv_2:
                //结束销毁
                mCountDownTimer.cancel();
                break;
            case R.id.tv_3:
                //暂停
                mCountDownTimer.pause();
                break;
            case R.id.tv_4:
                //恢复暂停
                mCountDownTimer.resume();
                break;
            default:
                break;
        }
    }
}
