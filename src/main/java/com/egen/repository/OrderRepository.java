package com.egen.repository;

import com.egen.model.entity.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository {

    List<Order> findAll();
    Order findById(String orderId);
    List<Order> findAllOrdersWithInInterval(Timestamp startTime, Timestamp endTime);
    List<Order> OrdersWithHighestDollarAmountInZip(String zip);
    Order create(Order order);
    Order update(Order order);
}
