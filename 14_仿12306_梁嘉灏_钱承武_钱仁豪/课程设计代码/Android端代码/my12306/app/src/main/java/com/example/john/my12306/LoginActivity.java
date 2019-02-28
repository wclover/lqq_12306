package com.example.john.my12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity{

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    Button _denglu;
    Button _zhuce;
    private EditText _zhanghaoText;
    private EditText _mimaText;

    String result;
    static String zhanghao;
    String mima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_login);

        _denglu = (Button)findViewById(R.id.denglu);
        _zhuce = (Button)findViewById(R.id.zhucu);
        _zhanghaoText = (EditText)findViewById(R.id.zhanghao);
        _mimaText = (EditText)findViewById(R.id.mima);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            _zhanghaoText.setText(account);
            _mimaText.setText(password);
            rememberPass.setChecked(true);
        }

        // 登录条件的判断
        _denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zhanghao = _zhanghaoText.getText().toString();
                mima = _mimaText.getText().toString();

                HttpUtil.Login(HttpUtil.ADDRESS_GETBYACCOUNT, new okhttp3.Callback(){
                    @Override
                    public void onResponse(Call call, Response response) {
                        try {
                           final String responseData = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(responseData.trim().equals("true")){
                                        Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
//                                        if (zhanghao.equals("whiteclover") && mima.equals("whiteclover")){
                                            editor = pref.edit();
                                            // 记住密码
                                            if(rememberPass.isChecked()){
                                                editor.putBoolean("remember_password", true);
                                                editor.putString("account", zhanghao);
                                                editor.putString("password", mima);
                                            }else {
                                                editor.clear();
                                            }
                                            editor.apply();
//                                        }
                                        Intent intent = new Intent();
                                        intent.putExtra("return_login_result", "登录成功");
                                        ListActivity.iflogin = true;
                                        setResult(RESULT_OK, intent);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();
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

        _zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1 :
                if (requestCode == RESULT_OK ){

                }
                break;

            default:
        }
    }
}
