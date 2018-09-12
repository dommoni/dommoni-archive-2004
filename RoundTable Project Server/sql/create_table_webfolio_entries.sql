create table `webfolio_entries` (`id` INT AUTO_INCREMENT NOT NULL, 
								 `name` VARCHAR(255) NOT NULL, 
								 `url` VARCHAR(255), 
								 `notes` MEDIUMTEXT, 
								 `date_created` TIMESTAMP, 
								 `flag` INT,
								 PRIMARY KEY(`id`), INDEX(`id`))