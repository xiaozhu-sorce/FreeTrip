package com.example.freetrip.databean;

public class Blog {

    /**
     * build_time : 2005-06-04 05:52:15
     * content : magna in voluptate anim eiusmod
     * id : 11
     * praise : amet nisi
     * title : 声华化都
     * user_id : 42
     * user_name: xiaozhu
     */

    private String build_time;
    private String content;
    private int id;
    private String praise;
    private String title;
    private int user_id;
    private String user_name;

    public Blog(int id) {
        this.id = id;
    }

    public Blog(String content, int user_id) {
        this.content = content;
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getBuild_time() {
        return build_time;
    }

    public void setBuild_time(String build_time) {
        this.build_time = build_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
