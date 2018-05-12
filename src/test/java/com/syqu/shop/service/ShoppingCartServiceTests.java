package com.syqu.shop.service;

import com.syqu.shop.cart.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTests {

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    public void checkIfShoppingCartServiceIsNotNull() {
        initMocks(this);

        assertThat(shoppingCartService).isNotNull();
    }
}
