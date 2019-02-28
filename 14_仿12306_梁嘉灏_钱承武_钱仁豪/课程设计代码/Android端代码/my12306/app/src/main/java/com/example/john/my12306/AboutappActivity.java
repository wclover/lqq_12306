package com.example.john.my12306;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutappActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutapp);
        ExitApplication.getInstance().addActivity(this);
    }
}
