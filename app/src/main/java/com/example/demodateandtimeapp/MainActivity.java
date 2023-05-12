package com.example.demodateandtimeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {


    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;

    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link the field variables to ui components in layout
        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        btnDisplayDate=findViewById(R.id.buttonDisplayDate);
        btnDisplayTime=findViewById(R.id.buttonDisplayTime);
        tvDisplay=findViewById(R.id.textView);
        btnReset=findViewById(R.id.resetbtn);

        btnDisplayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int year=dp.getYear();
                int month=dp.getMonth() + 1;
                int day= dp.getDayOfMonth();
                tvDisplay.setText("Date is "+day+"/"+month+"/"+year);
            }
        });

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour=tp.getCurrentHour();
                int min=tp.getCurrentMinute();
                tvDisplay.setText("Time is "+hour+": "+min);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
                dp.updateDate(2020,0,1);
            }
        });



    }
}