package com.handson.orderserviceapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")

public class Order {
    @Id
    private String id;
    private String item;
    private int quantity;
    private double price;

}

