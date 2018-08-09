----DEPARTMENT----

create table department( department_no varchar2(10) not null, department_name varchar2(50) not null, primary key(department_no), 
unique(department_name));

----SCHEDULE_SHARE----

create table schedule_share( share_no varchar2(40) not null, request_employee_no varchar2(20) not null, accept_employee_no varchar2(20) 
not null, accept_status char(1), share_color varchar2(7) not null, primary key(share_no));

----EMPLOYEE----

create table employee( employee_no varchar2(20) not null, employee_name varchar2(30) not null, password varchar2(10) not null, department_no varchar2(10) 
not null, position_no varchar2(10) not null, emp_hire_date date, emp_end_date date, birth_date date, phone varchar2(14), extension varchar2(14), email varchar2(50),
address varchar2(100), annual_leave numeric(30), role varchar2(10) default 'employee' not null, sign_image varchar2(100), profile_image varchar2(100), 
log_code char(3), primary key(employee_no), unique(email, sign_image, profile_image));

alter table employee add constraint fk_employee foreign key(department_no) references department(department_no);
alter table employee add constraint fk_employeee foreign key(position_no) references position(position_no);

----SCHEDULE----

create table schedule( sche_serial_no number not null, start_date varchar2(8) not null, end_date varchar2(8) not null, start_time varchar2(9) not null,
end_time varchar2(9) not null, share_range char(1) not null, title varchar2(20) not null, content varchar2(50), reg_date date, employee_no varchar2(20),
primary key(sche_serial_no));

alter table schedule add constraint fk_schedule foreign key(employee_no) references employee(employee_no);

----POSITION----

create table position( position_no varchar2(10) not null, position_name varchar2(50) not null, rank_code char(3) not null, 
primary key(position_no), unique(position_name));

----STANDARD_TIME----

create table standard_time( serial_no number, std_start_time varchar2(5) not null, std_end_time varchar2(5) not null, reg_date date, reg_id varchar2(20), 
primary key(serial_no));

----ATTENDANCE----

create table attendance( attendance_no varchar2(30) not null, attendate_date varchar2(8) not null, employee_no varchar2(20) not null, 
std_start_time varchar2(8) , start_time varchar2(8), start_ip varchar2(20), leave_date varchar2(8), std_end_time varchar2(8), end_time varchar2(8), 
end_ip varchar2(20), memo varchar2(20), 
primary key(attendance_no));

alter table attendance add constraint fk_attendace foreign key(employee_no) references employee(employee_no);

----IP----

create table ip( serial_no number, start_ip varchar2(20) not null, end_ip varchar2(20) not null, reg_date date, reg_id varchar2(20), 
primary key(serial_no));

----APPROVAL----

create table approval( doc_no varchar2(12) not null, doc_type char(1) not null, approval_order char(1) not null, status char(1) default '1', 
start_date varchar2(8), end_date varchar2(8), use_day number(3), title varchar2(50), content clob, memo varchar2(100), filename1 varchar2(30), 
filename2 varchar2(30), filename3 varchar2(30), reg_date date, reg_employee_no varchar2(20), mod_date date, mod_employee_no varchar2(20), 
primary key(doc_no));

----APPROVAL_EMPLOYEE----

create table approval_employee( serial_no number not null, doc_no varchar2(12) not null, gubun char(1), approval_order varchar2(2), status char(1), 
approval_date date, sign_image varchar2(30), reg_date date, employee_no varchar2(20) not null, 
primary key(serial_no));

alter table approval_employee add constraint fk_approval_employee foreign key(doc_no) references approval(doc_no);
alter table approval_employee add constraint fk_approval_employeee foreign key(employee_no) references employee(employee_no);

----MEETINGROOM----

create table meetingroom( meetingroom_code numeric(10) not null, meetingroom_name varchar2(10) not null, 
primary key(meetingroom_code), unique(meetingroom_name));

----RESERVATION----

create table reservation( meetingroom_name varchar2(10) not null, employee_no varchar2(20) not null, start_time date not null, end_date date not null, 
reservation_detail varchar2(255), reservation_date date not null);

alter table reservation add constraint fk_reservation foreign key(meetingroom_name) references meetingroom(meetingroom_name);
alter table reservation add constraint fk_reservationn foreign key(employee_no) references employee(employee_no);

----approval--------

CREATE SEQUENCE seq_approval_no		 INCREMENT BY 1 START WITH 1000;


----approval_employee--------

ALTER TABLE approval_employee ADD(memo VARCHAR2(30)); 

CREATE SEQUENCE seq_approval_employee_no		 	 INCREMENT BY 1 START WITH 10000;

----board--------
CREATE TABLE board( board_no numeric(10), board_title varchar2(50), employee_no varchar2(20), 
board_date date, board_content varchar(2048), board_available numeric(5), primary key(board_no));

CREATE SEQUENCE seq_board_board_no INCREMENT BY 1 START WITH 1;