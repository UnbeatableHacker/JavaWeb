--
请将本部分复制到数据库中执行（创建库、表）
--
#数据库
create database LibraryManagementSystem character set utf8 collate utf8_general_ci;

#图书表
create table book(
	bookId int auto_increment comment '书号',
	bookName varchar(32) not null comment '书名',
	price double not null comment '价格',
	author varchar(32) not null comment '作者',
	publisher varchar(32) comment '出版社',
	publitionDate date comment '出版时间',
	totalNumber int	default 1 comment '总数',
	borrowedNum int default 0 comment '被借数量',
	primary key(bookId)
)
insert into book(bookName,price,author,publisher,totalNumber) value
('西游记',40.0,'吴承恩','人民出版社',4),
('水浒传',40.0,'施耐庵','人民出版社',4),
('红楼梦',40.0,'曹雪芹','人民出版社',4),
('三国演义',40.0,'罗贯中','人民出版社',4),
('七龙珠',40.0,'鸟山明','人民出版社',4),
('网球王子',40.0,'许斐刚','人民出版社',4),
('聊斋',40.0,'蒲松龄','人民出版社',4);

#学生表
create table student(
	stuId int auto_increment,
	stuName varchar(32) not null,
	sex int default 1 comment '1男0女',
	college varchar(32),
	className varchar(32),
	admissionTime date,
	primary key(stuId)
)
insert into student(stuName,college) value 
('手冢国光','网球王子'),('大石秀一郎','网球王子'),('菊丸英二','网球王子'),
('河村隆','网球王子'),('海棠熏','网球王子'),('桃城武','网球王子'),
('越前龙马','网球王子'),('乾真治','网球王子'),('孙悟空','七龙珠'),
('孙悟饭','七龙珠'),('贝吉塔','七龙珠'),('克林','七龙珠'),
('比克','七龙珠');

#教师表
create table teacher(
	teacherId int auto_increment,
	teacherName varchar(32) not null,
	sex int default 1 comment '1男0女',
	college varchar(32),
	admissionTime date,
	primary key(teacherId)
)
insert into teacher(teacherName,college) value 
('鸟山明','七龙珠'),('许斐刚','网球王子'),('花崎泪','总部');

#管理员表
create table administrator(
	admId	int auto_increment,
	admName varchar(32) not null,
	password varchar(32) not null,
	primary key(admId)
)
insert into administrator(admName,password) value
('花崎泪','8c3cdd8b462aaf3bb8c7922c6553bc7e')

#用户表
create table user(
	userId int auto_increment,
	userName varchar(32) not null,
	password varchar(32) not null,
	college varchar(32),
	sex int default 1 comment '1男0女',
	borrowNum int default 0,
	borrowingNum int default 0,
	primary key(userId)
)

#借阅表
create table borrowing(
	bId int auto_increment,
	userId int not null,
	bookId int not null,
	primary key(bId)
)