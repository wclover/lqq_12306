package com.example.john.my12306;

public class traindingdan {
    // 火车订单信息
    private String time;
    private String start;
    private String arrive;
    private String start_time;
    private String arrive_time;
    private String price;

    public traindingdan(String time, String start, String arrive, String start_time, String arrive_time, String price) {
        this.time = time;
        this.start = start;
        this.arrive = arrive;
        this.start_time = start_time;
        this.arrive_time = arrive_time;
        this.price = price;
    }

    public traindingdan() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "traindingdan{" + "time='" + time + '\'' + ", start='" + start + '\'' + ", arrive='" + arrive + '\'' + ", start_time='" + start_time + '\'' + ", arrive_time='" + arrive_time + '\'' + ", price='" + price + '\'' + '}';
    }
}
