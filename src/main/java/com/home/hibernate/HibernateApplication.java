package com.home.hibernate;

import com.home.hibernate.model.messages.Message;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootApplication
@EnableJpaRepositories
public class HibernateApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(HibernateApplication.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Message message = new Message();
        message.setText("Hello World!");

        messageRepository.saveAndFlush(message);

        logger.info(messageRepository.getMessages().toString());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder.sources(HibernateApplication.class));
    }
}
