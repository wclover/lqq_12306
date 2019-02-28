package com.example.john.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TypeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        ExitApplication.getInstance().addActivity(this);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group1);

        // 返回选择的票型
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton radioButton = (RadioButton) findViewById(i);
                Intent intent = new Intent();
                intent.putExtra("data_return_type", radioButton.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
