-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`sex`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sex` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `sex` ENUM('male', 'female') NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`family_tree`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`family_tree` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `date_of_death` DATE NULL,
  `place_of_birth` VARCHAR(45) NOT NULL,
  `place_of_death` VARCHAR(45) NULL,
  `creditcard_number` VARCHAR(45) NULL,
  `sex_id` INT NOT NULL,
  `family_tree_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_family_tree_sex1_idx` (`sex_id` ASC),
  INDEX `fk_family_tree_family_tree1_idx` (`family_tree_id` ASC),
  CONSTRAINT `fk_family_tree_sex1`
    FOREIGN KEY (`sex_id`)
    REFERENCES `mydb`.`sex` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_tree_family_tree1`
    FOREIGN KEY (`family_tree_id`)
    REFERENCES `mydb`.`family_tree` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`family_satellites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`family_satellites` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `date_of_death` DATE NULL,
  `place_of_birth` VARCHAR(45) NOT NULL,
  `place_of_death` VARCHAR(45) NULL,
  `date_of_marriage` DATE NULL,
  `sex_id` INT NOT NULL,
  `family_tree_id` INT NOT NULL,
  INDEX `fk_family_satellites_sex1_idx` (`sex_id` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_family_satellites_family_tree1_idx` (`family_tree_id` ASC),
  CONSTRAINT `fk_family_satellites_sex1`
    FOREIGN KEY (`sex_id`)
    REFERENCES `mydb`.`sex` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_satellites_family_tree1`
    FOREIGN KEY (`family_tree_id`)
    REFERENCES `mydb`.`family_tree` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`family_values`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`family_values` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value_name` VARCHAR(100) NOT NULL,
  `oriented_cost` INT NOT NULL,
  `maximum_cost` INT NULL,
  `minimum_cost` INT NULL,
  `code` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`family_tree_has_family_values`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`family_tree_has_family_values` (
  `family_tree_id` INT NOT NULL,
  `family_values_id` INT NOT NULL,
  PRIMARY KEY (`family_tree_id`, `family_values_id`),
  INDEX `fk_family_tree_has_family_values_family_values1_idx` (`family_values_id` ASC),
  INDEX `fk_family_tree_has_family_values_family_tree1_idx` (`family_tree_id` ASC),
  CONSTRAINT `fk_family_tree_has_family_values_family_tree1`
    FOREIGN KEY (`family_tree_id`)
    REFERENCES `mydb`.`family_tree` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_family_tree_has_family_values_family_values1`
    FOREIGN KEY (`family_values_id`)
    REFERENCES `mydb`.`family_values` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `mydb`.`sex` (`sex`) VALUES ('male');
INSERT INTO `mydb`.`sex` (`sex`) VALUES ('female');

INSERT INTO `mydb`.`family_tree` (`last_name`, `first_name`, `date_of_birth`, `place_of_birth`, `place_of_death`, `creditcard_number`, `sex_id`) VALUES ('The', 'Doctor', '1900.01.01', 'Galyfrey', 'Trenzalor', '0000000000000001', '1');
INSERT INTO `mydb`.`family_tree` (`last_name`, `first_name`, `date_of_birth`, `place_of_birth`, `creditcard_number`, `sex_id`) VALUES ('Pond', 'Amely', '1987.03.20', 'Edinburg', '2345124565421245', '2');
INSERT INTO `mydb`.`family_tree` (`last_name`, `first_name`, `date_of_birth`, `place_of_birth`, `sex_id`) VALUES ('Williams', 'Rory', '1987.08.16', 'Edinburg', '1');
INSERT INTO `mydb`.`family_tree` (`last_name`, `first_name`, `date_of_birth`, `place_of_birth`, `sex_id`, `family_tree_id`) VALUES ('River', 'Song', '2015.04.12', 'London', '2', '2');
INSERT INTO `mydb`.`family_tree` (`last_name`, `first_name`, `date_of_birth`, `place_of_birth`, `sex_id`) VALUES ('Jhons', 'Marta', '1982.10.29', 'Dublin', '2');


INSERT INTO `mydb`.`family_satellites` (`last_name`, `first_name`, `place_of_birth`, `date_of_marriage`, `sex_id`, `family_tree_id`) VALUES ('Williams', 'Rory', 'Edinburg', '2011.06.26', '1', '2');
INSERT INTO `mydb`.`family_satellites` (`last_name`, `first_name`, `place_of_birth`, `date_of_marriage`, `sex_id`, `family_tree_id`) VALUES ('Pond', 'Amely', 'Edinburg', '2011.06.26', '2', '3');
INSERT INTO `mydb`.`family_satellites` (`last_name`, `first_name`, `place_of_birth`, `date_of_marriage`, `sex_id`, `family_tree_id`) VALUES ('River', 'Song', 'London', '2033.08.10', '2', '1');
INSERT INTO `mydb`.`family_satellites` (`last_name`, `first_name`, `place_of_birth`, `date_of_marriage`, `sex_id`, `family_tree_id`) VALUES ('Smit', 'Matt', 'Cardif', '2015.07.30', '1', '5');


INSERT INTO `mydb`.`family_values` (`value_name`, `oriented_cost`, `code`) VALUES ('Tardis', '100000000', '1');
INSERT INTO `mydb`.`family_values` (`value_name`, `oriented_cost`, `maximum_cost`, `minimum_cost`, `code`) VALUES ('Car', '20000', '22000', '19000', '2321');
INSERT INTO `mydb`.`family_values` (`value_name`, `oriented_cost`, `maximum_cost`, `minimum_cost`, `code`) VALUES ('Sunflowers picture', '3200000', '3500000', '3000000', '3245');
INSERT INTO `mydb`.`family_values` (`value_name`, `oriented_cost`, `maximum_cost`, `minimum_cost`, `code`) VALUES ('Portrait of Père Tanguy picture', '2300000', '3000000', '2000000', '6432');


INSERT INTO `mydb`.`family_tree_has_family_values` (`family_tree_id`, `family_values_id`) VALUES ('1', '1');
INSERT INTO `mydb`.`family_tree_has_family_values` (`family_tree_id`, `family_values_id`) VALUES ('2', '3');
INSERT INTO `mydb`.`family_tree_has_family_values` (`family_tree_id`, `family_values_id`) VALUES ('3', '2');
INSERT INTO `mydb`.`family_tree_has_family_values` (`family_tree_id`, `family_values_id`) VALUES ('4', '4');


ALTER TABLE `mydb`.`family_tree` 
ADD COLUMN `full_name` VARCHAR(100) GENERATED ALWAYS AS (concat( last_name, ' ', first_name )) VIRTUAL AFTER `creditcard_number`;

ALTER TABLE `mydb`.`family_satellites` 
ADD COLUMN `date_of_birth` DATE NULL AFTER `first_name`;

UPDATE `mydb`.`family_satellites` SET `date_of_birth`='1987-08-16' WHERE `id`='1';
UPDATE `mydb`.`family_satellites` SET `date_of_birth`='1987-03-20' WHERE `id`='2';
UPDATE `mydb`.`family_satellites` SET `date_of_birth`='2015-04-12' WHERE `id`='3';
UPDATE `mydb`.`family_satellites` SET `date_of_birth`='1978.08.22' WHERE `id`='4';

ALTER TABLE `mydb`.`family_satellites` 
CHANGE COLUMN `date_of_birth` `date_of_birth` DATE NOT NULL ;

ALTER TABLE `mydb`.`family_satellites` 
ADD COLUMN `full_information` VARCHAR(200) GENERATED ALWAYS AS (concat(first_name, 
  ' ',
  last_name,
    ' born ',
    dayofyear(date_of_birth),
    ' day ',
    year(date_of_birth),
    ' year A.D.)')) VIRTUAL AFTER `date_of_marriage`;


UPDATE `mydb`.`family_values` SET `maximum_cost`='100000000', `minimum_cost`='100000000' WHERE `id`='1';

ALTER TABLE `mydb`.`family_values` 
ADD COLUMN `coeficient` DOUBLE GENERATED ALWAYS AS (sin(minimum_cost)+cos(maximum_cost)) VIRTUAL AFTER `code`;
