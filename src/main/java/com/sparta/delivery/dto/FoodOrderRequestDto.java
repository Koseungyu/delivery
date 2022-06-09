package com.sparta.delivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class FoodOrderRequestDto {
    private Long id; // foodid
    private int quantity;
}
