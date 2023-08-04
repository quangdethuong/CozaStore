package com.example.CozaStore.payload.response;

public class ColorResponse {
    private int id;
    private String name;

    public ColorResponse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ColorResponse(){}

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
}
