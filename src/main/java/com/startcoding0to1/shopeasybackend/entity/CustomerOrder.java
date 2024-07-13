package com.startcoding0to1.shopeasybackend.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="order_id_gen")
    @SequenceGenerator(name = "order_id_gen",sequenceName = "order_id_sequence",allocationSize = 1)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name="customer_id")
    private Integer customerId;
    @Column(name="product_id")
    private String productId;
    @Column(name="seller_id")
    private Integer sellerId;
    @Column(name = "price_per_product")
    private Double pricePerProduct;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name="total_price")
    private Double totalPrice;
    @Column(name="order_status")
    private String orderStatus; //ordered / cancel
    @Column(name = "delivery_status")
    private String deliveryStatus; //In progress / delivered
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;
    @Column(name = "payment_status")
    private String paymentStatus; //Not yet initiated / success / failure
    @CreationTimestamp
    @Column(name = "order_placed_time")
    private LocalDateTime orderPlacedTime;
    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Column(name = "feed_back")
    private String feedBack;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Double getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(Double pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getOrderPlacedTime() {
        return orderPlacedTime;
    }

    public void setOrderPlacedTime(LocalDateTime orderPlacedTime) {
        this.orderPlacedTime = orderPlacedTime;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }
}
