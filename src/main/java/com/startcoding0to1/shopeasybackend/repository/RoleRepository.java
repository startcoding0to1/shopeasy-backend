package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.Roles;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Roles,String> {
}