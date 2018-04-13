package com.syqu.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(Product product, Product newProduct) {
        //TODO change it
        productRepository.delete(product);
        productRepository.save(newProduct);
    }

    @Override
    public void delete(long productId) {
        productRepository.delete(findById(productId));
    }

    //TODO add exception handling
    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
