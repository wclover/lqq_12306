package com.example.john.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;

import java.util.Calendar;


public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int mYear, mMonth, mDay;
        super.onCreate(savedInstanceState);
        ExitApplication.getInstance().addActivity(this);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏活动标题
        setContentView(R.layout.activity_data);
        DatePicker dp = new DatePicker(this);
        dp = (DatePicker) findViewById(R.id.date);

        Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        // 选择的日期，并按想要的格式返回给主界面
        dp.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker View, int year, int month, int day) {
                        month++;
                        Intent intent = new Intent();
                        intent.putExtra("return_data", year + "-" + month  + "-" + day);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
    }
}

