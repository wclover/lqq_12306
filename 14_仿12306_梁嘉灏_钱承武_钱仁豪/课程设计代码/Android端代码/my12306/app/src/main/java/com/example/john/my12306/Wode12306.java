package com.example.john.my12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Wode12306 extends AppCompatActivity {
    Button _shouye;
    Button _qiaopiao;
    Button _dingdan;
    Button _aboutapp;
    Button _zhanghu;
    Button _shouji;
    Button _baoxian;
    Button _chuxing;
    Button _wenxin;
    Button _xinxi;
    Button _dingcan;
    Button _lvxing;
    TextView _heyan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geren);
        ExitApplication.getInstance().addActivity(this);
        _shouye = (Button)findViewById(R.id.shouye);
        _qiaopiao = (Button)findViewById(R.id.qiangpiao);
        _dingdan = (Button)findViewById(R.id.dingdan);
        _zhanghu = (Button)findViewById(R.id.zhanghu);
        _shouji = (Button)findViewById(R.id.shouji);
        _baoxian = (Button)findViewById(R.id.baoxian);
        _chuxing = (Button)findViewById(R.id.chuxing);
        _wenxin = (Button)findViewById(R.id.wenxin);
        _xinxi = (Button)findViewById(R.id.xinxi);
        _lvxing = (Button)findViewById(R.id.lvxing);
        _aboutapp = (Button)findViewById(R.id.aboutapp);
        _dingcan = (Button)findViewById(R.id.dingcan);
        _heyan = (TextView)findViewById(R.id.heyan);

        _shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wode12306.this, MainActivity.class));
            }
        });

        // 所有的按件连接到外网
        _chuxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://map.baidu.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        _wenxin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://ai.m.taobao.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        _lvxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.amap.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        _dingcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.ele.me/home/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        _baoxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.pingan.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        _xinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.baidu.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // 关于我们的页面
        _aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Wode12306.this, AboutappActivity.class));
            }
        });
        _shouji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wode12306.this, DuanXinActivity.class);
                startActivityForResult(intent,1);
            }
        });
        _dingdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Wode12306.this, DingdanActivity.class);
                startActivityForResult(intent,1);
            }
        });
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
                            ExitApplication.getInstance().exit(Wode12306.this);
                        }

                    }).show();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1 :
                if(resultCode == RESULT_OK){
                    String returnedData1 = data.getStringExtra("return_yanzhengma");
                    _heyan.setVisibility(View.VISIBLE);
                }
                break;
            default:
        }
    }
}
