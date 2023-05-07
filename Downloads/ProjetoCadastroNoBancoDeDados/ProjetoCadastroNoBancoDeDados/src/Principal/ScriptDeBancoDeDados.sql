CREATE SCHEMA `bancoabc` ;

USE `bancoabc` ;

CREATE TABLE `conta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `saldo` double NOT NULL,
  `limite` double NOT NULL,
  PRIMARY KEY (`id`)
);

