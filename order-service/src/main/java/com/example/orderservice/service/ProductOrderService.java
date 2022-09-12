package com.example.orderservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.feignapi.pojo.User;
import com.example.orderservice.dao.productorder.dao.ProductOrderDao;
import com.example.orderservice.dao.productorder.po.ProductOrderPO;
import com.example.orderservice.service.model.ProductOrder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hpl
 * @date 2022/9/11 17:40
 */
@Service
public class ProductOrderService {

    @Resource
    private ProductOrderDao productOrderDao;

    public ProductOrder createProductOrder(ProductOrder ProductOrder) {
        ProductOrderPO productOrderPO = convert2PO(ProductOrder);
        productOrderDao.save(productOrderPO);
        return ProductOrder;
    }

    public List<ProductOrderPO> queryProductOrder(ProductOrder ProductOrder) {
        QueryWrapper<ProductOrderPO> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(ProductOrder.getId())) {
            queryWrapper.eq("id", ProductOrder.getId());
        }
        if (!StringUtils.isEmpty(ProductOrder.getName())) {
            queryWrapper.eq("name", ProductOrder.getName());
        }
        if (!StringUtils.isEmpty(ProductOrder.getUserId())) {
            queryWrapper.eq("user_id", ProductOrder.getUserId());
        }
        List<ProductOrderPO> productOrderPOS = productOrderDao.list(queryWrapper);
        return productOrderPOS;
    }

    public List<ProductOrderPO> queryProductOrderByUser(User user) {
        QueryWrapper<ProductOrderPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user);
        List<ProductOrderPO> productOrderPOS = productOrderDao.list(queryWrapper);
        return productOrderPOS;
    }

    ProductOrderPO convert2PO(ProductOrder ProductOrder) {
        ProductOrderPO productOrderPO = new ProductOrderPO();
        productOrderPO.setId(ProductOrder.getId());
        productOrderPO.setName(ProductOrder.getName());
        productOrderPO.setUserId(ProductOrder.getUserId());
        return productOrderPO;

    }


    public List<ProductOrderPO> queryByIds(List<Long> ids) {
        QueryWrapper<ProductOrderPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("user_id", ids);
        List<ProductOrderPO> productOrderPOS = productOrderDao.list(queryWrapper);

        return productOrderPOS;
    }
}
