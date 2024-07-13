package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.dto.OrderDTO;
import com.startcoding0to1.shopeasybackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order/{customerId}")
    public ResponseEntity<String> getOrdersByCustomerId(@PathVariable(name = "customerId") Integer customerId){
        orderService.deliveryNotificationTrigger();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping(value = "/order")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDTO){

        return null;
    }

    @PutMapping(value = "/order/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable(name = "orderId") Integer orderId,@RequestBody OrderDTO orderDTO){

        return null;
    }

    @DeleteMapping(value = "/order/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name = "orderId") Integer orderId){

        return null;
    }
}
