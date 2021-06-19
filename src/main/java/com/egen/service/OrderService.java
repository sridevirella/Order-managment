package com.egen.service;

import com.egen.dto.OrderDTO;
import com.egen.model.entity.Order;

import java.time.ZonedDateTime;
import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();
    List<OrderDTO> getOrderById(String id);
    List<OrderDTO> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime);
    List<OrderDTO> top10OrdersWithHighestDollarAmountInZip(String zip);
    OrderDTO placeOrder(OrderDTO order);
    OrderDTO cancelOrder(String orderId);
    OrderDTO updateOrder(OrderDTO order);
}
