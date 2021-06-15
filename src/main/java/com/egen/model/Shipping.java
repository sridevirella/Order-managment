package com.egen.model;

import com.egen.model.enums.ShipmentType;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Shipping {

    @Id
    @Column(name = "order_shipping_id")
    private String orderShippingId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_shipping_type")
    @Enumerated(EnumType.STRING)
    private ShipmentType shipmentType;

    @Column(name = "order_shipping_addressline1")
    private String orderShippingAddressline1;

    @Column(name = "order_shipping_addressline2")
    private String orderShippingAddressline2;

    @Column(name = "order_shipping_city")
    private String orderShippingCity;

    @Column(name = "order_shipping_state")
    private String orderShippingState;

    @Column(name = "shipping")
    private int orderShippingZip;

    public Shipping() {
        this.orderShippingId = UUID.randomUUID().toString();
    }

    public String getOrderShippingId() {
        return orderShippingId;
    }

    public void setOrderShippingId(String orderShippingId) {
        this.orderShippingId = orderShippingId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(ShipmentType shipmentType) {
        this.shipmentType = shipmentType;
    }

    public String getOrderShippingAddressline1() {
        return orderShippingAddressline1;
    }

    public void setOrderShippingAddressline1(String orderShippingAddressline1) {
        this.orderShippingAddressline1 = orderShippingAddressline1;
    }

    public String getOrderShippingAddressline2() {
        return orderShippingAddressline2;
    }

    public void setOrderShippingAddressline2(String orderShippingAddressline2) {
        this.orderShippingAddressline2 = orderShippingAddressline2;
    }

    public String getOrderShippingCity() {
        return orderShippingCity;
    }

    public void setOrderShippingCity(String orderShippingCity) {
        this.orderShippingCity = orderShippingCity;
    }

    public String getOrderShippingState() {
        return orderShippingState;
    }

    public void setOrderShippingState(String orderShippingState) {
        this.orderShippingState = orderShippingState;
    }

    public int getOrderShippingZip() {
        return orderShippingZip;
    }

    public void setOrderShippingZip(int orderShippingZip) {
        this.orderShippingZip = orderShippingZip;
    }
}
