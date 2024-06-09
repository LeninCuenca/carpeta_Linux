-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pa_extra
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pa_extra
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pa_extra` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `pa_extra` ;

-- -----------------------------------------------------
-- Table `pa_extra`.`valores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pa_extra`.`valores` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBREHILO` VARCHAR(255) NULL DEFAULT NULL,
  `COL1` INT NULL DEFAULT NULL,
  `COL2` INT NULL DEFAULT NULL,
  `COL3` INT NULL DEFAULT NULL,
  `COL4` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 501
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
