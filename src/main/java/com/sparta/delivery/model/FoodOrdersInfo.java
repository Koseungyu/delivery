package com.sparta.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
public class FoodOrdersInfo {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;  // food의 price * quantity

    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

}

