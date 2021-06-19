package com.egen.model.entity;

import com.egen.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_payment_id")
    private String orderPaymentId;

    @Column(name = "order_payment_confirmation_number")
    private String orderPaymentConfirmationNumber;

    @Column(name = "order_payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "order_payment_amount")
    private BigDecimal orderPaymentAmount;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_id", referencedColumnName = "billing_id")
    private Billing billing;

    public Payment() {}
}
