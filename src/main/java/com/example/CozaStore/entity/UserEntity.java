package com.example.CozaStore.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<BlogEntity> blogs;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<OrderEntity> orders;

    public UserEntity(int id, String username, String password, String email, Set<BlogEntity> blogs, Set<OrderEntity> orders) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.blogs = blogs;
        this.orders = orders;
    }

    public UserEntity(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserEntity() {
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<BlogEntity> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<BlogEntity> blogs) {
        this.blogs = blogs;
    }
}
