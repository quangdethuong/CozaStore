package com.example.CozaStore.payload.response;

public class UserResponse {
    int id;
    String email,UserName;

    public UserResponse(int id, String email, String userName) {
        this.id = id;
        this.email = email;
        UserName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
