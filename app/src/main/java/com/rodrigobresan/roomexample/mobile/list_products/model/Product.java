package com.rodrigobresan.roomexample.mobile.list_products.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey
    private Long id;

    private String name;
    private String description;

    public Product(Long id, String name, String description, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.count = count;
    }

    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
