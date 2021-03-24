package com.example.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText eDate, eTime;
    private Button btnDate, btnTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnDate.setOnClickListener(this);
        btnTime.setOnClickListener(this);

    }
    private void initView(){
        eDate = findViewById(R.id.date);
        eTime = findViewById(R.id.time);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnDate){
            Calendar c = Calendar.getInstance();
            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    eDate.setText(dayOfMonth+"/"+month+1+"/"+year);
                }
            },2000,1,20);
            dialog.show();
        }
        if(v== btnTime){
            Calendar c = Calendar.getInstance();
            int h = c.get(Calendar.HOUR);
            int m = c.get(Calendar.MINUTE);
            TimePickerDialog dialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    eTime.setText(hourOfDay+":"+minute);
                }
            },h,m,false);
            dialog.show();
        }
    }
}