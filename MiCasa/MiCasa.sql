-- MySQL dump 10.13  Distrib 5.1.50, for Win64 (unknown)
--
-- Host: localhost    Database: escuela
-- ------------------------------------------------------
-- Server version	5.1.50-community

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

DROP DATABASE IF EXISTS MiCasa;

CREATE DATABASE MiCasa;

use MiCasa;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `MiCasa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Proveedor` (
  id int(10)  primary key not null auto_increment,
  nombre varchar(100) NOT NULL,
  contacto varchar(30) DEFAULT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Juguete( 
	id int primary key not null auto_increment, 
	nombre varchar(100) not null, 
	precio double default 0, 
	categoria varchar(100) not null, 
	descripcion varchar(1000) not null,
	precio_proveedor double default 0,
	cantidad int default 0,
	id_proveedor int not null, 
	foreign key(id_proveedor)references Proveedor(id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Usuario(
	id int primary key not null auto_increment, 
	nombre varchar(100) not null, 
	contraseña varchar(50) not null,
	usuario varchar(50) not null
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Ventas(
	id int primary key not null auto_increment, 
	fecha DATE not null, 
	precio_total double default 0, 
	hora TIME not null
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Juguete_Venta(
	id_venta int not null,
	id_juguete int not null,
	total_juguetes int default 0, 
	precio_actual double default 0,
	foreign key(id_venta)references Ventas(id), 
	foreign key(id_juguete) references Juguete(id)
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Orden_Compra(
	id int primary key not null auto_increment, 
	total_de_juguetes int default 0, 
	fecha_solicitud DATE not null,
	fecha_respuesta DATE not null,
	costo_total double default 0,
	id_proveedor int not null,
	foreign key(id_proveedor) references Proveedor(id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

create table Orden_Juguete(
	id_juguete int not null, 
	id_orden int not null, 
	foreign key(id_juguete) references Juguete(id), 
	foreign key (id_orden) references Orden_Compra(id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP USER 'micasa'@'localhost';
flush privileges;

CREATE USER 'micasa'@'localhost' IDENTIFIED BY 'mipass';
GRANT SELECT, UPDATE, INSERT, DELETE ON MiCasa.* TO 'micasa'@'localhost';


-- Dump completed on 2011-08-27 21:26:29
