package com.manju7.chatbot;

public class Model {

    public String response;
    public String id1;
    public String result;
    public String msg;

    public Model(String response, String id1, String result, String msg) {
        this.response = response;
        this.id1 = id1;
        this.result = result;
        this.msg = msg;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
