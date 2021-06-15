package com.egen.model;

import com.egen.model.enums.PaymentMethod;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Payment {

    @Id
    @Column(name = "order_payment_id")
    private String orderPaymentId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_payment_confirmation_number")
    private String orderPaymentConfirmationNumber;

    @Column(name = "order_payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "order_payment_amount" )
    private BigDecimal orderPaymentAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private Billing billing;

    public Payment() {
        this.orderPaymentId = UUID.randomUUID().toString();
    }

    public String getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(String orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderPaymentConfirmationNumber() {
        return orderPaymentConfirmationNumber;
    }

    public void setOrderPaymentConfirmationNumber(String orderPaymentConfirmationNumber) {
        this.orderPaymentConfirmationNumber = orderPaymentConfirmationNumber;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getOrderPaymentAmount() {
        return orderPaymentAmount;
    }

    public void setOrderPaymentAmount(BigDecimal orderPaymentAmount) {
        this.orderPaymentAmount = orderPaymentAmount;
    }
}
