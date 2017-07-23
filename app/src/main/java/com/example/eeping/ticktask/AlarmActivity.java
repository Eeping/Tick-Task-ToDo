package com.example.eeping.ticktask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by Ee Ping on 7/22/2017.
 */

public class AlarmActivity extends AppCompatActivity {
    AlarmManager alarmManager;
    TimePicker alarmTimePicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        this.context = this;

        //Initialize alarm manager
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //Initialize time picker
        alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);

        //Initialize text update box
        update_text = (TextView) findViewById(R.id.update_text);

        //Create an instance of a calender
        final Calendar calendar = Calendar.getInstance();

        //create an intent to AlarmReceiver class
        final Intent my_intent = new Intent(this.context, AlarmReceiver.class);

        //Initialize alarm on button
        Button alarm_on = (Button) findViewById(R.id.alarm_on);

        //create onclick listener to start alarm
        alarm_on.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //set calendar instance with hour and minutes
                calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());

                //get int value of hour and minute
                int hour = alarmTimePicker.getHour();
                int minute = alarmTimePicker.getMinute();

                //convert int value to string
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                //Convert 24-hour time to 12-hour time
                if(hour > 12) {
                    hour_string = String.valueOf(hour - 12);
                }

                if(minute < 10) {
                    minute_string = "0" + String.valueOf(minute);
                }

                //Update the update_text textbox
                set_alarm_text("Alarm set: " + hour_string + ":" + minute_string);

                //create a pending intent that delays the intent
                //until the specified calendar time
                pending_intent = PendingIntent.getBroadcast(AlarmActivity.this, 0,
                        my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                //set the alarm manager
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);
            }
        });

        //Initialize alarm off button
        Button alarm_off = (Button) findViewById(R.id.alarm_off);

        //create onclick listener to stop alarm or unset alarm
        alarm_off.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                set_alarm_text("Alarm off !");

                //cancel the alarm
                alarmManager.cancel(pending_intent);
            }
        });
    }

    private void set_alarm_text(String output) {
        update_text.setText(output);
    }
}
