package com.home.hibernate.controller;

import com.home.hibernate.model.employes.Dept;
import com.home.hibernate.repository.employes.DeptRepository;
import com.home.hibernate.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptRestController {

    @Autowired
    private DeptService deptService;


    @Autowired
    private DeptRepository deptRepository;

    @GetMapping(value = "/dept/{dname}")
    public Dept getByName(@PathVariable String dname) {

            return deptService.getByName(dname);
    }
}
