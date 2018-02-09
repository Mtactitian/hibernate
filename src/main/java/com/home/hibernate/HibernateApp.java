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
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false, basePackages = "com.home.hibernate.repository")
public class HibernateApp extends SpringBootServletInitializer implements CommandLineRunner {

    private Logger slf4jLogger = LoggerFactory.getLogger(HibernateApp.class);

    @Autowired
    private MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateApp.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws InterruptedException {

        Message message = new Message();
        message.setText("W!");
        Message message1 = new Message();
        message1.setText("W2!");

        messageRepository.save(message);
        messageRepository.save(message1);

        messageRepository.flush();

        Thread.sleep(100000000);

        slf4jLogger.info(messageRepository.getMessages().toString());

    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder.sources(HibernateApp.class));
    }
}
