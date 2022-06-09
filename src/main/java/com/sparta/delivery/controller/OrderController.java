package com.sparta.delivery.controller;

import com.sparta.delivery.dto.OrderRequestDTo;
import com.sparta.delivery.dto.OrderResDto;
import com.sparta.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    //주문 등록
    @PostMapping("/order/request")
    public OrderResDto registerOrders(@RequestBody OrderRequestDTo orderRequestDto){
        return orderService.registerOrders(orderRequestDto);
    }

    //주문 조회
    @GetMapping("/orders")
    public List<OrderResDto> getOrderList(){
        return orderService.getOrderList();
    }
}
