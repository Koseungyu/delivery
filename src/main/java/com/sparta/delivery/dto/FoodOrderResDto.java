package com.sparta.delivery.dto;

import com.sparta.delivery.model.FoodOrdersInfo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodOrderResDto {
    String name;
    int quantity;
    int price;


    public FoodOrderResDto(FoodOrdersInfo foodOrderInfo){
        this.name = foodOrderInfo.getFood().getName();
        this.quantity = foodOrderInfo.getQuantity();
        this.price = foodOrderInfo.getPrice();
    }

}
