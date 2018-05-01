package com.syqu.shop.cart;

import com.syqu.shop.product.Product;
import com.syqu.shop.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "CART_product", joinColumns = @JoinColumn(name = "CART_id") , inverseJoinColumns = @JoinColumn(name = "PRODUCT_id") )
    private Set<Product> products;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
