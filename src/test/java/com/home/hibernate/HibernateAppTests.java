package com.home.hibernate;

import com.home.hibernate.model.employes.Employee;
import com.home.hibernate.repository.employes.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateAppTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@Rollback
	@Transactional
	public void contextLoads() {
		employeeRepository.findAll(new Sort(Sort.Direction.DESC, "salary"))
				.stream()
				.map(Employee::getSalary)
				.forEach(System.out::println);
	}
}
