create table `comment_attachments` (`id` INT NOT NULL AUTO_INCREMENT, 
					     			`comment_id` INT NOT NULL,
					     			`filename` VARCHAR(255),
					                `attachement` BLOB NOT NULL,
					                PRIMARY KEY(`id`), INDEX(`id`))