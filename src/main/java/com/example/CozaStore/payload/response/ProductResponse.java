package com.example.CozaStore.payload.response;

import java.util.List;

public class ProductResponse {
    private int id;
    private String name;
    private double price;

    private String description;

    private ImageResponse image;

    private SizeResponse size;

    private ColorResponse color;

    private CategoryResponse category;

    public ProductResponse(){

    }

    public ProductResponse(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductResponse(int id, String name, double price, ImageResponse image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public ProductResponse(int id, String name, double price, String description, ImageResponse image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public ProductResponse(int id, String name, double price, String description, ImageResponse image, SizeResponse size, ColorResponse color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.size = size;
        this.color = color;
    }

    public ProductResponse(int id, String name, double price, String description, ImageResponse image, SizeResponse size, ColorResponse color, CategoryResponse category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.size = size;
        this.color = color;
        this.category = category;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public void setCategory(CategoryResponse category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ImageResponse getImage() {
        return image;
    }

    public void setImage(ImageResponse image) {
        this.image = image;
    }

    public SizeResponse getSize() {
        return size;
    }

    public void setSize(SizeResponse size) {
        this.size = size;
    }

    public ColorResponse getColor() {
        return color;
    }

    public void setColor(ColorResponse color) {
        this.color = color;
    }
}
