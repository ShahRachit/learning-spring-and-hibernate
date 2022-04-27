CREATE DATABASE `bookmytickets`;
use `bookmytickets`;

--
-- Table stucture for user table
--
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `role` varchar(32) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `EMAIL_UINIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table stucture for flight table
--
CREATE TABLE `flight` (
  `id` int(11) NOT NULL,
  `flight_num` int(11) NOT NULL ,
  `capacity` int (11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `FLIGHT_NUM_UNIQUE` (`flight_num`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table stucture for route table
--
CREATE TABLE `route` (
  `id` int(11) NOT NULL auto_increment,
  `source_city` varchar(25) DEFAULT NULL,
  `destination_city` varchar(25) DEFAULT NULL,
  `route_code` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table stucture for air_fare table
--
CREATE TABLE `air_fare` (
  `id` int(11) NOT NULL auto_increment,
  `route_id` int(11) NOT NULL ,
  `fare` int(11) NOT NULL ,
  PRIMARY KEY (`id`),
  
  KEY `FK_ROUTE_idx` (`route_id`),
  
  CONSTRAINT `FK_ROUTE` 
  FOREIGN KEY (`route_id`) 
  REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table stucture for flight schedule table
--
CREATE TABLE `flight_schedule` (
  `id` int(11) NOT NULL auto_increment,
  `flight_id` int(11) NOT NULL ,
  `flight_date` date NOT NULL,
  `departure_time` time NOT NULL,
  `arrival_time` time NOT NULL,
  `net_fare` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_FLIGHT_idx` (`flight_id`),
  
  CONSTRAINT `FK_FLIGHT_ID` 
  FOREIGN KEY (`flight_id`) 
  REFERENCES `flight` (`id`),
  
  KEY `FK_net_fare_idx` (`net_fare`),
  
  CONSTRAINT `FK_FARE` 
  FOREIGN KEY (`air_fare_fare`) 
  REFERENCES `air_fare` (`fare`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table stucture for booking table
--
CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_of_passengers` int(11) NOT NULL,
  `booking_date` datetime NOT NULL,
  `doj` date NOT NULL,
  `booking_last_modified` datetime NOT NULL,
  `booking_last_modified_by` varchar(45)  NOT NULL,
  `user_id` int(11) NOT NULL,
  `flight_schedule_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_USER_idx` (`user_id`),
  
  CONSTRAINT `FK_USER` 
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) ,
  
  KEY `FK_FLIGHT_SCHEDULE_idx` (`flight_schedule_id`),
  
  CONSTRAINT `FK_FLIGHT_SCHEDULE` 
  FOREIGN KEY (`flight_schedule_id`) 
  REFERENCES `flight_schedule` (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Table stucture for passenger table
--
CREATE TABLE `passenger` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `passenger_name` varchar(45) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  `seat_num` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  
  KEY `FK_BOOKING_idx` (`booking_id`),
  
  CONSTRAINT `FK_BOOKING` 
  FOREIGN KEY (`booking_id`) 
  REFERENCES `booking` (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
