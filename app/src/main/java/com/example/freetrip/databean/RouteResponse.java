package com.example.freetrip.databean;


import java.util.List;

public class RouteResponse {

    /**
     * msg : search successful
     * code : 200
     * data : [{"id":805,"price":910,"name":"线路五","line":"牛首山文化旅游区\u2014\u2014颐和路公馆区\u2014\u2014神道\u2014\u2014南京1912\u2014\u2014大明寺","city":"nanjing"}]
     */

    private String msg;
    private int code;
    private List<Route> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Route> getData() {
        return data;
    }

    public void setData(List<Route> data) {
        this.data = data;
    }
}
