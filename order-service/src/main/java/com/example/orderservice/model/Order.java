package com.example.orderservice.model;

import lombok.Data;

/**
 * @author hpl
 * @date 2022/9/11 17:08
 */
@Data
public class Order {
    private long id;
    private String name;
    private long userId;

}
