package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.entity.Roles;
import com.startcoding0to1.shopeasybackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    public ResponseEntity<List<Roles>> getAllRoles(){
        List<Roles> list=roleService.getAllRoles();
        return null;
    }
}
