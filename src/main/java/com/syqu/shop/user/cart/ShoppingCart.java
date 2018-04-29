package com.syqu.shop.user.cart;

import com.syqu.shop.product.Product;
import com.syqu.shop.user.User;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {
    @Column(name = "cart_id") @Id @GeneratedValue(strategy = GenerationType.AUTO) private long id;
    @Column(name = "products") private HashMap<Product, Integer> products;
    @ManyToOne @JoinColumn(name = "shopping_cart") private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }
}
