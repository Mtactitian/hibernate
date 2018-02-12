-- noinspection SqlNoDataSourceInspectionForFile

SET MODE ORACLE;

CREATE TABLE dept (
	deptno NUMBER(2, 0),
	dname  VARCHAR2(14),
	loc    VARCHAR2(13),
	CONSTRAINT pk_dept PRIMARY KEY (deptno)
);

CREATE SEQUENCE dept_seq
	START WITH 50
	MAXVALUE 100000000
	NOCYCLE
	NOCACHE
	INCREMENT BY 10;


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
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 100000000
	NOCYCLE
	CACHE 20;

-- CREATE TABLE authors (
-- 	author VARCHAR2(100),
-- 	book   VARCHAR2(100),
-- 	CONSTRAINT pk_authors PRIMARY KEY (author, book)
-- );
--
-- CREATE TABLE books (
-- 	book   VARCHAR2(100),
-- 	author VARCHAR2(100),
-- 	CONSTRAINT pk_books PRIMARY KEY (book, author)
-- );


CREATE TABLE t_student (
	student_id   INTEGER GENERATED ALWAYS AS IDENTITY,
	student_name VARCHAR2(40),
	PRIMARY KEY (student_id)
);

CREATE TABLE t_course (
	course_id   INTEGER GENERATED ALWAYS AS IDENTITY ( START WITH 1, INCREMENT BY 1),
	course_name VARCHAR2(40),
	PRIMARY KEY (course_id)
);

CREATE TABLE t_student_course (
	student_id INTEGER,
	course_id  INTEGER,
	CONSTRAINT course_id_fk FOREIGN KEY (student_id) REFERENCES t_student (student_id),
	CONSTRAINT course_id_fk2 FOREIGN KEY (course_id) REFERENCES t_course (course_id)
);

create table author (
	author_id   NUMBER(3) generated always as identity,
	author_name VARCHAR2(50),
	book_id     NUMBER(3),
	primary key (author_id)
);

create table book (
	book_id   NUMBER(3),
	book_name VARCHAR2(50),
	author_id NUMBER(3),
	unique (book_id, author_id, book_name),
	foreign key (author_id) references author (author_id)
);

insert into author values (1, 'J.Bloch', 33);
insert into book values (33, 'Effective Java', (
	select author.author_id
	from author
	where author.book_id = 33));