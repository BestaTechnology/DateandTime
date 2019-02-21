package com.example.dateandtime;

import android.animation.TimeAnimator;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


    TextView textView;
    Button button;

    int day, month, year, hour, mint;
    int dayFinal, monthFinal, yearfinal, hourFinal, mintfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       textView = (TextView)findViewById(R.id.textview);
        button=(Button)findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendarObj = Calendar.getInstance();
                year = calendarObj.get(Calendar.YEAR);
                month = calendarObj.get(Calendar.MONTH);
                day= calendarObj.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,MainActivity.this,
                        year,month,day);
                datePickerDialog.show();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        yearfinal = year;
        monthFinal = month;
        dayFinal= dayOfMonth;
        Calendar calendarObj= Calendar.getInstance();
        hour= calendarObj.get(Calendar.HOUR_OF_DAY);
        mint =calendarObj.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,MainActivity.this,hour,mint,true);
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        hourFinal = hourOfDay;
        mintfinal= minute;

        textView.setText("Year :" +yearfinal+ "\n"+ "Month :"+ monthFinal+"\n"+"Day:"+dayFinal+"\n"
        +"Hours: "+hourOfDay+"\n"+"Minutes :"+mintfinal);

    }
}
