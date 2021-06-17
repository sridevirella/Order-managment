package com.egen.mapper;

import com.egen.dto.OrderDTO;
import com.egen.model.entity.Order;

public class OrderMapper {

    public Order convertToOrderEntity(OrderDTO orderDTO) {

        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setOrderCreationDate(orderDTO.getOrderCreationDate());
        order.setOrderModificationDate(orderDTO.getOrderModificationDate());
        order.setOrderCustomerId(orderDTO.getOrderCustomerId());
        order.setOrderTotal(orderDTO.getOrderTotal());
        order.setOrderSubtotal(orderDTO.getOrderSubtotal());
        order.setOrderTax(orderDTO.getOrderTax());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setItemList(orderDTO.getItemList());
        order.setPaymentList(orderDTO.getPaymentList());
        order.setShipping(orderDTO.getShipping());
        return order;
    }

    public OrderDTO convertToOrderDTO(Order order) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setOrderCreationDate(order.getOrderCreationDate());
        orderDTO.setOrderModificationDate(order.getOrderModificationDate());
        orderDTO.setOrderCustomerId(order.getOrderCustomerId());
        orderDTO.setOrderTotal(order.getOrderTotal());
        orderDTO.setOrderSubtotal(order.getOrderSubtotal());
        orderDTO.setOrderTax(order.getOrderTax());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setItemList(order.getItemList());
        orderDTO.setPaymentList(order.getPaymentList());
        orderDTO.setShipping(order.getShipping());
        return orderDTO;
    }
}
