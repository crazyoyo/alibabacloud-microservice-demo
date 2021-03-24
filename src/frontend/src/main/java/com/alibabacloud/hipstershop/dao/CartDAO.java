package com.alibabacloud.hipstershop.dao;

import com.alibabacloud.hipstershop.cartserviceapi.domain.CartItem;
import com.alibabacloud.hipstershop.cartserviceapi.service.CartService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangtao 2019-08-14 17:11
 */
@Service
public class CartDAO {

    @Reference(version = "1.0.0", check = false)
    private CartService cartService;

    public List<CartItem> viewCart(String userID) {
        return cartService.viewCart(userID);
    }

    public boolean addToCart(String userID, String productID, int quantity) {
        return cartService.addItemToCart(userID, productID, quantity);
    }

    public String setExceptionByIp(String ip) {
        return cartService.setExceptionByIp(ip);
    }

    public String getRemoteIp(String name, int age) {
        return cartService.getProviderIp(name, age);
    }
}
