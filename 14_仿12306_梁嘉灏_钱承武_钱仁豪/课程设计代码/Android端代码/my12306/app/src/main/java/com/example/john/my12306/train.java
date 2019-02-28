package com.example.john.my12306;

public class train {
    // 车票的各种信息
    private String name;
    private String start;
    private String arrive;
    private String type;
    private String qi_time;
    private String mo_time;
    private String yi_num;
    private String er_num;
    private String wu_num;
    private String money;

    public train(String name, String start, String arrive, String type, String qi_time, String mo_time, String yi_num, String er_num, String wu_num, String money) {
        this.name = name;
        this.start = start;
        this.arrive = arrive;
        this.type = type;
        this.qi_time = qi_time;
        this.mo_time = mo_time;
        this.yi_num = yi_num;
        this.er_num = er_num;
        this.wu_num = wu_num;
        this.money = money;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public String getMoney() {
        return money;
    }

    public String getName(){
        return name;
    }

    public String getQi_time() {
        return qi_time;
    }

    public String getMo_time() {
        return mo_time;
    }

    public String getType() {
        return type;
    }

    public String getYi_Num(){
        return yi_num;
    }

    public String getEr_num() {
        return er_num;
    }

    public String getWu_num() {
        return wu_num;
    }

    @Override
    public String toString() {
        return "train{" + "name='" + name + '\'' + ", start='" + start + '\'' + ", arrive='" + arrive + '\'' + ", type='" + type + '\'' + ", qi_time='" + qi_time + '\'' + ", mo_time='" + mo_time + '\'' + ", yi_num='" + yi_num + '\'' + ", er_num='" + er_num + '\'' + ", wu_num='" + wu_num + '\'' + ", money='" + money + '\'' + '}';
    }
}


