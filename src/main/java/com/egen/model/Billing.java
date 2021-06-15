package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Billing {

    @Id
    @Column(name = "billing_id")
    private String billingId;

    @Column(name = "payment_id")
    private String paymentId;

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

    public Billing() {
        this.billingId = UUID.randomUUID().toString();
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrder_billing_addressline1() {
        return order_billing_addressline1;
    }

    public void setOrder_billing_addressline1(String order_billing_addressline1) {
        this.order_billing_addressline1 = order_billing_addressline1;
    }

    public String getOrder_billing_addressline2() {
        return order_billing_addressline2;
    }

    public void setOrder_billing_addressline2(String order_billing_addressline2) {
        this.order_billing_addressline2 = order_billing_addressline2;
    }

    public String getOrderBillingCity() {
        return orderBillingCity;
    }

    public void setOrderBillingCity(String orderBillingCity) {
        this.orderBillingCity = orderBillingCity;
    }

    public String getOrderBillingState() {
        return orderBillingState;
    }

    public void setOrderBillingState(String orderBillingState) {
        this.orderBillingState = orderBillingState;
    }

    public int getOrderBillingZip() {
        return orderBillingZip;
    }

    public void setOrderBillingZip(int orderBillingZip) {
        this.orderBillingZip = orderBillingZip;
    }
}
