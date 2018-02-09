package com.home.hibernate.model.messages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msg_seq_gen")
    @SequenceGenerator(name = "msg_seq_gen", sequenceName = "msg_seq", allocationSize = 1)
    private Long id;

    @Setter
    private String text;
}
