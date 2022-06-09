package com.sparta.delivery.controller;

import com.sparta.delivery.dto.RestaurantDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


//@RequiredArgsConstructor : 의존성주입! 초기화 되지 않은 'final', '@notnull'이 붙은 필드에 대해 생성자를 생성해준다.
//@RestController : 제이슨 형식으로 받아오고 준다.
@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;


    //가게 등록
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.registerRestaurant(restaurantDto);
    }

    //가게 리스트 조회
    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurantList() { return restaurantService.getRestaurantList(); }
}
