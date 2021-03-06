ALTER TABLE `BEWERTUNG` DROP `NUTZER`;
ALTER TABLE `BEWERTUNG` ADD `ZUSTAND` VARCHAR(5) NOT NULL AFTER `BUCHUNG`, ADD `FREUNDLICHKEIT` VARCHAR(5) NOT NULL AFTER `ZUSTAND`, ADD `ZAHLEN` VARCHAR(5) NOT NULL AFTER `FREUNDLICHKEIT`;
ALTER TABLE `BEWERTUNG` CHANGE `BUCHUNG` `BUCHUNG` BIGINT(11) NOT NULL;
ALTER TABLE `BEWERTUNG` ADD FOREIGN KEY (`BUCHUNG`) REFERENCES `BUCHUNG`(`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `BEWERTUNG` CHANGE `ID` `ID` BIGINT(11) NOT NULL AUTO_INCREMENT;