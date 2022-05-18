CREATE DATABASE  IF NOT EXISTS `2022T4` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `2022T4`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 212.71.250.11    Database: 2022T4
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

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
-- Table structure for table `log_entity`
--

DROP TABLE IF EXISTS `log_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_entity` (
  `id` bigint NOT NULL,
  `giorno` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `timezone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mese` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `orario` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `anno` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `dispositivo` text COLLATE utf8_unicode_ci NOT NULL,
  `autentificato` text COLLATE utf8_unicode_ci,
  `qunatita_trasmissione` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ip_cliente` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `identificativo` text COLLATE utf8_unicode_ci,
  `posizione` text COLLATE utf8_unicode_ci,
  `log_completo` text COLLATE utf8_unicode_ci,
  `sito_referente` text COLLATE utf8_unicode_ci,
  `richiesta` text COLLATE utf8_unicode_ci NOT NULL,
  `codice_risposta` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `valutazione` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_entity`
--

LOCK TABLES `log_entity` WRITE;
/*!40000 ALTER TABLE `log_entity` DISABLE KEYS */;
INSERT INTO `log_entity` VALUES (3829,'31','+0000','Aug','10:57:35','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36','-','36184','35.233.102.46','-',NULL,'35.233.102.46 - - [31/Aug/2021:10:57:35 +0000] \"GET /blogs/news/hubspot-per-trovare-clienti-nel-2020 HTTP/1.1\" 200 36184 \"https://shop.gnet.it/products/automatismi-workflow?pr_prod_strat=collection_fallback&pr_rec_pid=6873165004975&pr_ref_pid=6873176801455&pr_seq=uniform\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"','https://shop.gnet.it/products/automatismi-workflow?pr_prod_strat=collection_fallback&pr_rec_pid=6873165004975&pr_ref_pid=6873176801455&pr_seq=uniform','/blogs/news/hubspot-per-trovare-clienti-nel-2020','200',NULL),(3828,'31','+0000','Aug','10:55:16','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36','-','30395','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:55:16 +0000] \"GET /blogs/news/hubspot-per-trovare-clienti-nel-2020 HTTP/1.1\" 200 30395 \"https://shop.gnet.it/pages/chi-siamo\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"','https://shop.gnet.it/pages/chi-siamo','/blogs/news/hubspot-per-trovare-clienti-nel-2020','200',NULL),(3827,'31','+0000','Aug','10:55:14','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36','-','28082','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:55:14 +0000] \"GET /pages/chi-siamo HTTP/1.1\" 200 28082 \"https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"','https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020','/pages/chi-siamo','200',NULL),(3826,'31','+0000','Aug','10:55:14','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36','-','31362','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:55:14 +0000] \"GET /blogs/news/hubspot-per-trovare-clienti-nel-2020 HTTP/1.1\" 200 31362 \"https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"','https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020','/blogs/news/hubspot-per-trovare-clienti-nel-2020','200',NULL),(3825,'31','+0000','Aug','10:54:12','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:92.0) Gecko/20100101 Firefox/92.0','-','28770','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:54:12 +0000] \"GET /pages/chi-siamo HTTP/1.1\" 200 28770 \"https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:92.0) Gecko/20100101 Firefox/92.0\"','https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020','/pages/chi-siamo','200',NULL),(3823,'31','+0000','Aug','10:53:41','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:92.0) Gecko/20100101 Firefox/92.0','-','35509','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:53:41 +0000] \"GET /collections/all HTTP/1.1\" 200 35509 \"https://shop.gnet.it/\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:92.0) Gecko/20100101 Firefox/92.0\"','https://shop.gnet.it/','/collections/all','200',NULL),(3824,'31','+0000','Aug','10:53:52','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:92.0) Gecko/20100101 Firefox/92.0','-','31266','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:53:52 +0000] \"GET /blogs/news/hubspot-per-trovare-clienti-nel-2020 HTTP/1.1\" 200 31266 \"https://shop.gnet.it/collections/all\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:92.0) Gecko/20100101 Firefox/92.0\"','https://shop.gnet.it/collections/all','/blogs/news/hubspot-per-trovare-clienti-nel-2020','200',NULL),(3821,'31','+0000','Aug','10:52:52','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36','-','28016','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:52:52 +0000] \"GET /pages/chi-siamo HTTP/1.1\" 200 28016 \"https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"','https://shop.gnet.it/blogs/news/hubspot-per-trovare-clienti-nel-2020','/pages/chi-siamo','200',NULL),(3822,'31','+0000','Aug','10:52:55','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36','-','30645','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:52:55 +0000] \"GET /blogs/news/hubspot-per-trovare-clienti-nel-2020 HTTP/1.1\" 200 30645 \"https://shop.gnet.it/pages/chi-siamo\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"','https://shop.gnet.it/pages/chi-siamo','/blogs/news/hubspot-per-trovare-clienti-nel-2020','200',NULL),(3820,'31','+0000','Aug','10:52:51','2021','Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36','-','30809','93.147.139.239','-',NULL,'93.147.139.239 - - [31/Aug/2021:10:52:51 +0000] \"GET /blogs/news/hubspot-per-trovare-clienti-nel-2020 HTTP/1.1\" 200 30809 \"https://shop.gnet.it/pages/chi-siamo\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\"','https://shop.gnet.it/pages/chi-siamo','/blogs/news/hubspot-per-trovare-clienti-nel-2020','200',NULL);
/*!40000 ALTER TABLE `log_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-06 18:07:01
