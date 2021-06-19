package com.egen.model.entity;

import com.egen.model.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
public class Order {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_creation_date")
    private Timestamp orderCreationDate;

    @Column(name = "order_modification_date")
    private Timestamp orderModificationDate;

    @Column(name = "order_customer_id")
    private String orderCustomerId;

    @Column(name = "order_total")
    private BigDecimal orderTotal;

    @Column(name = "order_subtotal")
    private BigDecimal orderSubtotal;

    @Column(name = "order_tax")
    private BigDecimal orderTax;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    @OneToMany(mappedBy="order")
    private List<Item> itemList = new ArrayList<>();

    @OneToMany(mappedBy="order")
    private List<Payment> paymentList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_shipping_id", referencedColumnName = "order_shipping_id")
    private Shipping shipping;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
    }
}