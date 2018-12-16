/*
MySQL Backup
Database: dblm
Backup Time: 2018-12-16 12:56:43
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `dblm`.`administrator`;
DROP TABLE IF EXISTS `dblm`.`bookitem`;
DROP TABLE IF EXISTS `dblm`.`borrower`;
DROP TABLE IF EXISTS `dblm`.`graduate`;
DROP TABLE IF EXISTS `dblm`.`librarian`;
DROP TABLE IF EXISTS `dblm`.`loan`;
DROP TABLE IF EXISTS `dblm`.`undergraduate`;
DROP PROCEDURE IF EXISTS `dblm`.`createalltable`;
CREATE TABLE `administrator` (
  `adminid` varchar(6) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE `bookitem` (
  `bookitemid` varchar(6) NOT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `bookname` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `publishdate` date DEFAULT NULL,
  PRIMARY KEY (`bookitemid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE `borrower` (
  `borrowerid` varchar(6) NOT NULL,
  `department` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`borrowerid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE `graduate` (
  `borrowerid` varchar(6) NOT NULL,
  `director` varchar(50) DEFAULT NULL,
  `major` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`borrowerid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE `librarian` (
  `librarianid` varchar(6) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`librarianid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE `loan` (
  `loanid` varchar(6) NOT NULL,
  `borrowerid` varchar(6) NOT NULL,
  `loandate` date DEFAULT NULL,
  `duedate` date DEFAULT NULL,
  `bookisbn` varchar(50) DEFAULT NULL,
  `isreturned` tinyint(1) DEFAULT '0',
  `bookitemid` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`loanid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE TABLE `undergraduate` (
  `borrowerid` varchar(6) NOT NULL,
  `major` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`borrowerid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createalltable`()
begin
create table borrower
(
borrowerid varchar(6) not null primary key,
department varchar(50),
name varchar(50),
type tinyint(1),
password varchar(50)
);

create table graduate
(
borrowerid varchar(6) not null primary key references borrower(borrowerid),
director varchar(50),
major varchar(50)
);

create table undergraduate
(
borrowerid varchar(6) not null primary key references borrower(borrowerid),
major varchar(50)
);

create table loan
(
loanid varchar(6) not null primary key,
borrowerid varchar(6) not null references borrower(borrowerid),
loandate date,
duedate date,
bookisbn varchar(50),
isreturned tinyint(1) default 0,
bookitemid varchar(6) references bookitem(bookitemid)
);

create table bookitem
(
bookitemid varchar(6) not null primary key,
isbn varchar(50),
bookname varchar(50),
price real,
author varchar(50),
publishdate date
);

create table administrator
(
adminid varchar(6) not null primary key,
name varchar(50),
password varchar(50)
);

create table librarian
(
librarianid varchar(6) not null primary key,
name varchar(50),
password varchar(50)
);

end;
BEGIN;
LOCK TABLES `dblm`.`administrator` WRITE;
DELETE FROM `dblm`.`administrator`;
INSERT INTO `dblm`.`administrator` (`adminid`,`name`,`password`) VALUES ('000001', '胡自然', '123456'),('100000', 'wincen', '123321');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `dblm`.`bookitem` WRITE;
DELETE FROM `dblm`.`bookitem`;
INSERT INTO `dblm`.`bookitem` (`bookitemid`,`isbn`,`bookname`,`price`,`author`,`publishdate`) VALUES ('100000', 'a', '编译原理', 12, '姚老师', '2011-01-01'),('100001', 'a', '编译原理', 12, '姚老师', '2011-01-01'),('200000', 'b', '体系结构', 55, '刘维', '2011-02-02'),('200001', 'b', '体系结构', 55, '刘维', '2011-02-02');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `dblm`.`borrower` WRITE;
DELETE FROM `dblm`.`borrower`;
INSERT INTO `dblm`.`borrower` (`borrowerid`,`department`,`name`,`type`,`password`) VALUES ('000001', '计算机', '阿钦', 1, '123456'),('000002', '计算机', '阿淇', 1, '123456'),('000003', '计算机', '阿颖', 1, '123456');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `dblm`.`graduate` WRITE;
DELETE FROM `dblm`.`graduate`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `dblm`.`librarian` WRITE;
DELETE FROM `dblm`.`librarian`;
INSERT INTO `dblm`.`librarian` (`librarianid`,`name`,`password`) VALUES ('000001', '书管', '123456'),('123123', 'huzra', '000000');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `dblm`.`loan` WRITE;
DELETE FROM `dblm`.`loan`;
INSERT INTO `dblm`.`loan` (`loanid`,`borrowerid`,`loandate`,`duedate`,`bookisbn`,`isreturned`,`bookitemid`) VALUES ('123', '000001', '2017-12-12', '2018-02-02', 'a', 0, '100000'),('124', '000002', '2015-04-06', '2015-05-04', 'b', 0, '200000');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `dblm`.`undergraduate` WRITE;
DELETE FROM `dblm`.`undergraduate`;
INSERT INTO `dblm`.`undergraduate` (`borrowerid`,`major`) VALUES ('000001', '软件工程'),('000002', '软件工程'),('000003', '软件工程');
UNLOCK TABLES;
COMMIT;
