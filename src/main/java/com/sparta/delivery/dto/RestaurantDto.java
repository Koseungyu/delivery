package com.sparta.delivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestaurantDto {
    private Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}