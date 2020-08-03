package com.yc.yctimer;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AnimatorActivity extends AppCompatActivity {

    private TextView mTvTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        mTvTime = findViewById(R.id.tv_time);
        ValueAnimator animator = ValueAnimator.ofInt(60,0);
        //设置时间
        animator.setDuration(60000);
        //均匀显示
        animator.setInterpolator(new LinearInterpolator());
        //监听
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (Integer) animation.getAnimatedValue();
                mTvTime.setText(value+"秒");
            }
        });
        animator.start();
    }



}
