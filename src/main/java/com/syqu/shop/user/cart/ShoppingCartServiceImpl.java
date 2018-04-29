package com.syqu.shop.user.cart;

import com.syqu.shop.product.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartServiceImpl implements ShoppingCartService{
    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public void saveCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addProduct(long id, Product product, int quantify) {
        findById(id).getProducts().put(product, quantify);
    }

    @Override
    public void removeProduct(long id, Product product) {
        findById(id).getProducts().remove(product);
    }

    @Override
    public void clearCart(long id) {
        findById(id).getProducts().clear();
    }


    @Override
    public ShoppingCart findById(long id) {
        return shoppingCartRepository.findById(id);
    }
}
