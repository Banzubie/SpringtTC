package com.example.SpringTC;

public class Device {

    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Device(String id, String type) {
        this.id = id;
        this.type = type;
    }
}
