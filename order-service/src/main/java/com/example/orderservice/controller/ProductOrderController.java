package com.example.orderservice.controller;

import com.example.commonservice.model.Result;
import com.example.commonservice.util.ResultUtil;
import com.example.orderservice.dao.productorder.po.ProductOrderPO;
import com.example.orderservice.model.ProductOrder;
import com.example.orderservice.service.ProductOrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hpl
 */
@RestController
@RequestMapping("/order/")
public class ProductOrderController {

    @Resource
    private ProductOrderService ProductOrderService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result<ProductOrder> create(@RequestBody ProductOrder ProductOrder) {
        ProductOrderService.createProductOrder(ProductOrder);
        return ResultUtil.buildResult(ProductOrder);
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public Result<List<ProductOrderPO>> query(ProductOrder ProductOrder) {
        List<ProductOrderPO> userPOS = ProductOrderService.queryProductOrder(ProductOrder);
        return ResultUtil.buildResult(userPOS);
    }
}
