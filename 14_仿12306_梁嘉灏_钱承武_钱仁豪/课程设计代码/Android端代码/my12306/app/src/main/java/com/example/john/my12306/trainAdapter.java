package com.example.john.my12306;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

// 火车适配器
public class trainAdapter extends RecyclerView.Adapter<trainAdapter.ViewHolder>{
    private List<train> mtrainList;
    String type;
    OnItemClickListener onItemClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView trainname;
        TextView startcity;
        TextView arrivecity;
        TextView qi_time;
        TextView mo_time;
        TextView traintype;
        TextView trainyi_num;
        TextView trainer_num;
        TextView trainwu_num;
        TextView trainmoney;
//        View trainView;
        Button goupiao;

        public ViewHolder(View view){
            super(view);
//            trainView = view;
            trainname = (TextView) view.findViewById(R.id.name);
            startcity = (TextView)view.findViewById(R.id.start);
            arrivecity = (TextView)view.findViewById(R.id.arrive);
            qi_time = (TextView) view.findViewById(R.id.qi_time);
            mo_time = (TextView) view.findViewById(R.id.mo_time);
            traintype = (TextView) view.findViewById(R.id.type);
            trainyi_num = (TextView) view.findViewById(R.id.yi_num);
            trainer_num = (TextView) view.findViewById(R.id.er_num);
            trainwu_num = (TextView) view.findViewById(R.id.wu_num);
            trainmoney = (TextView) view.findViewById(R.id.money);
            goupiao = (Button)view.findViewById(R.id.qiangpiao);
        }
    }

    public trainAdapter(List<train> trainList){
        mtrainList = trainList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount(){
        return mtrainList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        Button gp = (Button)holder.itemView.findViewById(R.id.qiangpiao);
        gp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 调用回调函数
                onItemClickListener.onItemClick(view);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onItemClickListener.onItemClick(view);
//            }
//        });
//        // 单个控件的单击
//        holder.goupiao.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
////                ItemClickListener.onItemClick(V);
//                int position = holder.getAdapterPosition();// 获取适配器数据的下标
//                train info = mtrainList.get(position);
//
//                Log.i("***", info.getName()+" "+info.getStart()+" "+info.getArrive()+" "+info.getQi_time()+" "+info.getMo_time()+" "+info.getMoney());
////                Log.i("***", type);
//                //Intent intent = new Intent(, DataActivity.class);
//                //startActivityForResult(intent,1);
////                startActivity(intent);
//                String address = "http://192.168.204.98:9090/12306/add_dingdan.jsp";
//                //String address = "http://169.254.25.136:9090/twqs/game.jsp";
//                HttpUtil.senddingdan(address,new okhttp3.Callback(){
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        final String responseData = response.body().string();
//                        parseXml(responseData);
//                    }
//                },info.getName(),info.getStart(),info.getArrive(),info.getQi_time(),info.getMo_time(),info.getMoney());
//            }
//        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        train train = mtrainList.get(position);
        holder.trainname.setText(train.getName());
        holder.startcity.setText(train.getStart());
        holder.arrivecity.setText(train.getArrive());
        holder.qi_time.setText(train.getQi_time());
        holder.mo_time.setText(train.getMo_time());
        holder.traintype.setText(train.getType());
        holder.trainyi_num.setText(train.getYi_Num());
        holder.trainer_num.setText(train.getEr_num());
        holder.trainwu_num.setText(train.getWu_num());
        holder.trainmoney.setText(train.getMoney());
        // 得到位置下标
        holder.goupiao.setTag(position);
    }

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
                        if( "time".equals(nodeName) ){
                            String time = parser.nextText();// 读取节点名字
                            builder.append(time).append("\t");
                        }
                        if( "name".equals(nodeName) ){
                            String name = parser.nextText();
                            builder.append(name).append("\t");
                        }
                        if( "start".equals(nodeName) ){
                            String start = parser.nextText();
                            builder.append(start).append("-->");
                        }
                        if( "arrive".equals(nodeName) ){
                            String arrive = parser.nextText();
                            builder.append(arrive).append("\t");
                        }
                        if( "start_time".equals(nodeName) ){
                            String start_time = parser.nextText();
                            builder.append(start_time).append("-->");
                        }
                        if( "arrive_time".equals(nodeName) ){
                            String arrive_time = parser.nextText();
                            builder.append(arrive_time).append("\t");
                        }
                        if("price".equals(nodeName)){
                            String price = parser.nextText();
                            builder.append(price);
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:{
                        if("games".equals(nodeName)){
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
