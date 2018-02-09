package com.home.hibernate.model.employes;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Getter
@Immutable
@ToString
@Builder
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq_gen")
    @SequenceGenerator(name = "dept_seq_gen", sequenceName = "dept_seq", allocationSize = 0)
    private Integer deptno;

    private String dname;

    private String loc;
}
