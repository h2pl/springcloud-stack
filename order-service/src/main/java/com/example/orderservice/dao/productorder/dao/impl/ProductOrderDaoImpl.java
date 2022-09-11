package com.example.orderservice.dao.productorder.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.orderservice.dao.productorder.dao.ProductOrderDao;
import com.example.orderservice.dao.productorder.mapper.ProductOrderMapper;
import com.example.orderservice.dao.productorder.po.ProductOrderPO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hpl
 * @since 2022-09-11
 */
@Service
public class ProductOrderDaoImpl extends ServiceImpl<ProductOrderMapper, ProductOrderPO> implements ProductOrderDao {

}
