package com.sparta.delivery.service;

import com.sparta.delivery.dto.FoodDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FoodService  {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    //음식 등록
    @Transactional
    public void registerFood(Long restaurantId, List<FoodDto> foodDtoList){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("음식점 id가 존재하지 않음")
        );
        foodDtoList.stream().forEach(foodDto -> {

            if(foodDto.getPrice() < 100 || foodDto.getPrice() > 1000000 ){
                throw new IllegalArgumentException("음식 가격 범위가 아닙니다(가격 범위 : 100원 ~ 1,000,000원 입니다.)");
            }

            if(foodDto.getPrice() % 100 != 0){
                throw new IllegalArgumentException("100원 단위 입력이 필요합니다.");
            }

            Optional<Food> food = foodRepository.findFoodByRestaurantAndName(restaurant, foodDto.getName());
            if(food.isPresent()){
                throw new IllegalArgumentException("같은 음식점 내에서는 음식 이름이 중복될 수 없습니다.");
            }

            foodDto.setRestaurantId(restaurantId);
            foodRepository.save(foodDto.permit(restaurant));
        });
    }

    // jpa구문 2개이상 (논리 연산과정 2개이상은 @Transactional 을 해줘라 - 걍 1개 있어도 @Transactional 붙이자
    // 똑같은 id면 캐쉬에 담아져 있는거 그대로 가져와서 db에 안넣어진다. 그러므로 @Transactional이 필요하다.
    // 메뉴판 조회
    @Transactional
    public List<Food> getRestaurantFoodList(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("해당 음식점 id가 존재하지 않습니다.")
        );

        return foodRepository.findAllByRestaurantId(restaurant.getId());
    }

}

