package com.training.innova.order.restaurant.integrations.models;

import java.util.List;

public class Menu {
    private String menuId;
    private List<String> meals;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public List<String> getMeals() {
        return meals;
    }

    public void setMeals(List<String> meals) {
        this.meals = meals;
    }
}
