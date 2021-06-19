package com.egen.controller;

import com.egen.dto.OrderDTO;
import com.egen.mapper.OrderMapper;
import com.egen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {

        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<OrderDTO>> getOrderById(@PathVariable("id") String orderId) {

        return new ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @GetMapping(value = "/between", params = {"startTime", "endTime"})
    public ResponseEntity<List<OrderDTO>> getAllOrdersWithInInterval(@RequestParam("startTime") ZonedDateTime startTime,
                                                                     @RequestParam("endTime") ZonedDateTime endTime) {

        return new ResponseEntity<>(orderService.getAllOrdersWithInInterval(startTime, endTime), HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.GET, value = "/search", params = {"zip"})
    public ResponseEntity<List<OrderDTO>> top10OrdersWithHighestDollarAmountInZip(@RequestParam("zip") String zip) {

        return new ResponseEntity<>(orderService.top10OrdersWithHighestDollarAmountInZip(zip), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO order) {
        return new ResponseEntity<>(orderService.placeOrder(order), HttpStatus.CREATED);
    }

    @PostMapping(path = "/cancel/{id}")
    public ResponseEntity<OrderDTO> cancelOrder(@PathVariable("id") String orderId) {
        return new ResponseEntity<>(orderService.cancelOrder(orderId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrderDTO> updateOrder(@RequestBody OrderDTO order) {
        return new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.OK);
    }
}
