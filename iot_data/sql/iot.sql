-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: iot
-- ------------------------------------------------------
-- Server version	5.7.25-log

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
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` int(11) NOT NULL,
  `name` varchar(50),
  `temperature` float DEFAULT NULL,
  `press` float DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,100,'testdevice',12.1,298.54,'2020-06-06 04:00:00','219.219.120.72'),(2,100,'testdevice',57.4,496.64,'2020-06-05 16:00:00','219.219.120.72'),(3,100,'testdevice',10.8,87.58,'2020-06-05 04:00:00','219.219.120.72'),(4,100,'testdevice',1.7,447.96,'2020-06-04 16:00:00','219.219.120.72'),(5,100,'testdevice',36.1,477.08,'2020-06-04 04:00:00','219.219.120.72'),(6,100,'testdevice',55.4,41.5,'2020-06-03 16:00:00','219.219.120.72'),(7,100,'testdevice',48.7,276.26,'2020-06-03 04:00:00','219.219.120.72'),(8,100,'testdevice',17.4,256.79,'2020-06-02 16:00:00','219.219.120.72'),(9,100,'testdevice',1,455.17,'2020-06-02 04:00:00','219.219.120.72'),(10,100,'testdevice',12.5,5.48,'2020-06-01 16:00:00','219.219.120.72'),(11,100,'testdevice',59.8,161.88,'2020-06-01 04:00:00','219.219.120.72'),(12,100,'testdevice',21.6,292.97,'2020-05-31 16:00:00','219.219.120.72'),(13,100,'testdevice',48.4,479.19,'2020-05-31 04:00:00','219.219.120.72'),(14,100,'testdevice',57.4,17.07,'2020-05-30 16:00:00','219.219.120.72'),(15,100,'testdevice',21.5,147.79,'2020-05-30 04:00:00','219.219.120.72'),(16,100,'testdevice',55.4,187.72,'2020-05-29 16:00:00','219.219.120.72'),(17,100,'testdevice',32.6,495.25,'2020-05-29 04:00:00','219.219.120.72'),(18,100,'testdevice',56.7,413.09,'2020-05-28 16:00:00','219.219.120.72'),(19,100,'testdevice',5.6,79.69,'2020-05-28 04:00:00','219.219.120.72'),(20,100,'testdevice',38,159.18,'2020-05-27 16:00:00','219.219.120.72'),(21,100,'testdevice',53.3,56.84,'2020-05-27 04:00:00','219.219.120.72'),(22,100,'testdevice',32.5,306.65,'2020-05-26 16:00:00','219.219.120.72'),(23,100,'testdevice',2.4,362.71,'2020-05-26 04:00:00','219.219.120.72'),(24,100,'testdevice',34.6,393.64,'2020-05-25 16:00:00','219.219.120.72'),(25,100,'testdevice',45.7,380.03,'2020-05-25 04:00:00','219.219.120.72'),(26,100,'testdevice',4.6,219.26,'2020-05-24 16:00:00','219.219.120.72'),(27,100,'testdevice',6.2,456.2,'2020-05-24 04:00:00','219.219.120.72'),(28,100,'testdevice',16.9,123.22,'2020-05-23 16:00:00','219.219.120.72'),(29,100,'testdevice',6,247.48,'2020-05-23 04:00:00','219.219.120.72'),(30,100,'testdevice',39.2,367.78,'2020-05-22 16:00:00','219.219.120.72'),(31,100,'testdevice',58.1,96.42,'2020-05-22 04:00:00','219.219.120.72'),(32,100,'testdevice',52.8,378.78,'2020-05-21 16:00:00','219.219.120.72'),(33,100,'testdevice',29.6,104.63,'2020-05-21 04:00:00','219.219.120.72'),(34,100,'testdevice',49.9,386.82,'2020-05-20 16:00:00','219.219.120.72'),(35,100,'testdevice',40.4,120.21,'2020-05-20 04:00:00','219.219.120.72'),(36,100,'testdevice',52.6,440.57,'2020-05-19 16:00:00','219.219.120.72'),(37,100,'testdevice',21.7,342.25,'2020-05-19 04:00:00','219.219.120.72'),(38,100,'testdevice',10.6,389.52,'2020-05-18 16:00:00','219.219.120.72'),(39,100,'testdevice',48.1,420.87,'2020-05-18 04:00:00','219.219.120.72'),(40,100,'testdevice',28.7,435.77,'2020-05-17 16:00:00','219.219.120.72'),(41,100,'testdevice',59,416.25,'2020-05-17 04:00:00','219.219.120.72'),(42,100,'testdevice',29.1,273.94,'2020-05-16 16:00:00','219.219.120.72'),(43,100,'testdevice',28.5,120.96,'2020-05-16 04:00:00','219.219.120.72'),(44,100,'testdevice',55.2,282.96,'2020-05-15 16:00:00','219.219.120.72'),(45,100,'testdevice',10.5,51.94,'2020-05-15 04:00:00','219.219.120.72'),(46,100,'testdevice',6.8,410.82,'2020-05-14 16:00:00','219.219.120.72'),(47,100,'testdevice',2.6,398.25,'2020-05-14 04:00:00','219.219.120.72'),(48,100,'testdevice',52.4,258.82,'2020-05-13 16:00:00','219.219.120.72'),(49,100,'testdevice',14.3,99.36,'2020-05-13 04:00:00','219.219.120.72'),(50,100,'testdevice',34.3,220.33,'2020-05-12 16:00:00','219.219.120.72'),(51,100,'testdevice',8.6,303.58,'2020-05-12 04:00:00','219.219.120.72'),(52,100,'testdevice',0.1,356.9,'2020-05-11 16:00:00','219.219.120.72'),(53,100,'testdevice',34.7,373.77,'2020-05-11 04:00:00','219.219.120.72'),(54,100,'testdevice',53.1,298.13,'2020-05-10 16:00:00','219.219.120.72'),(55,100,'testdevice',41.5,369.36,'2020-05-10 04:00:00','219.219.120.72'),(56,100,'testdevice',48.3,452.42,'2020-05-09 16:00:00','219.219.120.72'),(57,100,'testdevice',56.9,154.01,'2020-05-09 04:00:00','219.219.120.72'),(58,100,'testdevice',19.7,412.8,'2020-05-08 16:00:00','219.219.120.72'),(59,100,'testdevice',47.8,101.95,'2020-05-08 04:00:00','219.219.120.72'),(60,100,'testdevice',59.8,271.35,'2020-05-07 16:00:00','219.219.120.72'),(62,101,'testdevice2',34.2,78.32,'2020-06-10 04:00:00','114.55.92.12'),(63,101,'testdevice2',40.5,345.01,'2020-06-09 16:00:00','114.55.92.12'),(64,102,'testdevice3',40.5,345.01,'2020-06-09 16:00:00','101.200.189.184'),(66,103,'testdevice4',40.5,345.01,'2020-06-09 16:00:00','47.100.220.26'),(67,104,'testdevice5',40.5,345.01,'2020-06-09 16:00:00','49.67.227.48'),(68,123,'devicex',23.3,345.67,'2020-06-10 04:00:00','49.78.3.2'),(69,123,'devicex',12.1,234.43,'2020-06-09 16:00:00','49.78.3.2');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-12 11:29:31
