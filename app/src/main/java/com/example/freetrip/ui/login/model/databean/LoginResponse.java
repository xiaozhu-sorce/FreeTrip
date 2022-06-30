package com.example.freetrip.ui.login.model.databean;

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

    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String name;
        private String password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
