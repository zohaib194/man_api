DROP TABLE users;
DROP DATABASE man_db;

CREATE DATABASE man_db;

CREATE TABLE `man_db`.`users` (
  `userid` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(40) NOT NULL,
  `lname` VARCHAR(40) NOT NULL,
  `bdate` DATE NOT NULL,
  `email` VARCHAR(80) NOT NULL UNIQUE,
  `mobile` VARCHAR(8) NULL,
  `pwd` VARCHAR(128) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC) VISIBLE);