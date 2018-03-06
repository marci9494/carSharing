ALTER TABLE `kraftstoff` CHANGE `NAME` `NAME` VARCHAR(11) NOT NULL;
INSERT INTO `kraftstoff` (`ID`, `NAME`) VALUES ('1', 'Benzin');
INSERT INTO `kraftstoff` (`ID`, `NAME`) VALUES ('2', 'Diesel');
INSERT INTO `kraftstoff` (`ID`, `NAME`) VALUES ('3', 'Elektro');
INSERT INTO `kraftstoff` (`ID`, `NAME`) VALUES ('4', 'Hybrid');
INSERT INTO `kraftstoff` (`ID`, `NAME`) VALUES ('5', 'Erdgas');
INSERT INTO `kraftstoff` (`ID`, `NAME`) VALUES ('6', 'sonstige');
ALTER TABLE `kraftstoff` CHANGE `ID` `ID` BIGINT(11) NOT NULL;
ALTER TABLE `fahrzeug` DROP `kraftstoff`;
ALTER TABLE `fahrzeug` ADD `KRAFTSTOFF` BIGINT(11) NOT NULL AFTER `MODELL`;
ALTER TABLE `fahrzeug` ADD CONSTRAINT `fahrzeug_ibfk_5` FOREIGN KEY (`KRAFTSTOFF`) 
REFERENCES `kraftstoff`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;