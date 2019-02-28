package com.example.john.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CityActivity extends AppCompatActivity {
    Button _shanghai;
    Button _beijing;
    Button _hangzhou;
    Button _yiwu;
    Button _sousuo;
    private EditText _startbtn;

    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ExitApplication.getInstance().addActivity(this);

        _shanghai = (Button)findViewById(R.id.button_shanghai);
        _beijing = (Button)findViewById(R.id.button_beijing);
        _hangzhou = (Button)findViewById(R.id.button_hangzhou);
        _yiwu = (Button)findViewById(R.id.button_yiwu);
        _sousuo = (Button)findViewById(R.id.sousuo);
        _startbtn = (EditText)findViewById(R.id.startbtn);

        // 返回选择的城市给主界面
        _sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city = _startbtn.getText().toString();
//                Toast.makeText(getApplicationContext(),city,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CityActivity.this, MainActivity.class);
                intent.putExtra("return_chufa", city);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        _shanghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = _shanghai.getText().toString();
                Intent intent = new Intent(CityActivity.this, MainActivity.class);
                intent.putExtra("return_chufa", data1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        _beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = _beijing.getText().toString();
                Intent intent = new Intent(CityActivity.this, MainActivity.class);
                intent.putExtra("return_chufa", data1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        _hangzhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = _hangzhou.getText().toString();
                Intent intent = new Intent(CityActivity.this, MainActivity.class);
                intent.putExtra("return_chufa", data1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        _yiwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = _yiwu.getText().toString();
                Intent intent = new Intent(CityActivity.this, MainActivity.class);
                intent.putExtra("return_chufa", data1);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
