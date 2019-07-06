-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: attendance_management_system
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_employee`
--

DROP TABLE IF EXISTS `t_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_employee` (
  `id` varchar(18) NOT NULL,
  `password` varchar(64) NOT NULL,
  `emp_name` varchar(30) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `entry_date` varchar(8) DEFAULT NULL,
  `com_code` varchar(5) DEFAULT NULL,
  `dep_code` varchar(11) DEFAULT NULL,
  `pos_code` varchar(3) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `cellphone` varchar(11) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `adm_code` varchar(4) DEFAULT NULL,
  `reg_id` varchar(18) DEFAULT NULL,
  `reg_date` varchar(18) DEFAULT NULL,
  `upd_id` varchar(18) DEFAULT NULL,
  `upd_date` varchar(18) DEFAULT NULL,
  `del_cd` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_com_code_idx` (`com_code`),
  KEY `fk_department_code_idx` (`dep_code`),
  KEY `fk_position_code_idx` (`pos_code`),
  CONSTRAINT `fk_company_code` FOREIGN KEY (`com_code`) REFERENCES `t_company` (`com_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_department_code` FOREIGN KEY (`dep_code`) REFERENCES `t_department` (`dep_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_position_code` FOREIGN KEY (`pos_code`) REFERENCES `t_position` (`pos_code`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_employee`
--

LOCK TABLES `t_employee` WRITE;
/*!40000 ALTER TABLE `t_employee` DISABLE KEYS */;
INSERT INTO `t_employee` VALUES ('1','1','1',1,'1','12','IDCO','ONE','1',NULL,'1',NULL,NULL,NULL,NULL,NULL,0),('12333','1','123',1,'20190611','21','BSNS','LD','jgs9501@gmail.com','1','sadasd',NULL,NULL,NULL,NULL,NULL,0),('aaa','1234','劉晟佑',1,'20190528','12','MNGM','MB','yoo_sungwoo@nuvo.co.jp','010101','dasdadad','111',NULL,NULL,NULL,NULL,0),('aaaa','1111','test',1,'1234','21','HRSM_HROU','PD','1234','1234','1234',NULL,NULL,NULL,NULL,NULL,0),('abc','1234','abc',1,'20190528','12',NULL,'EM','abc','1234','abc',NULL,NULL,NULL,NULL,NULL,0),('bb','1234','1234',1,'20190528','13','MNGM','MB','yoo_sungwoo@nuvo.co.jp','010101','dasdadad','0100',NULL,NULL,NULL,NULL,0),('gcs','1234','李永泰',1,'20190528','11','SIHD_SI4D','ONE','aaa@gmail.com',NULL,'東京都品川区八潮5丁目3番','0100',NULL,NULL,NULL,NULL,0),('jang','123','jangjunsoo',2,'20200001','12',NULL,'MB','','123','123',NULL,NULL,NULL,NULL,NULL,0),('jgs122456','!wns804546','張俊洙',NULL,'20190508','11','SIHD_SI5D','MB','jgs9501@gmail.com',NULL,'東京都品川区八潮5－5－37－123',NULL,NULL,NULL,NULL,NULL,0),('jgs12345','!wns123456','張俊洙',1,'20190508','11','SIHD_SI5D','MB','jgs9501@gmail.com','08000000000','東京都品川区八潮5－5－37－123',NULL,NULL,NULL,NULL,NULL,0),('jgs123456','!wns804546','123',1,'20190508','11','SIHD_SI5D','MB','jgs9501@gmail.com',NULL,'東京都品川区八潮5－5－37－123',NULL,NULL,NULL,NULL,NULL,0),('ncb','123','李永泰',1,'123','21','BSNS','AEM','123','123','123',NULL,NULL,NULL,NULL,NULL,0),('nono','yes','nono',1,'20190528','11','SIHD_SI1D','DIR','nono',NULL,'nono',NULL,NULL,NULL,NULL,NULL,0),('pppp','1234','aaa',1,'20190528','21','HRSM_HROU','DIR','aaa','','asdasd',NULL,NULL,NULL,NULL,NULL,0),('pss','1234','李永泰',1,'20190528','21','HRSM_HRIN','AGM','c@gmail.com',NULL,'東京都品川区八潮5丁目3番','0200',NULL,NULL,NULL,NULL,0),('ryry','ryry','ryry',1,'20190528','12','SIHD_SI11','AGM','ryry',NULL,'ryry',NULL,NULL,NULL,NULL,NULL,0),('ttt','ttt','ttt',1,'20190528','12','SIHD_SI21','AEM','ttt',NULL,'ttt',NULL,NULL,NULL,NULL,NULL,0),('tyty','tyty','tyty',2,'20190528','21','SIHD_SI1D','AEM','tyty',NULL,'tyty',NULL,NULL,NULL,NULL,NULL,0),('yes','no','yes',2,'20190528','11','SIHD_SI4D','ONE','yes',NULL,'yes',NULL,NULL,NULL,NULL,NULL,0),('zxcv','12345','asdasd',1,'20190528','22','BSNS','DIR','asd','','asd',NULL,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `t_employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-28 12:42:32
