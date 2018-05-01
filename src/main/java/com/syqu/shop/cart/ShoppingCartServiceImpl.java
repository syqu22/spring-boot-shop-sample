package com.syqu.shop.cart;

import com.syqu.shop.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartServiceImpl implements ShoppingCartService{
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
    }

    @Override
    public void saveCart(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addProduct(long id, long productId) {
        findById(id).getProducts().add(productService.findById(productId));

    }

    @Override
    public void removeProduct(long id, long productId) {
        findById(id).getProducts().remove(productService.findById(productId));
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
