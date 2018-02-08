package com.home.hibernate.repository.messages;

import com.home.hibernate.model.messages.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer>{

    @Query("select t from Message t")
    List<Message> getMessages();
}
