package com.example.orderservice.model;

import lombok.Data;

/**
 * @author hpl
 * @date 2022/9/11 17:08
 */
@Data
public class ProductOrder {
    private Long id;
    private String name;
    private Long userId;

}
