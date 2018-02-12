package com.home.hibernate.repository.employes;

import com.home.hibernate.model.employes.Dept;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

    Dept findByDeptno(Integer deptno);

}
