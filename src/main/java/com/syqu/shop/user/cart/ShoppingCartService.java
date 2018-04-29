package com.syqu.shop.user.cart;

import com.syqu.shop.product.Product;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {
    void saveCart(ShoppingCart shoppingCart);
    void addProduct(long id, Product product, int quantify);
    void removeProduct(long id, Product product);
    void clearCart(long id);
    ShoppingCart findById(long id);
}
