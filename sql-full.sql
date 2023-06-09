-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlycongviec
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `ID_Mem` int DEFAULT NULL,
  `ID_CEO` int DEFAULT NULL,
  `ThoiHan` int DEFAULT NULL,
  `NgayKy` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Mem` (`ID_Mem`),
  KEY `ID_CEO` (`ID_CEO`),
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`ID_Mem`) REFERENCES `user` (`ID`),
  CONSTRAINT `contract_ibfk_2` FOREIGN KEY (`ID_CEO`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'Nhan vien',1,0,3,'2023-05-05'),(3,'Nhân viên',4,0,5,'2023-05-29'),(4,'Kí tới chết',5,0,3,'2023-05-31'),(5,'Hợp đồng làm việc',5,3,5,'2023-06-01'),(6,'Lao động',7,3,5,'2023-06-01'),(7,'LD2',8,3,5,'2023-06-01'),(8,'Ld4',9,3,3,'2023-06-01'),(9,'LQ',10,3,10,'2023-06-03'),(10,'Hợp đồng nhân viên',11,3,5,'2023-06-05'),(11,'Hợp đồng LD',12,3,10,'2023-06-05');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Đầu tư chứng khoáng','2023-05-28','2023-09-28'),(2,'Ki�m 1.5M','2023-05-27','2023-05-07'),(3,'D&#7921; �n','2023-05-29','2023-05-04'),(4,'Tiep theo','2023-05-31','2023-05-03'),(5,'Project 10k','2023-05-30','2023-05-03'),(6,'Kỉ niệm 2 ngày ','2023-05-31','2023-06-07'),(7,'Đầu tư chứng khoáng oke','2023-06-02','2021-04-02'),(8,'Quuangggg','2023-06-02','2023-06-03'),(9,'update theme','2023-06-03','2023-06-04'),(10,'Làm việc','2023-06-05','2023-06-10'),(11,'Project 111','2023-06-05','2023-06-10');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'PM'),(3,'Employee');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `TaskName` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Status` int DEFAULT NULL,
  `ID_Project` int DEFAULT NULL,
  `ID_User` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_User` (`ID_User`),
  KEY `ID_Project` (`ID_Project`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`ID_User`) REFERENCES `user` (`ID`),
  CONSTRAINT `task_ibfk_2` FOREIGN KEY (`ID_Project`) REFERENCES `project` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (-1,'Task 1',2,1,3),(1,'Làm modal',1,1,NULL),(3,'Làm DB',1,2,NULL),(4,'Code funtion',1,2,NULL),(5,'Code UI',3,2,9),(6,'Task 1',1,3,NULL),(7,'Task 2',1,3,NULL),(8,'Task 3',2,3,3),(9,'L�m modal',2,4,1),(10,'Gi day',1,4,4),(12,'Task 1',2,5,1),(13,'Làm modal',1,5,4),(15,'Code funtion',1,5,5),(16,'Task 1',1,6,5),(17,'Code funtion',1,6,5),(18,'làm chết',2,6,9),(19,'task mới',1,6,7),(20,'Ask 1',1,6,9),(21,'Ask2',1,6,8),(22,'Gưi abc',2,1,6),(23,'Tas k2w',1,1,7),(24,'Task 5',1,1,6),(25,'tiep théo',1,4,9),(26,'Làm DB',2,4,9),(28,'CRĐ',2,8,8),(29,'Update Theme',1,8,7),(30,'Tasaask 1',1,11,8),(31,'Làm modal',1,11,8),(32,'Code funtion',1,11,8);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Pass` varchar(255) DEFAULT NULL,
  `Ten` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `Tuoi` date DEFAULT NULL,
  `Role` varchar(255) DEFAULT NULL,
  `IsActive` bit(1) DEFAULT NULL,
  `ID_Role` int DEFAULT NULL,
  `ID_Project` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Role` (`ID_Role`),
  KEY `ID_Project` (`ID_Project`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`ID_Role`) REFERENCES `role` (`ID`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`ID_Project`) REFERENCES `project` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (0,'nv1','quang10217','Giam Doc','2023-05-05','1',_binary '',1,NULL),(1,'nv2','quang10217','Quang','2009-05-29','2',NULL,2,NULL),(3,'nv3','quang10217','Giam Doc','2023-05-05','1',_binary '',3,NULL),(4,'nv4','quang10217','Quang rách','2003-05-29','2',NULL,1,NULL),(5,'nv5','quang10217','Ki kI','2001-05-31','2',NULL,3,NULL),(6,'nv5','1','quangn1','2004-06-01','2',NULL,3,NULL),(7,'nv6','1','quangn5','2000-06-01','2',NULL,3,NULL),(8,'n7','1','quangn3','2001-06-01',NULL,_binary '',3,NULL),(9,'n9','1','quangnnn1','2019-06-01',NULL,_binary '',3,NULL),(10,'n10','1','NQ','2003-06-03',NULL,_binary '',3,NULL),(11,'n11','q','NVA','2006-06-05',NULL,_binary '',3,NULL),(12,'n12','1','NVB','2005-06-05',NULL,_binary '',3,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09 20:28:39
