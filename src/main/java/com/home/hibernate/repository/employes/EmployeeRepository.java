package com.home.hibernate.repository.employes;

import com.home.hibernate.model.employes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEname(String n);

	Set<Employee> findByDept_DeptnoLessThanAndSalaryGreaterThan(int dept, double sal);

	List<Employee> findByDept_Deptno(int dept);
}
