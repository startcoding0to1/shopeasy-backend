package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.AdminDetails;
import com.startcoding0to1.shopeasybackend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminDetailsRepository extends CrudRepository<AdminDetails,Integer> {
    public Optional<AdminDetails> findByUser(User user);
    @Modifying
    @Query("DELETE FROM AdminDetails a WHERE a.adminId = :adminId")
    public void deleteByAdminId(@Param(value = "adminId") Integer adminID);
}
