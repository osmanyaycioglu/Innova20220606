package com.training.innova.order.restaurant.integrations.feign;

import com.training.innova.order.restaurant.integrations.models.Menu;
import com.training.innova.order.restaurant.integrations.models.PriceInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("RESTAURANT-APIGW")
//@RequestMapping("/api/v1/restaurant/menu")
public interface IRestaurantIntegration {
    @PostMapping("/api/v1/restaurant/menu/price")
    PriceInfo getPrice(@RequestBody Menu menu);

    @GetMapping("/api/v1/restaurant/menu/get/list/{menuname}")
    public String getMenu(@PathVariable("menuname") String menuName);
}
