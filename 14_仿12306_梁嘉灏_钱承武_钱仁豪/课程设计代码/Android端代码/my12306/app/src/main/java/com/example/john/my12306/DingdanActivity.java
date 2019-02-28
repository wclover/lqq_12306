package com.example.john.my12306;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class DingdanActivity extends AppCompatActivity{

    Button _shouye;
    Button _geren;
    Button _Button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);

        _shouye = (Button)findViewById(R.id.shouye);
        _geren = (Button)findViewById(R.id.wode12306);
        _Button1 = (Button)findViewById(R.id.button1);

        _shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DingdanActivity.this, MainActivity.class));
            }
        });
        _geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DingdanActivity.this, Wode12306.class));
            }
        });
        // 查看订单
        _Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DingdanActivity.this, Huochedingdan.class);
                startActivity(intent);
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
                            ExitApplication.getInstance().exit(DingdanActivity.this);
//                            Intent intent = new Intent(DingdanActivity.this,MainActivity.class);
//                            startActivity(intent);
                        }

                    }).show();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

}
