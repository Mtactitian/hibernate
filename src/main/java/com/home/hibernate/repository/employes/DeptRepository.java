package com.home.hibernate.repository.employes;

import com.home.hibernate.model.employes.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface DeptRepository extends JpaRepository<Dept,Integer> {
    Dept findByDeptno(Integer dept);
}
