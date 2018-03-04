CREATE TABLE `carsharing`.`Kreditkarten` ( `ID` BIGINT(11) NOT NULL , PRIMARY KEY (`ID`)) ENGINE = InnoDB;

ALTER TABLE `kreditkarten` ADD `User-ID` BIGINT(11) NOT NULL AFTER `ID`;

ALTER TABLE `kreditkarten` ADD CONSTRAINT `User-ID-KK` FOREIGN KEY (`User-ID`) REFERENCES `user`(`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `kreditkarten` ADD `Kreditkartennummer` INT(16) NOT NULL AFTER `User-ID`, ADD `Valid` VARCHAR(7) NOT NULL AFTER `Kreditkartennummer`;

ALTER TABLE `kreditkarten` ADD `Karteninhaber` VARCHAR(30) NOT NULL AFTER `Valid`;