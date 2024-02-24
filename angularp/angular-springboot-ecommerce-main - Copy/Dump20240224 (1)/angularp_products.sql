-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: angularp
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Decor','https://homeandbeyond.com.bd/cdn/shop/files/22380437702_1551949274_720x.jpg?v=1708343250','Clock',5890.00),(2,'Pillow cover','https://homeandbeyond.com.bd/cdn/shop/files/c23_25ea9e30-cae6-4454-98ea-dd8a1fad0ad9_720x.jpg?v=1688725266','Cover',890.00),(3,'Bath Decor','https://homeandbeyond.com.bd/cdn/shop/products/c3_75c24b07-cc0c-43d1-832b-9279f2e9b0b2_720x.jpg?v=1623657382','Dispenser',1190.00),(4,'Decor','https://homeandbeyond.com.bd/cdn/shop/files/c5_4c676743-6cae-4fcc-a2c2-0b1571ef3b33_720x.jpg?v=1708341588','Lamp',5590.00),(5,'Bath decor','https://homeandbeyond.com.bd/cdn/shop/files/O1CN01qLZ7pN1LVHJQUkFbu__2214499681304-0-cib_720x.jpg?v=1700305291','Dispenser',1190.00),(6,'Kitchen Essential','https://homeandbeyond.com.bd/cdn/shop/products/c1_ef232e58-7312-4e80-aa0b-a6b2facb16f3_720x.jpg?v=1600877435','Utensil',6990.00),(7,'Bath Decor','https://homeandbeyond.com.bd/cdn/shop/products/c14_b234d1a0-7493-4279-88de-41b5d6464a68_720x.jpg?v=1651916513','Towel',2990.00),(8,'Decor','https://homeandbeyond.com.bd/cdn/shop/products/c15_b052073a-f488-48ba-98b4-14f9841db5a4_720x.jpg?v=1625473870','Tissue Box',1590.00),(9,'Pillow cover','https://homeandbeyond.com.bd/cdn/shop/products/c2_83e68a18-bc96-4a24-afc4-25fd0c3613ff_712x.jpg?v=1630762684','Cover',1990.00),(10,'Fragrance','https://homeandbeyond.com.bd/cdn/shop/products/c3_e81dd5fb-4eab-4c06-a6f8-1e4d7f47c104_720x.jpg?v=1624634054','Fragrance',1790.00),(11,'Dining Decor','https://homeandbeyond.com.bd/cdn/shop/products/c21_720x.jpg?v=1650731237','Table cover',4590.00),(12,'Decor','https://homeandbeyond.com.bd/cdn/shop/products/c5_0679d929-74fa-4021-aa08-77a0a2b25e9d_720x.jpg?v=1641224858','Blanket',5890.00),(13,'Dining Decor','https://homeandbeyond.com.bd/cdn/shop/products/c10_45e7f982-d4c0-42b1-8538-884b50f8d4d2_720x.jpg?v=1651905655','Plate',1000.00),(14,'Gift','https://homeandbeyond.com.bd/cdn/shop/products/c31_5223338b-9b93-41f1-8ff0-ad07c780ba46_720x.jpg?v=1664634552','Mug',1350.00),(15,'Dining Decor','https://homeandbeyond.com.bd/cdn/shop/products/12703236383_1352325629_720x.jpg?v=1617181075','Tray',3990.00),(16,'Decor','https://homeandbeyond.com.bd/cdn/shop/products/O1CN010ct22J1Ujm8V1yDxk__857632554_720x.jpg?v=1650531460','Lantern',1990.00),(17,'Home Essential','https://homeandbeyond.com.bd/cdn/shop/products/9174659604_1876827311_720x.jpg?v=1597135305','Storage',2990.00),(18,'Decor','https://homeandbeyond.com.bd/cdn/shop/products/c3_df7d47d9-425b-40e6-9e75-16be395e142d_720x.jpg?v=1664634239','Rug',3590.00),(19,'Kitchen Essential','https://homeandbeyond.com.bd/cdn/shop/products/c5_c87784ee-4be7-4aab-a5a2-a80b0f7d9f3a_720x.jpg?v=1639379872','Hand Mitten',790.00);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-24 12:46:49
