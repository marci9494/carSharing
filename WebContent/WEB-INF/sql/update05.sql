
ALTER TABLE `FAHRZEUG` ADD `EIGENTUEMER` INT(11) NOT NULL AFTER `PLZ`;
ALTER TABLE `FAHRZEUG` ADD FOREIGN KEY (`EIGENTUEMER`) REFERENCES `NUTZER`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
RENAME TABLE `carSharing`.`NUTZER` TO `carSharing`.`USER`;