package com.example.john.my12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListActivity extends AppCompatActivity {

    private Handler handler = null;

    TextView _show_place;
    TextView _show_date;
    String start;
    String arrive;
    String date;
    String newdate;
    SharedPreferences.Editor editor;

    TextView _name;
    TextView _money;
    TextView _qi_time;
    TextView _mo_time;
    TextView _type;
    TextView _yi_num;
    TextView _er_num;
    TextView _wu_num;
    TextView _price;

    int position;

    String checi;
    String startcity;
    String arrivecity;
    String chufa_date;
    String start_time;
    String arrive_time;
    String type;
    String leixing;
    String yideng;
    String erdeng;
    String wuzuo;
    String price;
    String responseData;

    static boolean iflogin = false;

    trainAdapter adapter;

    private List<train> trainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        trainList = new ArrayList<>();
        GetDay();

        // 接收
        // 读取数据：
        SharedPreferences pref = getSharedPreferences("all_data", MODE_PRIVATE);
        start = pref.getString("出发站", "");
        arrive = pref.getString("到达站", "");
        date = pref.getString("出发日期", "");
        leixing = pref.getString("类型", "");
        // 将日期格式转变，方便与数据库信息对应
        String[] result = date.split("-");
        if(result[2].length() < 2)
            newdate = result[0]+"-"+result[1]+"-"+"0"+result[2];
        else
            newdate = date;

        editor = getSharedPreferences("sjust_date_data", MODE_PRIVATE).edit();
        editor.putString("当前日期", date);

        editor.apply();
        _show_place = (TextView) findViewById(R.id.show_place);
        _show_date = (TextView) findViewById(R.id.show_date);
        _show_place.setText(start + "---" + arrive);
        _show_date.setText(newdate);

        _name = (TextView) findViewById(R.id.name);
        _money = (TextView) findViewById(R.id.money);
        _qi_time = (TextView) findViewById(R.id.qi_time);
        _mo_time = (TextView) findViewById(R.id.mo_time);
        _type = (TextView) findViewById(R.id.type);
        _yi_num = (TextView) findViewById(R.id.yi_num);
        _er_num = (TextView) findViewById(R.id.er_num);
        _wu_num = (TextView) findViewById(R.id.wu_num);
        _price = (TextView) findViewById(R.id.money);

        Button before = (Button) findViewById(R.id.before);
        Button after = (Button) findViewById(R.id.after);
        before.setOnClickListener(new BeforeDay());
        after.setOnClickListener(new AfterDay());

        parseXml(responseData);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new trainAdapter(trainList);
        recyclerView.setAdapter(adapter);

        //列表item的点击事件
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                if(iflogin == false) {
                    Intent intent = new Intent(ListActivity.this, LoginActivity.class);
                    startActivityForResult(intent, 1);
                }else {
                    Intent intent = new Intent(ListActivity.this, TypeActivity.class);
                    startActivityForResult(intent,2);
                    position = (int)view.getTag();
                }
            }
        });
    }

    protected void onActivityResult(final int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1 :
                if (requestCode == RESULT_OK ){

                }
                break;
            case 2:
                if(resultCode == RESULT_OK){
                    train train = trainList.get(position);
                    String returnData = data.getStringExtra("data_return_type");

                    // 根据不同的票型，扣除相应的票数
                    if (returnData.equals("一等座")) {
                        HttpUtil.update_yideng(HttpUtil.ADDRESS_UPDATE_YIDENG, new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                final String responseData = response.body().string();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (responseData.trim().equals("true"))
                                            Toast.makeText(getApplicationContext(), "购买成功", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(getApplicationContext(), "暂时无票", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }, train.getName(), train.getYi_Num());

                        trainList.clear();
                        parseXml(responseData);
                        AddTicket(train, returnData);
                    }
                    else if (returnData.equals("二等座")) {
                        HttpUtil.update_erdeng(HttpUtil.ADDRESS_UPDATE_ERDENG, new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                final String responseData = response.body().string();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (responseData.trim().equals("true"))
                                            Toast.makeText(getApplicationContext(), "购买成功", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(getApplicationContext(), "暂时无票", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        }, train.getName(), train.getEr_num());

                        trainList.clear();
                        parseXml(responseData);
                        AddTicket(train, returnData);
                    }
                    else if (returnData.equals("无座")) {
                        HttpUtil.update_wuzuo(HttpUtil.ADDRESS_UPDATE_WUZUODENG, new okhttp3.Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                final String responseData = response.body().string();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (responseData.trim().equals("true"))
                                            Toast.makeText(getApplicationContext(), "购买成功", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(getApplicationContext(), "暂时无票", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }, train.getName(), train.getWu_num());

                        GetDay();
                        adapter.notifyDataSetChanged();
                        try {
                            Thread.sleep(500);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        trainList.clear();
                        parseXml(responseData);
                        adapter.notifyDataSetChanged();

                        AddTicket(train, returnData);
                    }
                }

            default:
        }
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        adapter.notifyDataSetChanged();
//    }

    private void GetDay(){
        trainList.clear();

        Toast.makeText(ListActivity.this, "正在加载......", Toast.LENGTH_SHORT).show();

        HttpUtil.sendOKHttpRequest(HttpUtil.ADDRESS_CHEPIAO, new okhttp3.Callback(){
            @Override
            public void onResponse(Call call, Response response) {
                try {
                    responseData = response.body().string();
                    parseXml(responseData);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }

        });
//        parseXml(responseData);
    }

    // 显示前一天车票信息
    class BeforeDay implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            trainList.clear();
            SharedPreferences pref_date = getSharedPreferences("sjust_date_data", MODE_PRIVATE);
            date = pref_date.getString("当前日期", "");
            String beforeday = Before(date);
            editor = getSharedPreferences("sjust_date_data", MODE_PRIVATE).edit();
            editor.putString("当前日期", beforeday);
            editor.apply();
            _show_date.setText(beforeday);

//            GetDay();
            parseXml(responseData);
            adapter.notifyDataSetChanged();

        }
    }

    // 显示后一天车票信息
    class AfterDay implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            trainList.clear();
            SharedPreferences pref_date = getSharedPreferences("sjust_date_data", MODE_PRIVATE);
            date = pref_date.getString("当前日期", "");
            String beforeday = After(date);
            editor = getSharedPreferences("sjust_date_data", MODE_PRIVATE).edit();
            editor.putString("当前日期", beforeday);
            editor.apply();
            _show_date.setText(beforeday);

//            GetDay();
            parseXml(responseData);
            adapter.notifyDataSetChanged();

        }
    }

    // 返回前一天的日期
    public static String Before(String specifiedDay)
    {
        Calendar c = Calendar.getInstance();
        Date d_date=null;
        try {
            d_date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(d_date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-1);
        String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return  dayBefore;
    }

    // 返回后一天的日期
    private static String After(String specifiedDay)
    {
        Calendar c = Calendar.getInstance();
        Date d_date=null;
        try {
            d_date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(d_date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day+1);
        String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return  dayBefore;
    }

    // 买票，更新相应的数据库信息
    private  void AddTicket(train train, String returnData){
        HttpUtil.senddingdan(HttpUtil.ADDRESS_ADD_DINGDAN, new okhttp3.Callback(){
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        },train.getName(),newdate,train.getStart(),train.getArrive(),train.getQi_time(),train.getMo_time(),train.getMoney(),returnData);
    }

    // 剖析查票 xml 文件
    private void parseXml(String data){
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
                        if( "checi".equals(nodeName) ){
                            checi = parser.nextText();// 读取节点名字
                        }
                        else if( "date".equals(nodeName) ){
                            chufa_date = parser.nextText();
                        }
                        else if( "start".equals(nodeName) ) {
                            startcity = parser.nextText();
                        }
                        else if( "start_time".equals(nodeName) ){
                            start_time = parser.nextText();
                        }
                        else if( "arrive".equals(nodeName) ){
                            arrivecity = parser.nextText();
                        }
                        else if( "arrive_time".equals(nodeName) ){
                            arrive_time = parser.nextText();
                        }
                        else if("type".equals(nodeName)){
                            type = parser.nextText();
                        }
                        if("yideng".equals(nodeName)){
                            yideng = parser.nextText();
                        }
                        else if("erdeng".equals(nodeName)){
                            erdeng = parser.nextText();
                        }
                        else if("wuzuo".equals(nodeName)){
                            wuzuo = parser.nextText();
                        }
                        else if("price".equals(nodeName)) {
                            price = parser.nextText();
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:{
                        if("train".equals(nodeName)) {
                            // 显示条件相等的车票
                            if(start.equals(startcity) && arrive.equals(arrivecity) && _show_date.getText().equals(chufa_date)) {
                                trainList.add(new train(checi, startcity, arrivecity, type, start_time, arrive_time, yideng, erdeng, wuzuo, price));
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }
                // 下一个节点
                eventType = parser.next();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
