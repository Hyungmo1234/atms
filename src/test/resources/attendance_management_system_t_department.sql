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
-- Table structure for table `t_department`
--

DROP TABLE IF EXISTS `t_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_department` (
  `dep_code` varchar(11) NOT NULL,
  `dep_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`dep_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_department`
--

LOCK TABLES `t_department` WRITE;
/*!40000 ALTER TABLE `t_department` DISABLE KEYS */;
INSERT INTO `t_department` VALUES ('BSNS','営業部'),('BSNS_BSN1','営業部 第1部'),('BSNS_BSN2','営業部 第2部'),('BSNS_BSN3','営業部 第3部'),('DEHD','開発事業本部'),('HRHD','人事本部'),('HRSM_HRIN','人事総括本部 対内人事部'),('HRSM_HROU','人事総括本部 対外人事部'),('IDCO','個人契約'),('MNGM','管理部'),('MNGM_MNG1','管理部 第1部'),('MNGM_MNG2','管理部 第2部'),('MNGM_MNG3','管理部 第3部'),('SIHD_SI11','SI事業1部 第1事業部'),('SIHD_SI12','SI事業1部 第2事業部'),('SIHD_SI13','SI事業1部 第3事業部'),('SIHD_SI1D','SI事業本部 開発1部'),('SIHD_SI21','SI事業2部 第1事業部'),('SIHD_SI22','SI事業2部 第2事業部'),('SIHD_SI23','SI事業2部 第3事業部'),('SIHD_SI2D','SI事業本部 開発2部'),('SIHD_SI3D','SI事業本部 開発3部'),('SIHD_SI4D','SI事業本部 開発4部'),('SIHD_SI5D','SI事業本部 開発5部'),('STPO','戦略企画室');
/*!40000 ALTER TABLE `t_department` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-28 12:42:31
