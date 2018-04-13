package com.syqu.shop.product;

public interface ProductService {
    void save(Product product);
    void edit(Product product, Product newProduct);
    void delete(long productId);
    Product findById(long id);
    Product findByName(String name);
}
