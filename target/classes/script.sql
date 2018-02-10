-- Host: localhost    Database: sample
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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_no` varchar(5) NOT NULL,
  `dept_name` varchar(15) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('d1','research','Dallas'),('d10','село','київ'),('d2','accounting','Seattle'),('d3','marketing','Dallas'),('d5','BBB','Kyiv');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `emp_no` int(11) NOT NULL,
  `emp_fname` varchar(45) DEFAULT NULL,
  `emp_lname` varchar(45) DEFAULT NULL,
  `dept_no` varchar(5) NOT NULL,
  PRIMARY KEY (`emp_no`),
  KEY `fk_employee_department_idx` (`dept_no`),
  CONSTRAINT `fk_employee_department` FOREIGN KEY (`dept_no`) REFERENCES `department` (`dept_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2581,'Elke','Hansel','d2'),(9031,'Elsa','Bertoni','d2'),(10102,'Ann','Jones','d3'),(18316,'John','Barrimore','d1'),(25348,'Matthew','Smith','d3'),(28559,'Sybill','Moser','d1'),(29346,'James','James','d2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `project_no` varchar(10) NOT NULL,
  `project_name` varchar(45) DEFAULT NULL,
  `budget` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES ('p1','Apollo',120000),('p2','Gemini',95000),('p3','Mercury',186500);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `works_on`
--

DROP TABLE IF EXISTS `works_on`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `works_on` (
  `emp_no` int(11) NOT NULL,
  `project_no` varchar(10) NOT NULL,
  `job` varchar(45) DEFAULT NULL,
  `enter_date` date DEFAULT NULL,
  PRIMARY KEY (`emp_no`,`project_no`),
  KEY `fk_works_on_employee1_idx` (`emp_no`),
  KEY `fk_works_on_project1` (`project_no`),
  CONSTRAINT `fk_works_on_employee1` FOREIGN KEY (`emp_no`) REFERENCES `employee` (`emp_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_works_on_project1` FOREIGN KEY (`project_no`) REFERENCES `project` (`project_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works_on`
--

LOCK TABLES `works_on` WRITE;
/*!40000 ALTER TABLE `works_on` DISABLE KEYS */;
INSERT INTO `works_on` VALUES (2581,'p2','учитель','2013-12-31'),(2581,'p3','analyst','2007-10-15'),(9031,'p1','manager','2007-04-15'),(9031,'p3','clerk','2006-11-15'),(10102,'p1','analyst','2006-10-01'),(10102,'p3','manager','2008-01-01'),(18316,'p2',NULL,'2007-06-01'),(25348,'p2','clerk','2007-02-15'),(28559,'p1',NULL,'2007-08-01'),(28559,'p2','clerk','2008-02-01'),(29346,'p1','clerk','2007-01-04'),(29346,'p2',NULL,'2006-12-15');
/*!40000 ALTER TABLE `works_on` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sample'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-15 21:31:57
