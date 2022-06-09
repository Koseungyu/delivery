package com.sparta.delivery.repository;

import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {

    //findFoodByRestaurantAndName : 이름을 변경이 필요한가?
    Optional<Food> findFoodByRestaurantAndName(Restaurant restaurant, String foodName);

    //findAllByRestaurantId : 레스토랑 id 빼와서 써야한다.
    List<Food> findAllByRestaurantId(Long restaurantId);
}
