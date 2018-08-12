package com.manju7.demo;

public class Chat {

    public String  message;
    public boolean isSend;


    public Chat(String message, boolean isSend) {
        this.message = message;
        this.isSend = isSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }
}
