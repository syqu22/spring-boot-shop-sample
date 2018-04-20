package com.syqu.shop.product;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    @Column(name = "name") @NotNull @NotEmpty private String name;
    @Column(name = "description",length = 500) @NotNull @NotEmpty private String description;
    @Column(name = "image") @URL private String image_url;
    @Column(name = "price") private double price ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + " Name: " + getName() + " Description: " + getDescription() + " Price: " + getPrice();
    }
}
