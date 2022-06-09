package com.sparta.delivery.dto;

import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodDto {
    private Long restaurantId;
    private String name;
    private int price;


    //FoodDto에 builder가 있는게 맞나?
    //restaurant 이거 왜 .getId()붙이면 왜 빨간 밑줄? 이해가 잘 안된다. 이러면 레스토랑의 모든걸 가지고 오는건데?
    public Food permit(Restaurant restaurant){
        return Food.builder()
                .restaurant(restaurant)
                .name(this.name)
                .price(this.price)
                .build();
    }
}
