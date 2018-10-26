-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: centrocultural
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `condicion`
--

DROP TABLE IF EXISTS `condicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `condicion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `condicion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condicion`
--

LOCK TABLES `condicion` WRITE;
/*!40000 ALTER TABLE `condicion` DISABLE KEYS */;
INSERT INTO `condicion` VALUES (1,'Efectivo'),(2,'Condicional');
/*!40000 ALTER TABLE `condicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `id_profesor` int(11) DEFAULT NULL,
  `cupos_disponibles` int(11) DEFAULT NULL,
  `id_tematica` int(11) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `carga_horaria` int(11) DEFAULT NULL,
  `aula` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_curso`),
  KEY `FKc0py45tr8c0qw9peo9tylgu0j` (`id_profesor`),
  KEY `FKs5trcy6ge1vugrl8ko67nvxbt` (`id_tematica`),
  CONSTRAINT `FKc0py45tr8c0qw9peo9tylgu0j` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id`),
  CONSTRAINT `FKs5trcy6ge1vugrl8ko67nvxbt` FOREIGN KEY (`id_tematica`) REFERENCES `tematica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Taller Literario',1,8,2,6,5,2),(2,'Literatura Moderna',2,10,2,8,6,5),(3,'Pintura Acuarela',3,14,3,10,6,8),(4,'Pintura Abstracta',4,10,3,12,5,1),(5,'Porcelana Fria',5,7,1,7,3,12),(6,'Artesanias En Madera',5,7,1,20,3,15),(7,'Musica Clasica',6,9,4,12,4,10),(8,'Instrumentos Musicales',6,10,4,10,6,10);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripcion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inscripcion` datetime(6) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `id_participante` int(11) DEFAULT NULL,
  `id_condicion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6sw931ij561k2fq5sx4xonmlr` (`id_curso`),
  KEY `FKdp6hvh7238ha13a48i7bepnxi` (`id_participante`),
  KEY `FKh3qxumd7r85wlaaoxp460fxv2` (`id_condicion`),
  CONSTRAINT `FK6sw931ij561k2fq5sx4xonmlr` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`),
  CONSTRAINT `FKdp6hvh7238ha13a48i7bepnxi` FOREIGN KEY (`id_participante`) REFERENCES `participante` (`id`),
  CONSTRAINT `FKh3qxumd7r85wlaaoxp460fxv2` FOREIGN KEY (`id_condicion`) REFERENCES `condicion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (1,'2018-10-25 14:56:08.383000',5,1,1),(2,'2018-10-25 14:56:28.157000',7,1,1),(3,'2018-10-25 14:56:36.761000',3,1,1);
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fechaNac` datetime(6) DEFAULT NULL,
  `cantCursosAnotado` int(11) DEFAULT NULL,
  `padre_tutor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (1,'Rotatori','Gisela',2236489451,'gisela@gmail.com','1987-11-21 14:55:58.938000',3,''),(2,'Garcia','Melina',2236364351,'melina@gmail.com','1990-05-13 15:01:38.311000',0,''),(3,'Lopez','German',2235478963,'german@gmail.com','2002-01-01 15:04:18.087000',0,'Pedro Lopez');
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sueldo` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (1,'Lopez','Roberto',156365987,'roberto@gmail.com',1200.55),(2,'Garcia','Pedro',154879654,'garcia@gmail.com',1351.65),(3,'Gomez','Veronica',155874963,'veronica@gmail.com',1253.48),(4,'Labrador','Rosa',158746321,'labradorrosa@gmail.com',1320.15),(5,'Gimenez','Sofia',156987412,'sofigimenez@gmail.com',1310.58),(6,'Martinez','German',154236987,'mgerman@gmail.com',1225.36);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tematica`
--

DROP TABLE IF EXISTS `tematica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tematica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tematica`
--

LOCK TABLES `tematica` WRITE;
/*!40000 ALTER TABLE `tematica` DISABLE KEYS */;
INSERT INTO `tematica` VALUES (1,'Manualidades'),(2,'Literatura'),(3,'Dibujo'),(4,'Musica');
/*!40000 ALTER TABLE `tematica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-26  1:23:27
