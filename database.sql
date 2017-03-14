CREATE DATABASE  IF NOT EXISTS `prosjekt` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_danish_ci */;
USE `prosjekt`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: prosjekt
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
-- Table structure for table `øvelse`
--

DROP TABLE IF EXISTS `øvelse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `øvelse` (
  `øvelse_ID` int(11) NOT NULL AUTO_INCREMENT,
  `navn` varchar(25) COLLATE latin1_danish_ci NOT NULL,
  `beskrivelse` varchar(255) COLLATE latin1_danish_ci NOT NULL,
  PRIMARY KEY (`øvelse_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `øvelse`
--

LOCK TABLES `øvelse` WRITE;
/*!40000 ALTER TABLE `øvelse` DISABLE KEYS */;
/*!40000 ALTER TABLE `øvelse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `øvelse_kondisjon`
--

DROP TABLE IF EXISTS `øvelse_kondisjon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `øvelse_kondisjon` (
  `kondisjons_ID` int(11) NOT NULL,
  `lengde` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`kondisjons_ID`),
  CONSTRAINT `kondisjon_øvelse_øvelse_ID_fk` FOREIGN KEY (`kondisjons_ID`) REFERENCES `øvelse` (`øvelse_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `øvelse_kondisjon`
--

LOCK TABLES `øvelse_kondisjon` WRITE;
/*!40000 ALTER TABLE `øvelse_kondisjon` DISABLE KEYS */;
/*!40000 ALTER TABLE `øvelse_kondisjon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `øvelse_styrke`
--

DROP TABLE IF EXISTS `øvelse_styrke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `øvelse_styrke` (
  `styrke_ID` int(11) NOT NULL,
  `repetisjoner` tinyint(4) NOT NULL,
  `sett` tinyint(4) NOT NULL,
  PRIMARY KEY (`styrke_ID`),
  CONSTRAINT `øvelse_styrke_øvelse_øvelse_ID_fk` FOREIGN KEY (`styrke_ID`) REFERENCES `øvelse` (`øvelse_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `øvelse_styrke`
--

LOCK TABLES `øvelse_styrke` WRITE;
/*!40000 ALTER TABLE `øvelse_styrke` DISABLE KEYS */;
/*!40000 ALTER TABLE `øvelse_styrke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `øvelseharkategori`
--

DROP TABLE IF EXISTS `øvelseharkategori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `øvelseharkategori` (
  `øvelse_ID` int(11) NOT NULL,
  `kategori_ID` int(11) NOT NULL,
  PRIMARY KEY (`øvelse_ID`,`kategori_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `øvelseharkategori`
--

LOCK TABLES `øvelseharkategori` WRITE;
/*!40000 ALTER TABLE `øvelseharkategori` DISABLE KEYS */;
/*!40000 ALTER TABLE `øvelseharkategori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `innendørs`
--

DROP TABLE IF EXISTS `innendørs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `innendørs` (
  `treningsøkt_ID` int(11) NOT NULL,
  `luft` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  `ventilasjon` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  `antall tilskuere` int(11) NOT NULL,
  PRIMARY KEY (`treningsøkt_ID`),
  CONSTRAINT `innendørs_treningsøkt_treningsøkt_ID_fk` FOREIGN KEY (`treningsøkt_ID`) REFERENCES `treningsøkt` (`treningsøkt_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `innendørs`
--

LOCK TABLES `innendørs` WRITE;
/*!40000 ALTER TABLE `innendørs` DISABLE KEYS */;
/*!40000 ALTER TABLE `innendørs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategori`
--

DROP TABLE IF EXISTS `kategori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategori` (
  `kategori_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`kategori_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategori`
--

LOCK TABLES `kategori` WRITE;
/*!40000 ALTER TABLE `kategori` DISABLE KEYS */;
/*!40000 ALTER TABLE `kategori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kategori_styrke`
--

DROP TABLE IF EXISTS `kategori_styrke`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategori_styrke` (
  `kroppsdel_ID` int(11) NOT NULL,
  `kroppsdel` varchar(50) COLLATE latin1_danish_ci DEFAULT NULL,
  PRIMARY KEY (`kroppsdel_ID`),
  CONSTRAINT `kategori_styrke_kategori_kategori_ID_fk` FOREIGN KEY (`kroppsdel_ID`) REFERENCES `kategori` (`kategori_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategori_styrke`
--

LOCK TABLES `kategori_styrke` WRITE;
/*!40000 ALTER TABLE `kategori_styrke` DISABLE KEYS */;
/*!40000 ALTER TABLE `kategori_styrke` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kondisjonsøktharøvelse`
--

DROP TABLE IF EXISTS `kondisjonsøktharøvelse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kondisjonsøktharøvelse` (
  `resultat` time DEFAULT NULL,
  `kondisjonsøkt_ID` int(11) NOT NULL,
  `kondisjonøvelse_ID` int(11) NOT NULL,
  PRIMARY KEY (`kondisjonsøkt_ID`,`kondisjonøvelse_ID`),
  KEY `kondisjonsøktharøvelse_øvelse_kondisjon_kondisjons_ID_fk` (`kondisjonøvelse_ID`),
  CONSTRAINT `kondisjonsøktharøvelse_treningsøkt_treningsøkt_ID_fk` FOREIGN KEY (`kondisjonsøkt_ID`) REFERENCES `treningsøkt` (`treningsøkt_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `kondisjonsøktharøvelse_øvelse_kondisjon_kondisjons_ID_fk` FOREIGN KEY (`kondisjonøvelse_ID`) REFERENCES `øvelse_kondisjon` (`kondisjons_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kondisjonsøktharøvelse`
--

LOCK TABLES `kondisjonsøktharøvelse` WRITE;
/*!40000 ALTER TABLE `kondisjonsøktharøvelse` DISABLE KEYS */;
/*!40000 ALTER TABLE `kondisjonsøktharøvelse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lagdutfra`
--

DROP TABLE IF EXISTS `lagdutfra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lagdutfra` (
  `treningsøkt_ID` int(11) NOT NULL,
  `mal_ID` int(11) NOT NULL,
  PRIMARY KEY (`mal_ID`,`treningsøkt_ID`),
  KEY `lagdutfra_treningsøkt_treningsøkt_ID_fk` (`treningsøkt_ID`),
  CONSTRAINT `lagdutfra_treningsøkt_treningsøkt_ID_fk` FOREIGN KEY (`treningsøkt_ID`) REFERENCES `treningsøkt` (`treningsøkt_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `lagdutfra_treningsøktmal_mal_ID_fk` FOREIGN KEY (`mal_ID`) REFERENCES `treningsøktmal` (`mal_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lagdutfra`
--

LOCK TABLES `lagdutfra` WRITE;
/*!40000 ALTER TABLE `lagdutfra` DISABLE KEYS */;
/*!40000 ALTER TABLE `lagdutfra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `malharøvelse`
--

DROP TABLE IF EXISTS `malharøvelse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `malharøvelse` (
  `mal_ID` int(11) NOT NULL,
  `maløvelse_ID` int(11) NOT NULL,
  PRIMARY KEY (`mal_ID`,`maløvelse_ID`),
  KEY `malharøvelse_øvelse_øvelse_ID_fk` (`maløvelse_ID`),
  CONSTRAINT `malharøvelse_treningsøktmal_mal_ID_fk` FOREIGN KEY (`mal_ID`) REFERENCES `treningsøktmal` (`mal_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `malharøvelse_øvelse_øvelse_ID_fk` FOREIGN KEY (`maløvelse_ID`) REFERENCES `øvelse` (`øvelse_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `malharøvelse`
--

LOCK TABLES `malharøvelse` WRITE;
/*!40000 ALTER TABLE `malharøvelse` DISABLE KEYS */;
/*!40000 ALTER TABLE `malharøvelse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notat`
--

DROP TABLE IF EXISTS `notat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notat` (
  `treningstips` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  `treningsformål` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  `treningsøkt_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`treningsøkt_ID`),
  CONSTRAINT `notat_treningsøkt_treningsøkt_ID_fk` FOREIGN KEY (`treningsøkt_ID`) REFERENCES `treningsøkt` (`treningsøkt_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notat`
--

LOCK TABLES `notat` WRITE;
/*!40000 ALTER TABLE `notat` DISABLE KEYS */;
/*!40000 ALTER TABLE `notat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puls- og gps-informasjon`
--

DROP TABLE IF EXISTS `puls- og gps-informasjon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puls- og gps-informasjon` (
  `treningsøkt_ID` int(11) NOT NULL,
  `puls` tinyint(4) NOT NULL,
  `lengdegrad` decimal(11,8) DEFAULT NULL,
  `breddegrad` decimal(10,8) NOT NULL,
  `meter over havet` tinyint(4) NOT NULL,
  `tid` time NOT NULL,
  PRIMARY KEY (`treningsøkt_ID`),
  CONSTRAINT `puls- og GPS-informasjon_treningsøkt_treningsøkt_ID_fk` FOREIGN KEY (`treningsøkt_ID`) REFERENCES `treningsøkt` (`treningsøkt_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puls- og gps-informasjon`
--

LOCK TABLES `puls- og gps-informasjon` WRITE;
/*!40000 ALTER TABLE `puls- og gps-informasjon` DISABLE KEYS */;
/*!40000 ALTER TABLE `puls- og gps-informasjon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `styrkeøktharøvelse`
--

DROP TABLE IF EXISTS `styrkeøktharøvelse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `styrkeøktharøvelse` (
  `styrkeøkt` int(11) NOT NULL,
  `styrkeøvelse` int(11) NOT NULL,
  `resultat` tinyint(4) NOT NULL,
  PRIMARY KEY (`styrkeøkt`,`styrkeøvelse`),
  CONSTRAINT `styrkeøktharøvelse_treningsøkt_treningsøkt_ID_fk` FOREIGN KEY (`styrkeøkt`) REFERENCES `treningsøkt` (`treningsøkt_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `styrkeøktharøvelse_øvelse_styrke_styrke_ID_fk` FOREIGN KEY (`styrkeøkt`) REFERENCES `øvelse_styrke` (`styrke_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `styrkeøktharøvelse`
--

LOCK TABLES `styrkeøktharøvelse` WRITE;
/*!40000 ALTER TABLE `styrkeøktharøvelse` DISABLE KEYS */;
/*!40000 ALTER TABLE `styrkeøktharøvelse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treningsøkt`
--

DROP TABLE IF EXISTS `treningsøkt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treningsøkt` (
  `treningsøkt_ID` int(11) NOT NULL AUTO_INCREMENT,
  `dato` date NOT NULL,
  `tidspunkt` time NOT NULL,
  `varighet` int(11) NOT NULL,
  `dagsform` int(11) NOT NULL,
  PRIMARY KEY (`treningsøkt_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treningsøkt`
--

LOCK TABLES `treningsøkt` WRITE;
/*!40000 ALTER TABLE `treningsøkt` DISABLE KEYS */;
/*!40000 ALTER TABLE `treningsøkt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treningsøktmal`
--

DROP TABLE IF EXISTS `treningsøktmal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treningsøktmal` (
  `mal_ID` int(11) NOT NULL AUTO_INCREMENT,
  `navn` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  PRIMARY KEY (`mal_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treningsøktmal`
--

LOCK TABLES `treningsøktmal` WRITE;
/*!40000 ALTER TABLE `treningsøktmal` DISABLE KEYS */;
/*!40000 ALTER TABLE `treningsøktmal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utendørs`
--

DROP TABLE IF EXISTS `utendørs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utendørs` (
  `treningøkt_ID` int(11) NOT NULL,
  `temperatur` tinyint(4) NOT NULL,
  `værtype` varchar(20) COLLATE latin1_danish_ci NOT NULL,
  PRIMARY KEY (`treningøkt_ID`),
  CONSTRAINT `utendørs_treningsøkt_treningsøkt_ID_fk` FOREIGN KEY (`treningøkt_ID`) REFERENCES `treningsøkt` (`treningsøkt_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utendørs`
--

LOCK TABLES `utendørs` WRITE;
/*!40000 ALTER TABLE `utendørs` DISABLE KEYS */;
/*!40000 ALTER TABLE `utendørs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'prosjekt'
--

--
-- Dumping routines for database 'prosjekt'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-14 20:15:55
