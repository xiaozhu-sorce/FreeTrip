package com.example.freetrip.databean;

public class Route {

    /**
     * id : 805
     * price : 910
     * name : 线路五
     * line : 牛首山文化旅游区——颐和路公馆区——神道——南京1912——大明寺
     * city : nanjing
     */

    private int id;
    private int price;
    private String name;
    private String line;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
