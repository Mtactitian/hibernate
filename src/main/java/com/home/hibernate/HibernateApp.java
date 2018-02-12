package com.home.hibernate;

import com.home.hibernate.model.employes.Dept;
import com.home.hibernate.repository.employes.DeptRepository;
import com.home.hibernate.repository.employes.EmployeeRepository;
import com.home.hibernate.repository.messages.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class HibernateApp extends SpringBootServletInitializer implements CommandLineRunner {

    private Logger slf4jLogger = LoggerFactory.getLogger(HibernateApp.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DeptRepository deptRepository;

    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApp.class, args);
    }

    @Override
    @Transactional(readOnly = true)
    public void run(String... strings) {

        Dept dept = deptRepository.findByDeptno(10);

        System.out.println(dept.getEmployees().get(0).getEmpno());
        System.out.println(dept.getEmployees().get(1).getEmpno());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder.sources(HibernateApp.class));
    }
}
