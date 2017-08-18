/*
SQLyog Ultimate v8.55 
MySQL - 5.5.38 : Database - order
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`order` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `order`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cust_no` char(2) NOT NULL,
  `cust_name` varchar(50) DEFAULT NULL,
  `cust_address` varchar(100) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `trn` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cust_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`cust_no`,`cust_name`,`cust_address`,`contact`,`trn`) values ('m1','Amal','Gampaha','0784555634','101'),('m2','Amali','Colombo','0777755634','102'),('m3','Nimali','Colonnawa','0712345634','103'),('v1','Saumya','Niwandama','0332996655','106'),('v2','Samanthi','Ampara','0618876655','108'),('w1','Bagya','Niwandama','0332996655','106'),('w2','Bathiya','Nainamadama','0722996655','105'),('w3','Isuri','Naiwala','0712995634','104');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_no` int(10) NOT NULL,
  `order_date` date NOT NULL,
  `total_cost` float NOT NULL,
  `customer_no` varchar(10) NOT NULL,
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `orders` */

insert  into `orders`(`order_no`,`order_date`,`total_cost`,`customer_no`) values (1,'2017-08-01',200,'m1'),(2,'2017-08-01',600,'m3'),(3,'2017-08-02',1000,'w1'),(5,'2017-08-02',1200,'m2'),(6,'2017-08-03',1800,'m3'),(7,'2017-08-03',70000,'w3'),(8,'2017-08-04',8000,'w2'),(9,'2017-08-05',400,'v2'),(10,'2017-08-05',700,'v1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
