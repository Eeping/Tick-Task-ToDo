package com.example.eeping.ticktask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Ee Ping on 7/22/2017.
 */

public class LaunchActivity extends AppCompatActivity {
    Button mWelcomeBtn;
    Button mWelcomeAlarmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mWelcomeBtn = (Button)findViewById(R.id.welcomeBtn);
        mWelcomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchActivity.this, TaskActivity.class));
            }
        });

        mWelcomeAlarmBtn = (Button) findViewById(R.id.welcome_Alarm);
        mWelcomeAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchActivity.this, AlarmActivity.class));
            }
        });
    }
}
