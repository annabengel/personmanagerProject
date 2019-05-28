-- -----------------------------------------------------
-- Delete, Create, and Use Schema prs
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS person_manager;
CREATE SCHEMA IF NOT EXISTS person_manager;
USE person_manager;

-- -----------------------------------------------------
-- Table customer
-- -----------------------------------------------------
CREATE TABLE customer (
  ID				INT 		NOT NULL 	AUTO_INCREMENT	PRIMARY KEY,
  FirstName			VARCHAR(20) NOT NULL,
  LastName			VARCHAR(20) NOT NULL,
  CustomerNumber 	VARCHAR(20) NOT NULL
);

-- -----------------------------------------------------
-- Table employee
-- -----------------------------------------------------
CREATE TABLE employee (
  ID				INT 		NOT NULL 	AUTO_INCREMENT	PRIMARY KEY,
  FirstName			VARCHAR(20) NOT NULL,
  LastName			VARCHAR(20) NOT NULL,
  SSN			 	VARCHAR(11) NOT NULL
);

-- -----------------------------------------------------
-- Create a user and grant privileges to that user
-- -----------------------------------------------------
CREATE USER IF NOT EXISTS person_manager_user@localhost IDENTIFIED BY 'sesame';
GRANT SELECT, INSERT, DELETE, UPDATE ON person_manager.* TO person_manager_user@localhost;