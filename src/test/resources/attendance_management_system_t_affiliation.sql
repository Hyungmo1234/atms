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
-- Table structure for table `t_affiliation`
--

DROP TABLE IF EXISTS `t_affiliation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_affiliation` (
  `com_name` varchar(8) NOT NULL,
  `dep_code` varchar(11) NOT NULL,
  PRIMARY KEY (`com_name`,`dep_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_affiliation`
--

LOCK TABLES `t_affiliation` WRITE;
/*!40000 ALTER TABLE `t_affiliation` DISABLE KEYS */;
INSERT INTO `t_affiliation` VALUES ('CSS','BSNS'),('CSS','HRSM_HRIN'),('CSS','HRSM_HROU'),('CSS','IDCO'),('CSS','MNGM'),('CSS','SIHD_SI1D'),('CSS','SIHD_SI2D'),('CSS','SIHD_SI3D'),('CSS','SIHD_SI4D'),('FOS','BSNS'),('FOS','HRSM_HRIN'),('FOS','HRSM_HROU'),('FOS','IDCO'),('FOS','MNGM'),('FOS','SIHD_SI1D'),('FOS','SIHD_SI2D'),('FOS','SIHD_SI3D'),('FOS','SIHD_SI4D'),('GCS','BSNS'),('GCS','HRSM_HRIN'),('GCS','HRSM_HROU'),('GCS','IDCO'),('GCS','MNGM'),('GCS','SIHD_SI1D'),('GCS','SIHD_SI2D'),('GCS','SIHD_SI3D'),('GCS','SIHD_SI4D'),('GCS','SIHD_SI5D'),('ISS','BSNS'),('ISS','HRSM_HRIN'),('ISS','HRSM_HROU'),('ISS','IDCO'),('ISS','MNGM'),('ISS','SIHD_SI11'),('ISS','SIHD_SI12'),('ISS','SIHD_SI13'),('NCB','BSNS'),('NCB','HRSM_HRIN'),('NCB','HRSM_HROU'),('NCB','IDCO'),('NCB','MNGM'),('NCB','SIHD_SI11'),('NCB','SIHD_SI12'),('NCB','SIHD_SI21'),('NCB','SIHD_SI22'),('NCB','STPO'),('PSS','BSNS'),('PSS','HRSM_HRIN'),('PSS','HRSM_HROU'),('PSS','IDCO'),('PSS','MNGM'),('PSS','SIHD_SI1D'),('PSS','SIHD_SI2D'),('PSS','SIHD_SI3D');
/*!40000 ALTER TABLE `t_affiliation` ENABLE KEYS */;
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
