package com.example.john.my12306;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    Button _queding;
    Button _quxiao;
    private EditText _zhanghaoText;
    private EditText _mimaText;
    String zhanghao;
    String mima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _queding = (Button)findViewById(R.id.sure);
        _quxiao = (Button)findViewById(R.id.cancel);
        _zhanghaoText = (EditText)findViewById(R.id.zhang_hao);
        _mimaText = (EditText)findViewById(R.id.mi_ma);

        // 是否能成功注册的判断
        _queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zhanghao = _zhanghaoText.getText().toString();
                mima = _mimaText.getText().toString();
                Toast.makeText(getApplicationContext(),zhanghao+" "+mima,Toast.LENGTH_SHORT).show();

                HttpUtil.add_login(HttpUtil.ADDRESS_ADD_LOGIN, new okhttp3.Callback(){
                    @Override
                    public void onResponse(Call call, Response response) {
                        try {
                            final String responseData = response.body().string();
                            Log.i("*********",responseData);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(responseData.trim().equals("true")){
                                        Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"注册失败",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }
                },zhanghao, mima);

            }
        });

        _quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
