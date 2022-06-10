package com.training.innova;

import java.io.Serializable;

public class MessageSend {

    private String dest;
    private String message;

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageSend{" +
                "dest='" + dest + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
