package com.example.john.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CityActivity_arrive extends AppCompatActivity{
    Button _shanghai;
    Button _beijing;
    Button _hangzhou;
    Button _yiwu;
    private EditText _endbtn;
    Button _sousuo_arrive;
    String arrive_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_arrive_city);
        ExitApplication.getInstance().addActivity(this);

        _shanghai = (Button)findViewById(R.id.button_shanghai);
        _beijing = (Button)findViewById(R.id.button_beijing);
        _hangzhou = (Button)findViewById(R.id.button_hangzhou);
        _yiwu = (Button)findViewById(R.id.button_yiwu);
        _sousuo_arrive = (Button)findViewById(R.id.sousuo_arrive);
        _endbtn = (EditText) findViewById(R.id.endbtn);

        // 返回选择的城市给主界面
        _sousuo_arrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrive_city = _endbtn.getText().toString();
//                Toast.makeText(getApplicationContext(),arrive_city,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CityActivity_arrive.this, MainActivity.class);
                intent.putExtra("return_zhongdian", arrive_city);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        _endbtn = (EditText)findViewById(R.id.endbtn);
        _shanghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data2 = _shanghai.getText().toString();
                Intent intent = new Intent(CityActivity_arrive.this, MainActivity.class);
                intent.putExtra("return_zhongdian", data2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        _beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data2 = _beijing.getText().toString();
                Intent intent = new Intent(CityActivity_arrive.this, MainActivity.class);
                intent.putExtra("return_zhongdian", data2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        _hangzhou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data2 = _hangzhou.getText().toString();
                Intent intent = new Intent(CityActivity_arrive.this, MainActivity.class);
                intent.putExtra("return_zhongdian", data2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        _yiwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data2 = _yiwu.getText().toString();
                Intent intent = new Intent(CityActivity_arrive.this, MainActivity.class);
                intent.putExtra("return_zhongdian", data2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
