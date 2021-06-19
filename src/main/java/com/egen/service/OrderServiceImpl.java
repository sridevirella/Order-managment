package com.egen.service;

import com.egen.dto.OrderDTO;
import com.egen.exception.BadRequestException;
import com.egen.exception.InternalServerException;
import com.egen.exception.OrderServiceException;
import com.egen.mapper.OrderMapper;
import com.egen.model.entity.Order;
import com.egen.model.enums.OrderStatus;
import com.egen.repository.OrderRepository;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
   public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> getAllOrders() {

        try {
            return convertToDTOList(orderRepository.findAll());

           } catch (InternalServerException ise) {

            System.out.println("Failed while fetching all orders");
            throw new InternalServerException("Internal Server Error occured");
        }
    }

    @Override
    public List<OrderDTO> getOrderById(String id) {

        try {
            Order order = orderRepository.findById(id);
            if(order == null)
                throw new BadRequestException(id + "Order you're looking for couldn't be found");
            return Collections.singletonList(new OrderMapper().convertToOrderDTO(order));

        } catch (InternalServerException ise) {
            System.out.println("Failed while fetching specific order");
            throw new InternalServerException("Internal Server Error occured");
        }
    }

    @Override
    public List<OrderDTO> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime) {

        try {
            return convertToDTOList(orderRepository.findAllOrdersWithInInterval(Timestamp.from(Instant.from(startTime)),  Timestamp.from(Instant.from(endTime))));

        } catch (InternalServerException ise) {
            System.out.println("Failed while fetching all orders within the given interval");
            throw new InternalServerException("Internal Server Error occured");
        }
    }

    @Override
    public List<OrderDTO> top10OrdersWithHighestDollarAmountInZip(String zip) {

        try {
            List<OrderDTO> orders = convertToDTOList(orderRepository.OrdersWithHighestDollarAmountInZip(zip));

            if(orders.size() == 0)
                throw new OrderServiceException("No orders have been placed yet at a given location.");
            return orders;
        }
        catch (InternalServerException ise) {
            System.out.println("Failed while fetching top 10 orders in a given location");
            throw new InternalServerException("Internal Server Error occured");
        }
    }

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {

        try {
            Order order = new OrderMapper().convertToOrderEntity(orderDTO);
            orderRepository.create(order);
            return new OrderMapper().convertToOrderDTO(order);

        } catch (OrderServiceException ose) {
            System.out.println("Failed while order creation");
            throw new OrderServiceException("Failed while order creation");
        }
    }

    @Override
    public OrderDTO cancelOrder(String orderId) {

        try {
            Order order = orderRepository.findById(orderId);
            order.setOrderStatus(OrderStatus.CANCELLED);
            orderRepository.update(order);
            return new OrderMapper().convertToOrderDTO(order);

        } catch (OrderServiceException ose) {
            System.out.println("Failed while order cancellation");
            throw new OrderServiceException("Failed while order cancellation");
        }
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {

        try {
            Order order = new OrderMapper().convertToOrderEntity(orderDTO);
            //check if order is already dispatched
            Order _order = orderRepository.findById(order.getOrderId());

            if(_order == null)
                throw new OrderServiceException("Order doesn't exist");

            else if(_order.getOrderStatus().equals(OrderStatus.SHIPPED))
                throw new OrderServiceException("Order has been already shipped");
            else
                return new OrderMapper().convertToOrderDTO(orderRepository.update(order));

        } catch (OrderServiceException ose) {
            System.out.println("Failed while order modification");
            throw new OrderServiceException("Failed while order modification");
        }
    }

    private List<OrderDTO> convertToDTOList(List<Order> orders) {

        return orders.stream()
                .map(order -> new OrderMapper().convertToOrderDTO(order))
                .collect(Collectors.toList());
    }
}