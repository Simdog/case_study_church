-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: casestudydb
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DATE` varchar(255) DEFAULT NULL,
  `ISPRESENT` tinyint(1) DEFAULT '0',
  `MEMBER_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ATTENDANCE_MEMBER_ID` (`MEMBER_ID`),
  CONSTRAINT `FK_ATTENDANCE_MEMBER_ID` FOREIGN KEY (`MEMBER_ID`) REFERENCES `churchmember` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `churchmember`
--

DROP TABLE IF EXISTS `churchmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `churchmember` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `CHURCHROLE` int DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `phonenumber` varchar(50) NOT NULL,
  `USERINFO_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `email` (`email`),
  KEY `FK_churchmember_USERINFO_ID` (`USERINFO_ID`),
  CONSTRAINT `FK_churchmember_USERINFO_ID` FOREIGN KEY (`USERINFO_ID`) REFERENCES `churchmemberinfo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `churchmember`
--

LOCK TABLES `churchmember` WRITE;
/*!40000 ALTER TABLE `churchmember` DISABLE KEYS */;
INSERT INTO `churchmember` VALUES (1,4,'2021-04-05','test@maiil.com ','TestLast','7631231238',NULL),(2,4,'2021-04-05','test1@maiil.com ','TestLast1','7631231237',NULL),(3,4,'2021-04-05','test2@maiil.com ','TestLast2','7631231236',NULL),(4,4,'2021-04-05','test3@maiil.com ','TestLast3','7631231235',NULL),(5,4,'2021-04-05','test4@maiil.com ','TestLast4','7631231234',NULL),(6,4,'2021-04-05','test5@maiil.com ','TestLast5','7631231233',NULL),(7,4,'2021-04-05','test6@maiil.com ','TestLast6','7631231232',NULL),(8,4,'2021-04-05','test7@maiil.com ','TestLast7','7631231231',NULL),(9,4,'2021-04-09','newMail@mail.com','TestIndex','7631231267',NULL),(10,4,'2021-04-09','9@gmail.com','NewIndex9','7639996879',NULL);
/*!40000 ALTER TABLE `churchmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `churchmemberinfo`
--

DROP TABLE IF EXISTS `churchmemberinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `churchmemberinfo` (
  `ID` bigint NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `DATEJOINED` date DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `PHONENUMBER` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `churchmemberinfo`
--

LOCK TABLES `churchmemberinfo` WRITE;
/*!40000 ALTER TABLE `churchmemberinfo` DISABLE KEYS */;
INSERT INTO `churchmemberinfo` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2',NULL,'test1@maiil.com ','1','TestLast1','7631231237'),(3,'3',NULL,'test2@maiil.com ','3','TestLast2','7631231236'),(4,'',NULL,'test3@maiil.com ','4','TestLast3','7631231235'),(5,'',NULL,'test4@maiil.com ','5','TestLast4','7631231234'),(6,'',NULL,'test5@maiil.com ','6','TestLast5','7631231233'),(7,'',NULL,'test6@maiil.com ','7','TestLast6','7631231232'),(8,'8',NULL,'test7@maiil.com ','','TestLast7','7631231231'),(9,'9',NULL,'newMail@mail.com','','TestIndex','7631231267'),(10,'',NULL,'9@gmail.com','','NewIndex9','7639996879');
/*!40000 ALTER TABLE `churchmemberinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_tithe`
--

DROP TABLE IF EXISTS `member_tithe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_tithe` (
  `memberId` bigint NOT NULL,
  `titheId` bigint NOT NULL,
  PRIMARY KEY (`memberId`,`titheId`),
  KEY `FK_member_tithe_titheId` (`titheId`),
  CONSTRAINT `FK_member_tithe_memberId` FOREIGN KEY (`memberId`) REFERENCES `churchmember` (`ID`),
  CONSTRAINT `FK_member_tithe_titheId` FOREIGN KEY (`titheId`) REFERENCES `tithe` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_tithe`
--

LOCK TABLES `member_tithe` WRITE;
/*!40000 ALTER TABLE `member_tithe` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_tithe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tithe`
--

DROP TABLE IF EXISTS `tithe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tithe` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DATE` varchar(255) DEFAULT NULL,
  `TITHEAMOUNT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tithe`
--

LOCK TABLES `tithe` WRITE;
/*!40000 ALTER TABLE `tithe` DISABLE KEYS */;
/*!40000 ALTER TABLE `tithe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DATEJOINED` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `USERROLE` int DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-09 16:18:00
