package com.example.john.my12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivityPlane extends AppCompatActivity {
    Button _data_button;
    Button _chufa_button;
    Button _zhongdian_button;
    Button _chaxun;
    Button _jiaohuan_button;
    Button _wode12306_button;
    Button _car_button;
    //Button _plane_button;
    Button _ship_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_plane);

        _data_button = (Button)findViewById(R.id.data_button);
        _chufa_button = (Button)findViewById(R.id.chufa_button);
        _zhongdian_button = (Button)findViewById(R.id.zhongdian_button);
        _jiaohuan_button = (Button)findViewById(R.id.jiaohuan_button);
        _wode12306_button = (Button)findViewById(R.id.wode12306);

        _car_button = (Button)findViewById(R.id.huochepiao) ;
        //_plane_button = (Button)findViewById(R.id.tu_jipiao);
        _ship_button = (Button)findViewById(R.id.qichepiao_chuanpiao);
        //_chaxun = (Button)findViewById(R.id.chaxun);

        _data_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPlane.this, DataActivity.class);
                startActivityForResult(intent,1);
            }
        });
        _chufa_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPlane.this, CityActivity.class);
                startActivityForResult(intent,2);
            }
        });
        _zhongdian_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPlane.this, CityActivity_arrive.class);
                startActivityForResult(intent,3);
            }
        });
        _jiaohuan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = _chufa_button.getText().toString();
                String data2 = _zhongdian_button.getText().toString();
                _chufa_button.setText(data2);
                _zhongdian_button.setText(data1);
            }
        });
        _wode12306_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPlane.this, Wode12306.class);
                startActivity(intent);
            }
        });
        _car_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPlane.this, MainActivity.class);
                startActivity(intent);
            }
        });
        _ship_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityPlane.this, MainActivityShip.class);
                startActivity(intent);
            }
        });
//        _chaxun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 获取编辑器
//                // 步骤1：创建一个SharedPreferences对象
//                // 步骤2： 实例化SharedPreferences.Editor对象
//                SharedPreferences.Editor editor = getSharedPreferences("all_data_plane", MODE_PRIVATE).edit();
//                // 步骤3：将获取过来的值放入文件
//                editor.putString("出发站", _chufa_button.getText().toString());
//                editor.putString("到达站", _zhongdian_button.getText().toString());
//                editor.putString("出发日期", _data_button.getText().toString());
////                editor.putString("类型", _leixing_button.getText().toString());
//                // 提交
//                //步骤4：提交
////                editor.commit();
//                editor.apply();
//                Intent intent = new Intent(MainActivityPlane.this, ListActivity_Plane.class);
//                startActivity(intent);
//            }
//        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1 :
                if(resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("return_data");
                    _data_button.setText(returnData);
                }
                break;
            case 2 :
                if(resultCode == RESULT_OK){
                    String returnChufa = data.getStringExtra("return_chufa");
                    _chufa_button.setText(returnChufa);
                }
                break;
            case 3 :
                if(resultCode == RESULT_OK){
                    String returnZhongdian = data.getStringExtra("return_zhongdian");
                    _zhongdian_button.setText(returnZhongdian);
                }
                break;


            default:
        }
    }
}
