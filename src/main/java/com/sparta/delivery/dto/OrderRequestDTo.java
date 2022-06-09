package com.sparta.delivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderRequestDTo {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;
}
