package com.example.CozaStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "u_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    @JsonIgnore
    private Date date;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailEntity> orderDetails;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
