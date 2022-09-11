package com.example.orderservice.controller;

import com.example.commonservice.model.Result;
import com.example.commonservice.util.ResultUtil;
import com.example.orderservice.dao.productorder.po.ProductOrderPO;
import com.example.orderservice.model.ProductOrder;
import com.example.orderservice.service.ProductOrderService;
import com.example.userservice.dao.user.po.UserPO;
import com.example.userservice.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
public class ProductOrderController {

    @Resource
    private ProductOrderService productOrderService;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result<ProductOrder> create(@RequestBody ProductOrder ProductOrder) {
        productOrderService.createProductOrder(ProductOrder);
        return ResultUtil.buildResult(ProductOrder);
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public Result<List<ProductOrderPO>> query(ProductOrder ProductOrder) {
        List<ProductOrderPO> userPOS = productOrderService.queryProductOrder(ProductOrder);
        return ResultUtil.buildResult(userPOS);
    }

    @RequestMapping(value = "queryByUser", method = RequestMethod.GET)
    public Result<List<ProductOrderPO>> query(User user) {

        Result<List<UserPO>> result = restTemplate.getForObject("http://user-service/user/query", Result.class);
        if (result == null) {
            throw new RuntimeException();
        }

        if (result.getSuccess()) {
            List<UserPO> list = result.getData();
            if (list != null) {
                List<Long> ids = list.stream().map(UserPO::getId).collect(Collectors.toList());
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
