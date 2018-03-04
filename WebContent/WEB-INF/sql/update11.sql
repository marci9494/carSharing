ALTER TABLE `kreditkarten` CHANGE `Kreditkartennummer` `kartennummer` VARCHAR (
16 ) NOT  NULL , CHANGE `Karteninhaber` `inhaber` VARCHAR ( 30 ) CHARACTER SET
latin1 COLLATE latin1_swedish_ci NOT  NULL ; ALTER TABLE `kreditkarten` CHANGE
`User-ID` `user` BIGINT ( 11 ) NOT  NULL ;