package com.sparta.delivery.repository;

import com.sparta.delivery.model.FoodOrdersInfo;
import com.sparta.delivery.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodOrderInfoRepository extends JpaRepository<FoodOrdersInfo, Long> {

    List<FoodOrdersInfo> findAllByOrder(Orders order);
}
