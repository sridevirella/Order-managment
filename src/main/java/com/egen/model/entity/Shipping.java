package com.egen.model.entity;

import com.egen.model.enums.ShipmentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_shipping_id")
    private String orderShippingId;

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

    @Column(name = "order_shipping_zip")
    private int orderShippingZip;

    @OneToOne
    private Order order;

    public Shipping() {
        this.orderShippingId = UUID.randomUUID().toString();
    }
}