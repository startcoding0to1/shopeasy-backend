package com.startcoding0to1.shopeasybackend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "admin_details")
public class AdminDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="admin_details_id_gen")
    @SequenceGenerator(name = "admin_details_id_gen",sequenceName = "admin_details_id_sequence",allocationSize = 1)
    @Column(name = "admin_details_id")
    private Integer adminId;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;
    @OneToMany(mappedBy = "adminDetails",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private Set<Address> addresses;

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	@Override
	public int hashCode() {
		return Objects.hash(addresses, adminId, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDetails other = (AdminDetails) obj;
		return Objects.equals(addresses, other.addresses) && Objects.equals(adminId, other.adminId)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "AdminDetails [adminId=" + adminId + ", user=" + user + ", addresses=" + addresses + "]";
	}
    
}
