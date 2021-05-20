package com.syqu.shop.service;

import com.syqu.shop.creator.ProductCreator;
import com.syqu.shop.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

    @MockBean
    private ProductService productService;

    @Test
    public void checkIfProductServiceIsNotNull(){
        initMocks(this);

        assertThat(productService).isNotNull();
    }
    @Test
    public void saveProductTests(){
        Product product = ProductCreator.createTestProduct();
        productService.save(product);
        when(productService.findById(product.getId())).thenReturn(product);
        Product found = productService.findById(product.getId());

        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(product.getName());
        assertThat(found.getDescription()).isEqualTo(product.getDescription());
        assertThat(found.getPrice()).isEqualTo(product.getPrice());
        assertThat(found.getImageUrl()).isEqualTo(product.getImageUrl());
    }

    @Test
    public void editProductsTests(){
        Product product = ProductCreator.createTestProduct();
        Product newProduct = ProductCreator.createTestProduct();
        newProduct.setName("Hello");
        newProduct.setPrice(BigDecimal.valueOf(50));
        newProduct.setDescription("Hello Description :)");

        productService.save(product);
        productService.edit(product.getId(), newProduct);

        when(productService.findById(product.getId())).thenReturn(newProduct);
        Product found = productService.findById(newProduct.getId());

        assertThat(found).isNotNull();
        assertThat(found.getPrice()).isEqualTo(BigDecimal.valueOf(50));
        assertThat(found.getName()).isEqualTo("Hello");
        assertThat(found.getDescription()).isEqualTo("Hello Description :)");
    }

    @Test
    public void deleteProductsTests(){
        Product product = ProductCreator.createTestProduct();
        productService.save(product);
        productService.delete(product.getId());

        Product found = productService.findById(product.getId());

        assertThat(found).isNull();
    }

    @Test
    public void whenFindByIdThenReturnProduct(){
        when(productService.findById(100L)).thenReturn(ProductCreator.createTestProduct());
        Product found = productService.findById(100L);

        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(ProductCreator.NAME);
        assertThat(found.getDescription()).isEqualTo(ProductCreator.DESCRIPTION);
        assertThat(found.getPrice()).isEqualTo(ProductCreator.PRICE);
        assertThat(found.getImageUrl()).isEqualTo(ProductCreator.IMAGE_URL);
    }

    @Test
    public void whenFindAllByOrderByIdAscThenReturnAllProducts(){
        ArrayList<Product> products = new ArrayList<>(ProductCreator.createTestProducts());
        when(productService.findAllByOrderByIdAsc()).thenReturn(products);
        List<Product> found = productService.findAllByOrderByIdAsc();

        assertThat(found).isNotNull();
        for (Product product : found){
            assertThat(product.getName()).isEqualTo(ProductCreator.NAME);
            assertThat(product.getDescription()).isEqualTo(ProductCreator.DESCRIPTION);
            assertThat(product.getPrice()).isEqualTo(ProductCreator.PRICE);
            assertThat(product.getImageUrl()).isEqualTo(ProductCreator.IMAGE_URL);
        }
    }

    @Test
    public void whenCountThenReturnProductsCount(){
        when(productService.count()).thenReturn(3L);
        long count = productService.count();

        assertThat(count).isNotNegative();
        assertThat(count).isEqualTo(3L);

    }

    @Test
    public void whenFindByIdAndNoProductThenReturnNull(){
        Product found = productService.findById(50L);

        assertThat(found).isNull();
    }
}
