package com.home.hibernate.repository.employes;

import com.home.hibernate.model.employes.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Integer> {
    Dept findByDeptno(Integer dept);
}
