#创建员工管理系统数据库
create database employee_system character set utf8 collate utf8_general_ci;


#创建用户表
create table user(
	uid int auto_increment comment '用户编号',
	username varchar(32) unique comment '用户名',
	password varchar(32) not null comment '密码',
	email varchar(32) comment '用户邮箱',
	primary key(uid)
)
#添加用户
insert into user(username,password,email) value(?,?,?,?);

#创建员工表
create table employee(
	empno int auto_increment comment '员工编号',
	empname varchar(32) comment '员工姓名',
	empsex int comment '员工性别',
	job varchar(32) comment '员工职位',
	hiredate date comment '入职时间',
	salary double comment '薪水',
	sid int comment '上级领导',
	deptno int comment '所属部门',
	hobby varchar(32) comment '爱好',
	primary key(empno)
)

#创建部门表
create table department(
	deptno int auto_increment comment '部门编号',
	deptname varchar(32) comment '部门名称',
	primary key(deptno)
)