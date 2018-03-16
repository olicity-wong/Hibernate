/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.37 : Database - test_1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test_1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test_1`;

/*Table structure for table `book_message` */

DROP TABLE IF EXISTS `book_message`;

CREATE TABLE `book_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `name` varchar(50) NOT NULL COMMENT '图书名',
  `price` float NOT NULL COMMENT '图书价格',
  `press` varchar(50) NOT NULL COMMENT '出版社',
  `author` varchar(50) NOT NULL COMMENT '图书作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `book_message` */

/*Table structure for table `user_message` */

DROP TABLE IF EXISTS `user_message`;

CREATE TABLE `user_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自动增长',
  `username` varchar(50) NOT NULL COMMENT '会员姓名',
  `userpass` varchar(50) NOT NULL COMMENT '会员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_message` */

insert  into `user_message`(`id`,`username`,`userpass`) values (1,'admin','abc123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
