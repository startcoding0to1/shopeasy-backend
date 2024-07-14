package com.startcoding0to1.shopeasybackend.dto;

import java.util.Objects;

public class OrderDTO {
    private Integer orderId;
    private Integer customerId;
    private String productId;
    private Integer sellerId;
    private Double pricePerProduct;
    private Integer quantity;
    private Double totalPrice;
    private String orderStatus; //ordered / cancel
    private String deliverStatus; //In progress / delivered
    private String deliverDate;
    private String paymentStatus; // Not yet initiated / success / failure / rollback
    private String orderPlacedTime;
    private String lastUpdate;
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

    public String getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(String deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderPlacedTime() {
        return orderPlacedTime;
    }

    public void setOrderPlacedTime(String orderPlacedTime) {
        this.orderPlacedTime = orderPlacedTime;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

	@Override
	public int hashCode() {
		return Objects.hash(customerId, deliverDate, deliverStatus, feedBack, lastUpdate, orderId, orderPlacedTime,
				orderStatus, paymentStatus, pricePerProduct, productId, quantity, sellerId, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(deliverDate, other.deliverDate)
				&& Objects.equals(deliverStatus, other.deliverStatus) && Objects.equals(feedBack, other.feedBack)
				&& Objects.equals(lastUpdate, other.lastUpdate) && Objects.equals(orderId, other.orderId)
				&& Objects.equals(orderPlacedTime, other.orderPlacedTime)
				&& Objects.equals(orderStatus, other.orderStatus) && Objects.equals(paymentStatus, other.paymentStatus)
				&& Objects.equals(pricePerProduct, other.pricePerProduct) && Objects.equals(productId, other.productId)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(sellerId, other.sellerId)
				&& Objects.equals(totalPrice, other.totalPrice);
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId
				+ ", sellerId=" + sellerId + ", pricePerProduct=" + pricePerProduct + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", deliverStatus=" + deliverStatus
				+ ", deliverDate=" + deliverDate + ", paymentStatus=" + paymentStatus + ", orderPlacedTime="
				+ orderPlacedTime + ", lastUpdate=" + lastUpdate + ", feedBack=" + feedBack + "]";
	}
    
}
