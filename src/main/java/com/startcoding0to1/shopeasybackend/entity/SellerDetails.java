    package com.startcoding0to1.shopeasybackend.entity;

    import jakarta.persistence.*;

    import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

    @Entity
    @Table(name = "seller_details")
    public class SellerDetails implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seller_id_gen")
        @SequenceGenerator(name = "seller_id_gen",sequenceName = "seller_details_sequence",allocationSize = 1)
        @Column(name = "seller_id")
        private Integer sellerId;
        @Column(name = "company_name")
        private String companyName;
        @OneToOne
        @JoinColumn(name = "user_id",referencedColumnName = "user_id")
        private User user;

        @OneToMany(mappedBy = "sellerDetails",cascade = CascadeType.REMOVE,orphanRemoval = true)
        private Set<Address> companyAddresses;

        @OneToMany(mappedBy = "seller",cascade = CascadeType.REMOVE,orphanRemoval = true)
        private Set<Product> products;

        public Integer getSellerId() {
            return sellerId;
        }

        public void setSellerId(Integer sellerId) {
            this.sellerId = sellerId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Set<Address> getCompanyAddresses() {
            return companyAddresses;
        }

        public void setCompanyAddresses(Set<Address> companyAddresses) {
            this.companyAddresses = companyAddresses;
        }

        public Set<Product> getProducts() {
            return products;
        }

        public void setProducts(Set<Product> products) {
            this.products = products;
        }

		@Override
		public int hashCode() {
			return Objects.hash(companyAddresses, companyName, products, sellerId, user);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SellerDetails other = (SellerDetails) obj;
			return Objects.equals(companyAddresses, other.companyAddresses)
					&& Objects.equals(companyName, other.companyName) && Objects.equals(products, other.products)
					&& Objects.equals(sellerId, other.sellerId) && Objects.equals(user, other.user);
		}

		@Override
		public String toString() {
			return "SellerDetails [sellerId=" + sellerId + ", companyName=" + companyName + ", user=" + user
					+ ", companyAddresses=" + companyAddresses + ", products=" + products + "]";
		}
        
    }
