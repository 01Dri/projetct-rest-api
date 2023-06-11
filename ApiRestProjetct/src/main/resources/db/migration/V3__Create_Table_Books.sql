
CREATE TABLE IF NOT EXISTS `books` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `release_date` DATE,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

