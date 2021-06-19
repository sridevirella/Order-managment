package com.egen.dto;

import com.egen.model.entity.Item;
import com.egen.model.entity.Payment;
import com.egen.model.entity.Shipping;
import com.egen.model.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private String orderId;
    private Timestamp orderCreationDate;
    private Timestamp orderModificationDate;
    private String orderCustomerId;
    private BigDecimal orderTotal;
    private BigDecimal orderSubtotal;
    private BigDecimal orderTax;
    private OrderStatus orderStatus;
    private List<Item> itemList = new ArrayList<>();
    private List<Payment> paymentList = new ArrayList<>();
    private Shipping shipping;
}
