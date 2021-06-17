package com.egen.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private String order_item_id;

    @Column(name = "order_item_name")
    private String orderItemName;

    @Column(name = "order_item_qty")
    private String orderItemQuantity;

    @Column(name = "order_item_unit_price")
    private Double orderItemUnitPrice;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    public Item() {}
}
