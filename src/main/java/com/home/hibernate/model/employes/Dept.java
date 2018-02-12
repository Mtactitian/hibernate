package com.home.hibernate.model.employes;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Immutable
@ToString(exclude = "employees")
@Table(name = "DEPT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq_gen")
    @SequenceGenerator(name = "dept_seq_gen", sequenceName = "dept_seq", allocationSize = 0)
    private Integer deptno;

    private String dname;

    private String loc;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "dept", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
}
