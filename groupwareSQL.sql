drop table EMPLOYEE;

drop table todolist;

drop table message;

drop table reply;

drop table Board;

drop table  Notice;

drop table cal_sch ;

drop table approval ;

drop  table scheduler ;



CREATE TABLE EMPLOYEE (
   emp_no INTEGER AUTO_INCREMENT PRIMARY KEY, /* 사원번호 */
   team VARCHAR(10) NOT null, /* 팀 */
   email VARCHAR(50) NOT null unique, /* 이메일 */
   name VARCHAR(50) NOT null, /* 직원이름 */
   password VARCHAR(30) NOT null, /* 암호 */
   position VARCHAR(50) not null, /* 직급 */
   gender VARCHAR(30) NOT null, /* 성별 */
   role VARCHAR(10) NOT null DEFAULT 'user' /* 권한 */
);

CREATE TABLE todolist  (
   num integer  AUTO_INCREMENT primary key,
   emp_no int(10) not null,
   title VARCHAR(50) not null,
   importance int(10) not null,
   H VARCHAR(10) not null,
   Min VARCHAR(10) not null
);
ALTER TABLE todolist 
ADD FOREIGN KEY (emp_no) REFERENCES EMPLOYEE(emp_no);


create table reply 
(
   no Integer AUTO_INCREMENT PRIMARY key,
   content varchar(50) not null,
   writedate date not null,
   emp_no Integer not null,
   board_no Integer not null
   
);

create table Board 
(
   no Integer AUTO_INCREMENT PRIMARY key,
   title varchar(50) not null,
   content varchar(500) not null,
   password varchar(10) not null,
   writedate date not null,
   hit Integer not null,
   emp_no Integer not null
);

/*공지*/
create table Notice (
       no integer auto_increment,
       title varchar(50) not null,
       content varchar(500) not null,
       password varchar(10) not null,		
       hit integer not null,
       writeDate date not null,
       emp_no integer not null,
       primary key (no)
);

ALTER TABLE reply 
ADD FOREIGN KEY (emp_no) REFERENCES EMPLOYEE(emp_no);

ALTER TABLE reply
ADD FOREIGN KEY (board_no) REFERENCES Board(no);

ALTER TABLE Board 
ADD FOREIGN KEY (emp_no) REFERENCES EMPLOYEE(emp_no);

ALTER TABLE Notice
ADD FOREIGN KEY (emp_no) REFERENCES EMPLOYEE(emp_no);


create table message(
	id integer auto_increment primary key,
	title varchar(20) not null,
	content varchar(100) not null,
	deletedBySender boolean not null,
	deletedByReceiver boolean not null,
	sender integer not null,
	receiver integer not null,
	writedate datetime not null,
	constraint m_sender foreign key(sender) references employee(emp_no),
	constraint m_receiver foreign key(receiver) references employee(emp_no)
);

