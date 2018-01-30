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
-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------
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


-- -----------------------------------------------------
-- Table `mydb`.`groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`groups` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `year` YEAR NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(45) NOT NULL,
  `code` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`town`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`town` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `town` VARCHAR(45) NOT NULL,
  `region_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_town_region1_idx` (`region_id` ASC),
  CONSTRAINT `fk_town_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `mydb`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`midlle_education`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`midlle_education` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone` INT NOT NULL,
  `full_name_of_director` VARCHAR(45) NOT NULL,
  `town_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_midlle_education_town1_idx` (`town_id` ASC),
  CONSTRAINT `fk_midlle_education_town1`
    FOREIGN KEY (`town_id`)
    REFERENCES `mydb`.`town` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `second_name` VARCHAR(45) NULL,
  `rank` INT NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `date_of_arrival` DATE NOT NULL,
  `student_number` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `groups_id` INT NOT NULL,
  `town_id` INT NOT NULL,
  `midlle_education_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_groups1_idx` (`groups_id` ASC),
  INDEX `fk_student_town1_idx` (`town_id` ASC),
  INDEX `fk_student_midlle_education1_idx` (`midlle_education_id` ASC),
  CONSTRAINT `fk_student_groups1`
    FOREIGN KEY (`groups_id`)
    REFERENCES `mydb`.`groups` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_town1`
    FOREIGN KEY (`town_id`)
    REFERENCES `mydb`.`town` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_midlle_education1`
    FOREIGN KEY (`midlle_education_id`)
    REFERENCES `mydb`.`midlle_education` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`arrears`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`arrears` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_of_subject` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`student_has_arrears`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`student_has_arrears` (
  `student_id` INT NOT NULL,
  `arrears_id` INT NOT NULL,
  PRIMARY KEY (`student_id`, `arrears_id`),
  INDEX `fk_student_has_arrears_arrears1_idx` (`arrears_id` ASC),
  INDEX `fk_student_has_arrears_student1_idx` (`student_id` ASC),
  CONSTRAINT `fk_student_has_arrears_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `mydb`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_arrears_arrears1`
    FOREIGN KEY (`arrears_id`)
    REFERENCES `mydb`.`arrears` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `mydb`.`region` (`region`, `code`) VALUES ('Lviv', '360');
INSERT INTO `mydb`.`region` (`region`, `code`) VALUES ('Kiev', '361');
INSERT INTO `mydb`.`region` (`region`, `code`) VALUES ('Ternopil', '362');

INSERT INTO `mydb`.`town` (`town`, `region_id`) VALUES ('Lviv', '1');
INSERT INTO `mydb`.`town` (`town`, `region_id`) VALUES ('Kiev', '2');
INSERT INTO `mydb`.`town` (`town`, `region_id`) VALUES ('Ternopil', '3');
INSERT INTO `mydb`.`town` (`town`, `region_id`) VALUES ('Drogobuch', '1');
INSERT INTO `mydb`.`town` (`town`, `region_id`) VALUES ('Boruspil', '2');


INSERT INTO `mydb`.`midlle_education` (`name`, `phone`, `full_name_of_director`, `town_id`) VALUES ('school 12', '380973465', 'Obi van kenobi', '1');
INSERT INTO `mydb`.`midlle_education` (`name`, `phone`, `full_name_of_director`, `town_id`) VALUES ('school 43', '332455325', 'Joda', '2');
INSERT INTO `mydb`.`midlle_education` (`name`, `phone`, `full_name_of_director`, `town_id`) VALUES ('school 32', '235352351', 'Palpatin', '3');

INSERT INTO `mydb`.`groups` (`name`, `number`, `year`) VALUES ('fei', '1', 2016);
INSERT INTO `mydb`.`groups` (`name`, `number`, `year`) VALUES ('fem', '1', 2016);
INSERT INTO `mydb`.`groups` (`name`, `number`, `year`) VALUES ('fei', '3', 2014);

INSERT INTO `mydb`.`student` (`last_name`, `first_name`, `second_name`, `rank`, `date_of_birth`, `date_of_arrival`, `student_number`, `email`, `groups_id`, `town_id`, `midlle_education_id`) VALUES ('Begins', 'Bilbo', 'Shir', '2', '1996.06.06', '2014.08.01', '124124', 'bilbo@gmail.com', '3', '1', '1');
INSERT INTO `mydb`.`student` (`last_name`, `first_name`, `second_name`, `rank`, `date_of_birth`, `date_of_arrival`, `student_number`, `email`, `groups_id`, `town_id`, `midlle_education_id`) VALUES ('Begins', 'Frodo', 'Shir', '3', '1998.03.03', '2016.08.01', '425623', 'frogo@cool.org', '1', '2', '2');

INSERT INTO `mydb`.`arrears` (`name_of_subject`) VALUES ('Potion-making');
INSERT INTO `mydb`.`arrears` (`name_of_subject`) VALUES ('Quidditch');

INSERT INTO `mydb`.`student_has_arrears` (`student_id`, `arrears_id`) VALUES ('6', '1');
INSERT INTO `mydb`.`student_has_arrears` (`student_id`, `arrears_id`) VALUES ('7', '2');
INSERT INTO `mydb`.`student_has_arrears` (`student_id`, `arrears_id`) VALUES ('7', '1');


ALTER TABLE `mydb`.`student` 
ADD COLUMN `info` VARCHAR(100) GENERATED ALWAYS AS (concat(student_number, '-', year(date_of_arrival))) VIRTUAL AFTER `midlle_education_id`;


ALTER TABLE `mydb`.`student` 
ADD COLUMN `full_name` VARCHAR(150) GENERATED ALWAYS AS (concat(last_name, ' ', first_name, ' ', second_name)) VIRTUAL AFTER `info`;

ALTER TABLE `mydb`.`student` 
ADD COLUMN `age_of_arrival` VARCHAR(45) GENERATED ALWAYS AS (year(date_of_arrival)-year(date_of_birth)) VIRTUAL AFTER `full_name`;
year(date_of_arrival)-year(date_of_birth)