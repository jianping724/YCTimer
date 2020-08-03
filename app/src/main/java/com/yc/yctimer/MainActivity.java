package com.yc.yctimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_1).setOnClickListener(this);
        findViewById(R.id.tv_2).setOnClickListener(this);
        findViewById(R.id.tv_3).setOnClickListener(this);
        findViewById(R.id.tv_4).setOnClickListener(this);
        findViewById(R.id.tv_5).setOnClickListener(this);
        findViewById(R.id.tv_6).setOnClickListener(this);
        findViewById(R.id.tv_7).setOnClickListener(this);
        findViewById(R.id.tv_8).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_1:
                startActivity(new Intent(this,HandlerActivity.class));
                break;
            case R.id.tv_2:
                startActivity(new Intent(this,CountActivity.class));
                break;
            case R.id.tv_3:
                startActivity(new Intent(this,TimerActivity.class));
                break;
            case R.id.tv_4:
                startActivity(new Intent(this,ChronometerActivity.class));
                break;
            case R.id.tv_5:
                startActivity(new Intent(this,MyCountActivity.class));
                break;
            case R.id.tv_6:
                startActivity(new Intent(this,CountViewActivity.class));
                break;
            case R.id.tv_7:
                LoopRequestService.startLoopService(this);
                break;
            case R.id.tv_8:
                startActivity(new Intent(this,AnimatorActivity.class));
                break;
            default:
                break;
        }
    }
}
