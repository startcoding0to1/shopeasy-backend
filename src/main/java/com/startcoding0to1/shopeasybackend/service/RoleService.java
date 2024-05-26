package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.entity.Roles;

import java.util.List;

public interface RoleService {

    public List<Roles> getAllRoles();

    public Roles getRole(String roleName);

    public String updateRole(String roleName);

    public String deleteRole(String roleName);
}
