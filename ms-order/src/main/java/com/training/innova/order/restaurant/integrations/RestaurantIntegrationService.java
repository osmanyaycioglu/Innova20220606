package com.training.innova.order.restaurant.integrations;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.innova.order.rest.models.Order;
import com.training.innova.order.rest.models.OrderInfo;
import com.training.innova.order.restaurant.integrations.models.Menu;
import com.training.innova.order.restaurant.integrations.models.PriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantIntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    public PriceInfo getPrice(Order order) {
        Menu menu = new Menu();
        menu.setMenuId(UUID.randomUUID()
                           .toString());
        menu.setMeals(order.getMeals());
        PriceInfo priceInfo = restTemplate.postForObject("http://RESTAURANT/api/v1/restaurant/menu/price",
                                                         menu,
                                                         PriceInfo.class);
        return priceInfo;
    }

    public PriceInfo getPriceEurekaClient(Order order) {
        Application restaurant = eurekaClient.getApplication("RESTAURANT");
        List<InstanceInfo> instances = restaurant.getInstances();

        Menu menu = new Menu();
        menu.setMenuId(UUID.randomUUID()
                           .toString());
        menu.setMeals(order.getMeals());
        RestTemplate rt = new RestTemplate();
        PriceInfo priceInfo = rt.postForObject("http://" + instances.get(0)
                                                                              .getIPAddr() + ":" + instances.get(0)
                                                                                                            .getPort()
                                                                 + "/api/v1/restaurant/menu/price",
                                                         menu,
                                                         PriceInfo.class);
        return priceInfo;
    }

}
