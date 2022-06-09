package com.sparta.delivery.dto;

import com.sparta.delivery.model.Orders;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResDto {
    private String restaurantName;
    private List<FoodOrderResDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderResDto(Orders order, List<FoodOrderResDto> foods){
        this.restaurantName = order.getRestaurant().getName();
        this.foods = foods;
        this.deliveryFee = order.getRestaurant().getDeliveryFee();
        this.totalPrice = order.getTotalPrice();
    }
}
