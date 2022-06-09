package com.sparta.delivery.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Orders {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // nullable: null 허용 여부, default가 true
    // unique: 중복 허용 여부 (false 일때 중복 허용), default가 false
    //@Column(nullable = false, unique = true)

    @Column(nullable = false)
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Orders(Restaurant restaurant, int totalPrice){
        this.restaurant = restaurant;
        this.totalPrice = totalPrice;
    }
}


