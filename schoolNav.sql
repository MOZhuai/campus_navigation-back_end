CREATE DATABASE  IF NOT EXISTS `ar_navigation` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ar_navigation`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: ar_navigation
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL COMMENT '楼号',
  `bname` varchar(45) DEFAULT NULL,
  `x` varchar(45) DEFAULT NULL COMMENT '地理坐标X',
  `y` varchar(45) DEFAULT NULL COMMENT '地理坐标y',
  `ssmap` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='校园的楼层号';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (2,2,'2S','120.360222','30.319441','c90a69bb-5af4-4b2e-a3d0-7a21bb346b21'),(7,NULL,'2N','120.360168','30.319978','3942e5bc-8819-4133-bb73-a45f49576928'),(21,NULL,'3','120.357125','30.319857','70468ef6-aaa3-485a-8718-3a8c8043d8b5'),(23,NULL,'2n225','120.359425','30.319713','87014166-9760-4cee-9674-cc629752534d'),(24,NULL,'2n225_2','120.359425','30.319713','295605b1-9ed8-45be-a761-0fabebbc7e00'),(25,NULL,'1ZL2S',NULL,NULL,'df5b1f7b-5200-416f-950e-6a0d6c15d627'),(26,NULL,'2n225_10',NULL,NULL,'1b0ac114-460d-4dde-b117-40223da679d8');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examinee`
--

DROP TABLE IF EXISTS `examinee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `examinee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` varchar(45) DEFAULT NULL COMMENT '考号',
  `name` varchar(45) DEFAULT NULL COMMENT '考生姓名',
  `gender` int(11) DEFAULT NULL COMMENT '0-女 1-男',
  `id_card` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='考生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examinee`
--

