package com.example.john.my12306;

import android.util.Log;
import android.widget.Toast;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static java.net.Proxy.Type.HTTP;

public class HttpUtil {

//    public static final String ADDRESS_CHEPIAO = "http://192.168.204.98:9090/12306/get_chepiao.jsp";
//    public static final String ADDRESS_DINGDAN = "http://192.168.204.98:9090/12306/get_dingdan.jsp";
//    public static final String ADDRESS_ADD_DINGDAN = "http://192.168.204.98:9090/12306/add_dingdan.jsp";
//    public static final String ADDRESS_UPDATE_YIDENG = "http://192.168.204.98:9090/12306/update_yideng.jsp";
//    public static final String ADDRESS_UPDATE_ERDENG = "http://192.168.204.98:9090/12306/update_erdeng.jsp";
//    public static final String ADDRESS_UPDATE_WUZUODENG = "http://192.168.204.98:9090/12306/update_wuzuo.jsp";
//    public static final String ADDRESS_GETBYACCOUNT = "http://192.168.204.98:9090/12306/login.jsp";
//    public static final String ADDRESS_GETBYUSERNAME = "http://192.168.204.98:9090/12306/get_dingdan_by_name.jsp";
//    public static final String ADDRESS_ADD_LOGIN = "http://192.168.204.98:9090/12306/add_login.jsp";

    public static final String ADDRESS_CHEPIAO = "http://192.168.43.159:9090/12306/get_chepiao.jsp";
    public static final String ADDRESS_DINGDAN = "http://192.168.43.159:9090/12306/get_dingdan.jsp";
    public static final String ADDRESS_ADD_DINGDAN = "http://192.168.43.159:9090/12306/add_dingdan.jsp";
    public static final String ADDRESS_UPDATE_YIDENG = "http://192.168.43.159:9090/12306/update_yideng.jsp";
    public static final String ADDRESS_UPDATE_ERDENG = "http://192.168.43.159:9090/12306/update_erdeng.jsp";
    public static final String ADDRESS_UPDATE_WUZUODENG = "http://192.168.43.159:9090/12306/update_wuzuo.jsp";
    public static final String ADDRESS_GETBYACCOUNT = "http://192.168.43.159:9090/12306/login.jsp";
    public static final String ADDRESS_GETBYUSERNAME = "http://192.168.43.159:9090/12306/get_dingdan_by_name.jsp";
    public static final String ADDRESS_ADD_LOGIN = "http://192.168.43.159:9090/12306/add_login.jsp";

    // 查看所有订单
    public static void sendOKHttpRequest(final String address, final okhttp3.Callback callback){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url(address).build();
                    client.newCall(request).enqueue(callback);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 通过用户名查询所定车票
    public static void GetDingdan_byusername(final String address, final okhttp3.Callback callback, final String username){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("username",username).build();
                    Request request = new Request.Builder().url(address).post(requestBody).build();
                    client.newCall(request).enqueue(callback);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 添加订单
    public static void senddingdan(final String address, final okhttp3.Callback callback, final String name, final String time, final String start,
                                   final String arrive, final String start_time, final String arrive_time, final String price, final String type){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("username",LoginActivity.zhanghao).add("name", name).add("time", time).add("start",start).
                            add("arrive",arrive).add("start_time",start_time).add("arrive_time",arrive_time).
                            add("price",price).add("type",type).build();
                    Request request = new Request.Builder().url(address).post(requestBody).build();

                    Response response = client.newCall(request).execute();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 修改一等票的票数
    public static void update_yideng(final String address, final okhttp3.Callback callback, final String name, final String yideng){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("yideng",yideng).add("checi", name).build();
//                    Log.i("**********", "checi "+name + " " + "yideng" + yideng);
                    Request request = new Request.Builder().url(address).post(requestBody).build();

                    client.newCall(request).enqueue(callback);
//                    Response response = client.newCall(request).execute();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 修改二等票的票数
    public static void update_erdeng(final String address, final okhttp3.Callback callback, final String name, final String erdeng){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("erdeng",erdeng).add("checi", name).build();
//                    Log.i("**********", "checi "+name + " " + "erdeng" + erdeng);
                    Request request = new Request.Builder().url(address).post(requestBody).build();

                    client.newCall(request).enqueue(callback);
//                    Response response = client.newCall(request).execute();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 修改无座的票数
    public static void update_wuzuo(final String address, final okhttp3.Callback callback, final String name, final String wuzuo){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("wuzuo",wuzuo).add("checi", name).build();
                    Request request = new Request.Builder().url(address).post(requestBody).build();

                    client.newCall(request).enqueue(callback);
//                    Response response = client.newCall(request).execute();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 判断登录是否正确
    public static void Login(final String address, final okhttp3.Callback callback, final String zhanghao, final String mima){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("zhanghao",zhanghao).add("mima", mima).build();
                    Request request = new Request.Builder().url(address).post(requestBody).build();
                    client.newCall(request).enqueue(callback);
//                    Response response = client.newCall(request).execute();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 注册
    public static void sendOkHttpRequestWithBody(String address, RequestBody body, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    // 注册
    public static void add_login(final String address, final okhttp3.Callback callback, final String username, final String password){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("username",username).add("password",password).build();
                    Request request = new Request.Builder().url(address).post(requestBody).build();

                    client.newCall(request).enqueue(callback);
//                    Response response = client.newCall(request).execute();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
