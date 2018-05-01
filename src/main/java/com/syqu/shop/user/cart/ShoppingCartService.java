package com.syqu.shop.user.cart;

import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
    void saveCart(ShoppingCart shoppingCart);
    void addProduct(long id, long productId);
    void removeProduct(long id, long productId);
    void clearCart(long id);
    ShoppingCart findById(long id);
}
