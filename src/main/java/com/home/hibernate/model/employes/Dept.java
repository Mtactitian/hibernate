package com.home.hibernate.model.employes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Immutable
@ToString(exclude = "employees")
@Table(name = "DEPT")
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "dept")
@NoArgsConstructor
public class Dept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq_gen")
    @SequenceGenerator(name = "dept_seq_gen", sequenceName = "dept_seq", allocationSize = 1)
    private Integer deptno;

    private String dname;

    private String loc;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "dept", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
}