LOCK TABLES `examinee` WRITE;
/*!40000 ALTER TABLE `examinee` DISABLE KEYS */;
INSERT INTO `examinee` VALUES (1,'202104250000','陈哲',0,'330682199910045916'),(5,'202104250001','翠花',1,'210303198412082729'),(8,'202104250003','兰花',1,'210302198607160938'),(9,'202104250004','丁香花',0,'220303198605153610'),(10,'202104250005','玫瑰花',0,'232102196903151919'),(15,'202104250006','陈哲',0,'330682198572649527'),(17,'20210530001','小艾',0,'330682199810065912'),(18,'202105310001','小强',0,'330682199810059284');
/*!40000 ALTER TABLE `examinee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examinee_subject`
--

DROP TABLE IF EXISTS `examinee_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `examinee_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) DEFAULT NULL,
  `subject` int(11) DEFAULT NULL,
  `building` int(11) DEFAULT NULL,
  `room` int(11) DEFAULT NULL,
  `seat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `es_e_idx` (`eid`),
  KEY `es_sub_idx` (`subject`),
  KEY `es_b_idx` (`building`),
  CONSTRAINT `es_b` FOREIGN KEY (`building`) REFERENCES `building` (`id`),
  CONSTRAINT `es_e` FOREIGN KEY (`eid`) REFERENCES `examinee` (`id`),
  CONSTRAINT `es_sub` FOREIGN KEY (`subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='examinfo';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examinee_subject`
--

LOCK TABLES `examinee_subject` WRITE;
/*!40000 ALTER TABLE `examinee_subject` DISABLE KEYS */;
INSERT INTO `examinee_subject` VALUES (1,1,1,7,115,13),(2,1,2,7,118,4),(4,1,4,2,127,39),(5,5,1,7,115,34),(6,5,2,7,115,53),(7,5,3,7,115,23),(8,5,4,7,115,12),(10,10,2,7,118,46),(11,10,3,7,118,27),(15,9,1,7,115,15),(18,9,2,7,115,45),(19,1,5,7,118,23),(26,18,12,7,115,19);
/*!40000 ALTER TABLE `examinee_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `key_point`
--

DROP TABLE IF EXISTS `key_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `key_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(45) DEFAULT NULL,
  `x` varchar(45) DEFAULT NULL,
  `y` varchar(45) DEFAULT NULL,
  `z` varchar(45) DEFAULT NULL,
  `ptype` int(11) DEFAULT NULL COMMENT '0-终点\n1-途径点',
  `pbuilding` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `p_building_idx` (`pbuilding`),
  CONSTRAINT `p_building` FOREIGN KEY (`pbuilding`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `key_point`
--

LOCK TABLES `key_point` WRITE;
/*!40000 ALTER TABLE `key_point` DISABLE KEYS */;
INSERT INTO `key_point` VALUES (2,'127','2','2','2',0,2),(19,'公告栏','0.7302723','-1.526486','0.4963507',1,7),(20,'kp1','-9.013543','-2.041447','-6.106378',1,7),(21,'kp2','-11.7909','-2.082807','-1.392991',1,7),(22,'kp3','-6.02051','-1.374412','1.884418',1,7),(23,'kp4','-10.09816','-1.036068','6.660181',1,7),(24,'115','-12.15681','-0.9375645','5.014697',0,7),(25,'kp5','-13.77096','-0.9895743','11.73985',1,7),(26,'118','-12.59314','-0.9968997','12.45829',0,7),(27,'kp6','-18.53302','-0.9821324','20.10516',1,7),(28,'119','-22.17204','-0.8529748','19.87388',0,7),(115,'kp1','-2.080126','-2.028682','0.9391208',1,21),(116,'126','1.279197','-1.687025','15.10277',0,21),(118,'kp3','0.1131139','-2.372953','16.0381',1,21),(119,'kp2','-6.181124','-1.40818','3.29999',1,21),(122,'225','0.4467272','-1.475667','0.8159978',0,24),(123,'223','-8.986758','-1.477087','-3.47815',0,24),(125,'p2','-2.02958','-1.511471','0.8060131',1,24),(126,'p1','-8.008862','-5.616903','-3.128445',1,25),(127,'p2','-7.184672','-5.518763','0.3041358',1,25),(128,'p3','-5.786226','-3.620959','4.586756',1,25),(129,'p4','-3.266857','-3.581476','3.619843',1,25),(130,'p5','-6.590738','-1.674124','-1.456879',1,25),(131,'219','-3.346713','-1.64324','-3.979791',0,25);
/*!40000 ALTER TABLE `key_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `road`
--

DROP TABLE IF EXISTS `road`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `road` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_pk` int(11) DEFAULT NULL,
  `end_pk` int(11) DEFAULT NULL,
  `rbuilding` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `r_building_idx` (`rbuilding`),
  CONSTRAINT `r_building` FOREIGN KEY (`rbuilding`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `road`
--

LOCK TABLES `road` WRITE;
/*!40000 ALTER TABLE `road` DISABLE KEYS */;
INSERT INTO `road` VALUES (21,19,20,7),(22,21,20,7),(23,21,22,7),(24,23,22,7),(25,23,24,7),(26,23,25,7),(27,26,25,7),(28,27,25,7),(29,27,28,7),(108,118,116,21),(109,115,119,21),(117,125,122,24),(118,125,123,24),(119,126,127,25),(120,128,127,25),(121,128,129,25),(122,130,129,25),(125,131,130,25);
/*!40000 ALTER TABLE `road` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(45) DEFAULT NULL COMMENT '科目号',
  `name` varchar(45) DEFAULT NULL COMMENT '科目名称',
  `start_time` datetime DEFAULT NULL COMMENT '考试开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '考试结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='大类里包含的科目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'101','会计','2021-05-11 08:00:00','2021-05-11 11:00:00'),(2,'201','审计','2021-05-11 14:00:00','2021-05-11 17:00:00'),(3,'408','财务成本管理','2021-05-12 08:00:00','2021-05-12 11:00:00'),(4,'301','经济法','2021-05-12 14:00:00','2021-05-12 17:00:00'),(5,'441','税法','2021-05-12 08:00:00','2021-05-12 11:00:00'),(12,'771','初级考初级会计实务','2021-06-03 14:00:00','2021-06-03 17:00:00');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ar_navigation'
--

--
-- Dumping routines for database 'ar_navigation'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-06  4:11:44
