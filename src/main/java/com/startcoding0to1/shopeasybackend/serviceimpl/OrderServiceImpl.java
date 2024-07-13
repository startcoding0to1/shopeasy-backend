package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.OrderDTO;
import com.startcoding0to1.shopeasybackend.entity.CustomerOrder;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.startcoding0to1.shopeasybackend.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper MODELMAPPER;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Integer customerId) throws ShopEasyException {
        Iterable<CustomerOrder> customerOrders = orderRepository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        customerOrders.forEach(order -> {
            OrderDTO orderDTO = MODELMAPPER.map(order, OrderDTO.class);
            orderDTOS.add(orderDTO);
        });
        if(orderDTOS == null || orderDTOS.isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_CUSTOMER_DETAILS_ID+customerId, HttpStatus.NOT_FOUND);
        }
        return orderDTOS;
    }

    @Override
    public String placeOrder(OrderDTO orderDTO) {
        CustomerOrder order = MODELMAPPER.map(orderDTO, CustomerOrder.class);
        order.setOrderStatus(ShopEasyConstants.ORDER_STATUS_ORDERED);
        if(orderDTO.getPaymentStatus().equals(null)){
            order.setPaymentStatus(ShopEasyConstants.PAYMENT_STATUS_NOT_YET_INITIATED);
        }
        order.setDeliveryStatus(ShopEasyConstants.Delivery_STATUS_In_PROGRESS);
        return ShopEasyConstants.ORDER_SUCCESSFULLY_PLACED+orderRepository.save(order).getCustomerId()+".";

    }

    @Override
    public String updateAfterOrderReceived(Integer orderId) {

        return null;
    }

//    @Scheduled(fixedRate = 1000*60*60*24) // Execute every 5 seconds
    @Override
    public void deliveryNotificationTrigger() {
        System.out.println("=================Scheduled Task=====================");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("amaanbaig650@gmail.com");
        simpleMailMessage.setSubject("Just for Checking");
        simpleMailMessage.setText(""" 
                Hi Dear,
                Hope your doing well!
                Thanks for using our app.
                startCoding0to1.
                """); //text blocks
        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public String cancelOrder(Integer orderId, String orderStatus) throws ShopEasyException {
        Optional<CustomerOrder> optional = orderRepository.findById(orderId);
        CustomerOrder order = optional.orElseThrow(()-> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_ORDER_ID+orderId,HttpStatus.NOT_FOUND));
        order.setOrderStatus(ShopEasyConstants.ORDER_STATUS_CANCELLED);
        order.setDeliveryStatus(ShopEasyConstants.Delivery_STATUS_CANCELLED);
        order.setPaymentStatus(ShopEasyConstants.PAYMENT_STATUS_Failure);
        return ShopEasyConstants.ORDER_SUCCESSFULLY_CANCELLED+orderRepository.save(order).getOrderId()+".";
    }
}
