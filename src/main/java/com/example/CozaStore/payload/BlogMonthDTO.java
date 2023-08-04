package com.example.CozaStore.payload;

import java.util.HashMap;
import java.util.List;

public class BlogMonthDTO {
    private HashMap<String,Integer> data;

    public BlogMonthDTO(HashMap<String, Integer> data) {
        this.data = data;
    }

    public BlogMonthDTO() {
    }

    public HashMap<String, Integer> getData() {
        return data;
    }

    public void setData(HashMap<String, Integer> data) {
        this.data = data;
    }
}
