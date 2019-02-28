package com.example.john.my12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button _data_button;
    Button _chufa_button;
    Button _zhongdian_button;
    Button _chaxun;
    Button _jiaohuan_button;
    Button _wode12306_button;
    //Button _car_button;
    Button _plane_button;
    Button _ship_button;
    Button _dingdan_button;
    Button _leixing_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _data_button = (Button)findViewById(R.id.data_button);
        _chufa_button = (Button)findViewById(R.id.chufa_button);
        _zhongdian_button = (Button)findViewById(R.id.zhongdian_button);
        _jiaohuan_button = (Button)findViewById(R.id.jiaohuan_button);
        _wode12306_button = (Button)findViewById(R.id.wode12306);

//        _leixing_button = (Button)findViewById(R.id.leixing);

        //_car_button = (Button)findViewById(R.id.huochepiao) ;
        _plane_button = (Button)findViewById(R.id.jipiao);
        _ship_button = (Button)findViewById(R.id.qichepiao_chuanpiao);
        _chaxun = (Button)findViewById(R.id.chaxun);

        _dingdan_button = (Button)findViewById(R.id.dingdan);

        // 选择日期
        _data_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataActivity.class);
                startActivityForResult(intent,1);
            }
        });
        // 出发城市
        _chufa_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivityForResult(intent,2);
            }
        });
        // 到达城市
        _zhongdian_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CityActivity_arrive.class);
                startActivityForResult(intent,3);
            }
        });
//        _leixing_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, TypeActivity.class);
//                startActivityForResult(intent,4);
//            }
//        });
        // 交换出发城市与到达城市
        _jiaohuan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = _chufa_button.getText().toString();
                String data2 = _zhongdian_button.getText().toString();
                _chufa_button.setText(data2);
                _zhongdian_button.setText(data1);
            }
        });
        // 个人中心页面
        _wode12306_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Wode12306.class);
                startActivity(intent);
            }
        });
        // 飞机票
        _plane_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityPlane.class);
                startActivity(intent);
            }
        });
        // 船票
        _ship_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityShip.class);
                startActivity(intent);
            }
        });
        // 订单页面
        _dingdan_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DingdanActivity.class);
                startActivity(intent);
            }
        });
        // 选择完毕，开始根据信息查询
        _chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取编辑器
                // 步骤1：创建一个SharedPreferences对象
                // 步骤2： 实例化SharedPreferences.Editor对象
                SharedPreferences.Editor editor = getSharedPreferences("all_data", MODE_PRIVATE).edit();
                // 步骤3：将获取过来的值放入文件
                editor.putString("出发站", _chufa_button.getText().toString());
                editor.putString("到达站", _zhongdian_button.getText().toString());
                editor.putString("出发日期", _data_button.getText().toString());
//                editor.putString("类型", _leixing_button.getText().toString());
                // 提交
                //步骤4：提交
//                editor.commit();
                editor.apply();
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
    }

    // 页面跳转的返回信息
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
            case 4 :
                if(resultCode == RESULT_OK){
                    String returnedleixing = data.getStringExtra("data_return_type");
                    _leixing_button.setText(returnedleixing);
                }
                break;

            default:
        }
    }

    // 退出程序
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
            //详细的操作代码
            new AlertDialog.Builder(this)
                    .setTitle("确定退出程序么")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }

                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int whichButton) {
                            finish();
                            ExitApplication.getInstance().exit(MainActivity.this);
                        }

                    }).show();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

}
