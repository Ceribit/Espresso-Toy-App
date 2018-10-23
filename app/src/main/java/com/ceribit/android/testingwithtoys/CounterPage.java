package com.ceribit.android.testingwithtoys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CounterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void addOne(View view){
        TextView textView = (TextView) findViewById(R.id.counter_text);
        int value = Integer.valueOf(textView.getText().toString());
        textView.setText(String.valueOf(value+1));
    }

    public void goToSecondPage(View view){
        Intent intent = new Intent(this, TimerPage.class);
        startActivity(intent);
    }
}
