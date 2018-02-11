-- noinspection SqlNoDataSourceInspectionForFile

SET MODE ORACLE;

CREATE TABLE dept (
	deptno NUMBER(2, 0),
	dname  VARCHAR2(14),
	loc    VARCHAR2(13),
	CONSTRAINT pk_dept PRIMARY KEY (deptno)
);

CREATE SEQUENCE dept_seq
	start with 50
	maxvalue 100000000
	nocycle
	nocache
	increment by 10;


CREATE TABLE emp (
	empno    NUMBER(4, 0),
	ename    VARCHAR2(10),
	job      VARCHAR2(9),
	mgr      NUMBER(4, 0),
	hiredate DATE,
	sal      NUMBER(7, 2),
	comm     NUMBER(7, 2),
	deptno   NUMBER(2, 0),
	CONSTRAINT pk_emp PRIMARY KEY (empno),
	CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES dept (deptno)
);

CREATE SEQUENCE emp_seq
	START WITH 7000
	INCREMENT BY 1
	MAXVALUE 7400
	NOCYCLE
	CACHE 5;

CREATE TABLE message (
	id   NUMBER(10),
	text VARCHAR2(500),
);


CREATE SEQUENCE msg_seq
	start with 1
	increment by 1
	maxvalue 100000000
	nocycle
	CACHE 20;
