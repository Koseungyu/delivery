package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant registerRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant(restaurantDto);

        if(restaurantDto.getMinOrderPrice() < 1000 || restaurantDto.getMinOrderPrice() > 100000){
            throw new IllegalArgumentException("최소주문 허용가격이 아닙니다.(허용가격은 1,000원 ~ 100,000원)");
        }

        if(restaurantDto.getMinOrderPrice() % 100 != 0){
            throw new IllegalArgumentException("100원 단위 입력값이 아닙니다.");
        }

        if(restaurantDto.getDeliveryFee() <0 || restaurantDto.getDeliveryFee() > 10000){
            throw new IllegalArgumentException("기본배달비 허용 값이 아닙니다.(허용값: 0원 ~ 10,000원)");
        }

        if(restaurantDto.getDeliveryFee() % 500 != 0){
            throw new IllegalArgumentException("500원 단위 입력값이 아닙니다.");
        }

        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public List<Restaurant> getRestaurantList(){
        return restaurantRepository.findAll();
    }
}
