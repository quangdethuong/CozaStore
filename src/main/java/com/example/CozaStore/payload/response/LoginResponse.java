package com.example.CozaStore.payload.response;

public class LoginResponse {
    private int user_id;
    private String token;

    public LoginResponse(int user_id, String token) {
        this.user_id = user_id;
        this.token = token;
    }

    public LoginResponse() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
