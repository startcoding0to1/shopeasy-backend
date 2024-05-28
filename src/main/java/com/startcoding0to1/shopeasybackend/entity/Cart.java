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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(getCartId(), cart.getCartId()) && Objects.equals(getUser(), cart.getUser()) && Objects.equals(getProduct(), cart.getProduct()) && Objects.equals(getQuantity(), cart.getQuantity()) && Objects.equals(getCreationTime(), cart.getCreationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getUser(), getProduct(), getQuantity(), getCreationTime());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", product=" + product +
                ", Quantity=" + quantity +
                ", cretionTime=" + creationTime +
                '}';
    }
}
