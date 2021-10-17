package com.example.date;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.d);
        b2=findViewById(R.id.t);
        tv1=findViewById(R.id.date);
        tv2=findViewById(R.id.time);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();//static method that generates an instance of the calendar class
                //this c instance lets us choose the month year and day
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                //a new dialog appears to set date and in the next one time
                //DatePickerDialog n = new DatePickerDialog(MainActivity.this,new ,year,month,day)
                DatePickerDialog dp = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        //selected i=year i1=month(0-11) isiliye (+1) i2=day
                        tv1.setText(i2 + "/" + (i1+1) + "/" + i);
                    }
                }, year, month, day);
                dp.show();
                //this expects 5 parameter(date picker dialog)
//                1.Context
//                2.listener
//                3.4.5.year month date....has to be in this order
                //before writing listener add the year,month,day
                //by default it shows random..... date we need to enter to show the current date

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int min = c.get(Calendar.MINUTE);
                //hour,min,boolean 24hr view(true) or 12 hr view
                TimePickerDialog tp =new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tv2.setText(i + ":" +i1);
                    }
                }, hour, min, true);
                tp.show();
            }
        });
    }
}