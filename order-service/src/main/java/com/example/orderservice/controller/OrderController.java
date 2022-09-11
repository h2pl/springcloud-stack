package com.example.orderservice.controller;

import com.example.commonservice.model.Result;
import com.example.orderservice.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hpl
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @RequestMapping("create")
    public Result<Order> create() {

        return new Result<>();
    }
}
