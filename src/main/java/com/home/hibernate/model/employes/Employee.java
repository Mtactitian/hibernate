package com.home.hibernate.model.employes;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "EMP")
@ToString
@Builder
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq_gen")
	@SequenceGenerator(name = "emp_seq_gen", sequenceName = "emp_seq", allocationSize = 1)
	private Integer empno;

	private String ename;

	private String job;

	@Column(name = "mgr")
	private Integer managerNumber;

	private Date hireDate;

	@Column(name = "sal")
	private Double salary;

	@Column(name = "comm")
	private Double commision;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "deptno", referencedColumnName = "deptno")
	private Dept dept;
}
