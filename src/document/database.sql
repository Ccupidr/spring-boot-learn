CREATE TABLE `article` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`author` VARCHAR(32) NOT NULL,
	`title` VARCHAR(32) NOT NULL,
	`content` VARCHAR(512) NOT NULL,
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`)
)
COMMENT='文章'
ENGINE=InnoDB;

