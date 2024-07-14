package com.startcoding0to1.shopeasybackend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cart_id_seq")
    @SequenceGenerator(name = "cart_id_seq" ,sequenceName = "cart_sequence", allocationSize = 1)
    @Column(name = "cart_id")
    private Integer cartId;
    @ManyToOne
    @JoinColumn(name = "customerDetails_id")
    private CustomerDetails customerDetails;
    @OneToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

	@Override
	public int hashCode() {
		return Objects.hash(cartId, creationTime, customerDetails, product, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(cartId, other.cartId) && Objects.equals(creationTime, other.creationTime)
				&& Objects.equals(customerDetails, other.customerDetails) && Objects.equals(product, other.product)
				&& Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerDetails=" + customerDetails + ", product=" + product
				+ ", quantity=" + quantity + ", creationTime=" + creationTime + "]";
	}
    
}
