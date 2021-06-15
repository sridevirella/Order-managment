package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class OrderItem {

    @Id
    @Column(name = "order_item_id")
    private String order_item_id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_item_name")
    private String orderItemName;

    @Column(name = "order_item_qty")
    private String orderItemQuantity;

    @Column(name = "order_item_unit_price")
    private Double orderItemUnitPrice;

    public OrderItem() {
        this.order_item_id = UUID.randomUUID().toString();
    }

    public String getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(String order_item_id) {
        this.order_item_id = order_item_id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItemName() {
        return orderItemName;
    }

    public void setOrderItemName(String orderItemName) {
        this.orderItemName = orderItemName;
    }

    public String getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(String orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public Double getOrderItemUnitPrice() {
        return orderItemUnitPrice;
    }

    public void setOrderItemUnitPrice(Double orderItemUnitPrice) {
        this.orderItemUnitPrice = orderItemUnitPrice;
    }
}
