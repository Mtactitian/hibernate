package com.home.hibernate;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.home.hibernate.repository.employes.DeptRepository;
import com.home.hibernate.repository.employes.EmployeeRepository;
import com.home.hibernate.repository.messages.MessageRepository;
import com.home.hibernate.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class HibernateApp extends SpringBootServletInitializer implements CommandLineRunner {

    @Bean
    public Module module(){
        return new Hibernate5Module();
    }

    private Logger slf4jLogger = LoggerFactory.getLogger(HibernateApp.class);

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private DeptService deptService;

    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApp.class, args);
    }

    @Override
    @Transactional(readOnly = true)
    public void run(String... strings) {


    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder.sources(HibernateApp.class));
    }
}
