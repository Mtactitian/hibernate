package com.home.hibernate.repository.messages;

import com.home.hibernate.model.messages.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message, Long> {

	Message getFirstByText(String s);

	@Modifying
	@Query("update Message m set m.text =:newMsg where m.text =:oldMsg")
	void replaceTextWithNewText(@Param("oldMsg") String oldMsg, @Param("newMsg") String newMsg);

}
