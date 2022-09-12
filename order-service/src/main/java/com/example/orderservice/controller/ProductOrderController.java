package com.example.orderservice.controller;

import com.example.commonservice.model.Result;
import com.example.commonservice.util.ResultUtil;
import com.example.feignapi.client.UserClient;
import com.example.feignapi.pojo.User;
import com.example.orderservice.dao.productorder.po.ProductOrderPO;
import com.example.orderservice.service.ProductOrderService;
import com.example.orderservice.service.model.ProductOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hpl
 */
@RestController
@RequestMapping("/order/")
@Slf4j
public class ProductOrderController {

    @Resource
    private ProductOrderService productOrderService;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserClient userClient;

    @PostMapping("create")
    public Result<ProductOrder> create(@RequestBody ProductOrder ProductOrder) {
        productOrderService.createProductOrder(ProductOrder);
        return ResultUtil.buildResult(ProductOrder);
    }

    @GetMapping("query")
    public Result<List<ProductOrderPO>> query(ProductOrder ProductOrder) {
        List<ProductOrderPO> userPOS = productOrderService.queryProductOrder(ProductOrder);
        return ResultUtil.buildResult(userPOS);
    }

    @GetMapping("queryUser")
    public Result<List<User>> queryUser(User user) {
        Result<List<User>> result = userClient.query(user.getId(), user.getName());
        return result;
    }


    @GetMapping("queryByUser")
    public Result<List<ProductOrderPO>> query(User user) {

        Result<List<User>> result = restTemplate.getForObject("http://user-service/user/query", Result.class);
        if (result == null) {
            throw new RuntimeException();
        }

        if (result.getSuccess()) {
            List<User> list = result.getData();
            if (list != null) {
                List<Long> ids = list.stream().map(User::getId).collect(Collectors.toList());
                List<ProductOrderPO> productOrderPOS = productOrderService.queryByIds(ids);
                return ResultUtil.buildResult(productOrderPOS);
            } else {
                return ResultUtil.buildResult(new ArrayList<>());
            }
        } else {
            return ResultUtil.buildFailResult();
        }


    }
}
