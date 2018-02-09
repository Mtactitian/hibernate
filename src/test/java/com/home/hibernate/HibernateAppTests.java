package com.home.hibernate;

import com.home.hibernate.model.messages.Message;
import com.home.hibernate.repository.messages.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateAppTests {

	@Autowired
	MessageRepository messageRepository;

	@Test
	@Rollback
	public void contextLoads() {
		Message message = new Message();
		message.setText("W1!");

		messageRepository.saveAndFlush(message);

		assertNotNull(messageRepository);
		assertNotNull(messageRepository.getMessages());
		assertThat(messageRepository.getMessages()).hasSize(1);
		System.out.println(messageRepository.getMessages());
	}

}
