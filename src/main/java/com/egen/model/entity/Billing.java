package com.egen.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "billing_id")
    private String billingId;

    @Column(name = "order_billing_addressline1")
    private String order_billing_addressline1;

    @Column(name = "order_billing_addressline2")
    private String order_billing_addressline2;

    @Column(name = "order_billing_city")
    private String orderBillingCity;

    @Column(name = "order_billing_state")
    private String orderBillingState;

    @Column(name = "order_billing_zip")
    private int orderBillingZip;

    @OneToOne
    private Payment payment;

    public Billing() {}
}
