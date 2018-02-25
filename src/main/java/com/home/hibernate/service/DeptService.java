package com.home.hibernate.service;

import com.home.hibernate.model.employes.Dept;
import com.home.hibernate.repository.employes.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Cacheable(value = "deptCache", key = "#name")
    public Dept getByName(String name) {
        return deptRepository.findByDname(name);
    }
}
