package com.ceribit.android.testingwithtoys;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import com.ceribit.android.testingwithtoys.Adapter.TaskAdapterPage;

public class TimerPage extends AppCompatActivity {

    Chronometer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_page);
    }

    public void startTimer(View view){
        mTimer = findViewById(R.id.timer_cm);
        mTimer.setBase(SystemClock.elapsedRealtime());
        mTimer.start();
    }

    public void goToThirdPage(View view){
        Intent intent = new Intent(this, TaskAdapterPage.class);
        startActivity(intent);
    }

    public void sendTime(View view){
        Intent sendIntent = new Intent();
        mTimer = findViewById(R.id.timer_cm);

        Long elapsedMilliseconds = SystemClock.elapsedRealtime()-mTimer.getBase();
        String time = String.valueOf(elapsedMilliseconds / 1000);

        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, time);
        sendIntent.setType("text/plain");

        if(sendIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sendIntent);
        }
    }
}
