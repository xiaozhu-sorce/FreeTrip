package com.example.freetrip.ui.login.model.databean;

import com.example.freetrip.databean.User;

public class LoginResponse {

    /**
     * msg : ok
     * data : {"id":7,"name":"xiaozhu","password":"12345678"}
     */

    private String msg;
    /**
     * id : 7
     * name : xiaozhu
     * password : 12345678
     */

    private User data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
