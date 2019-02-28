package com.example.john.my12306;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Response;

public class Huochedingdan extends AppCompatActivity implements View.OnClickListener{

    TextView responseText;
    Button result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huochedingdan);

        result = (Button)findViewById(R.id.result_button);
        responseText = (TextView) findViewById(R.id.response_text);
        result.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.result_button){
            sendRequestWithHttpOKConnection();
        }
    }

    // 想服务端发送查看订单消息
    private void sendRequestWithHttpOKConnection(){
        HttpUtil.GetDingdan_byusername(HttpUtil.ADDRESS_GETBYUSERNAME,new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseData = response.body().string();
                final String result = parseXml(responseData);
                // 显示
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        responseText.setText(result);
                    }
                });

            }
        },LoginActivity.zhanghao);
    }

    // 剖析火车订单返回的 xml 文件
    private String parseXml(String data){
        StringBuilder builder = new StringBuilder();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            // 解析器
            XmlPullParser parser = factory.newPullParser();
            // 解析器设定数据
            parser.setInput(new StringReader(data));
            // 节点类型、名字、值
            int eventType = parser.getEventType();
            while ( eventType != XmlPullParser.END_DOCUMENT ){
                // 节点名称
                String nodeName = parser.getName();
                switch (eventType){
                    // 根据节点类型，完成读取　<>开始  </>结束
                    case XmlPullParser.START_TAG:{
                        if( "username".equals(nodeName) ){
                            String username = parser.nextText();// 读取节点名字
                            builder.append(username).append("--");
                        }
                        if( "name".equals(nodeName) ){
                            String name = parser.nextText();// 读取节点名字
                            builder.append(name).append("--");
                        }
                        if( "time".equals(nodeName) ){
                            String time = parser.nextText();// 读取节点名字
                            builder.append(time).append("--");
                        }
                        if( "start".equals(nodeName) ){
                            String start = parser.nextText();
                            builder.append(start).append("-->");
                        }
                        if( "arrive".equals(nodeName) ){
                            String arrive = parser.nextText();
                            builder.append(arrive).append("--");
                        }
                        if( "start_time".equals(nodeName) ){
                            String start_time = parser.nextText();
                            builder.append(start_time).append("-->");
                        }
                        if( "arrive_time".equals(nodeName) ){
                            String arrive_time = parser.nextText();
                            builder.append(arrive_time).append("--");
                        }
                        if("price".equals(nodeName)){
                            String price = parser.nextText();
                            builder.append(price).append("--");
                        }
                        if( "type".equals(nodeName) ){
                            String type = parser.nextText();// 读取节点名字
                            builder.append(type).append("");
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:{
                        if("dingdan".equals(nodeName)){
                            builder.append("\n");
                        }
                        break;
                    }
                }
                // 下一个节点
                eventType = parser.next();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  builder.toString();
    }
}
