package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.dto.CustomerOrderDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface OrderService {
    public List<CustomerOrderDTO> getOrdersByCustomerId(Integer customerId) throws ShopEasyException;
    public String placeOrder(CustomerOrderDTO orderDTO);
    public String updateAfterOrderReceived(Integer orderId);

    @Scheduled(fixedRate = 5000) // Execute every 5 seconds
    void deliveryNotificationTrigger();

    String cancelOrder(Integer orderId, String orderStatus) throws ShopEasyException;
}
