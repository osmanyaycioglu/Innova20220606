package com.training.innova.restaurant.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/restaurant/menu")
public class RestaurantMenuController {

    @Value("${server.port}")
    private int port;
    private int counter = 0;

    @PostMapping("/price")
    public PriceInfo getPrice(@RequestBody Menu menu) {
        counter++;
        if (counter % 3 == 0){
            throw new IllegalArgumentException("test için");
        }
        Random random = new SecureRandom();
        BigDecimal total = BigDecimal.ZERO;
        for (String meal : menu.getMeals()) {
            int nextInt = random.nextInt(100);
            total = total.add(new BigDecimal(nextInt));
        }
        PriceInfo priceInfo = new PriceInfo();
        priceInfo.setMenuId(menu.getMenuId());
        priceInfo.setPrice(total);
        priceInfo.setDesc("Response from : " + port);
        return priceInfo;
    }

    @GetMapping("/get/list/{menuname}")
    public String getMenu(@PathVariable("menuname") String menuName){
        return "Menu " + menuName;
    }

}
