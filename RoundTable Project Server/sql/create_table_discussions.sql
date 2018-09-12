create table `discussions` (`id` INT NOT NULL AUTO_INCREMENT,
							`project_id` INT NOT NULL,
							`title` VARCHAR(255),
							`date` DATE NOT NULL,
							PRIMARY KEY(`id`), INDEX(`id`))