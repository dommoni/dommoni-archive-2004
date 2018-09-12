create table `schedule_items` (`id` INT NOT NULL AUTO_INCREMENT,
							   `schedule_id` INT NOT NULL,
							   `title` VARCHAR(255) NOT NULL,
							   `created_by` INT NOT NULL,
							   `created_on` TIMESTAMP NOT NULL,
							   `start_date` DATE,
							   `end_date` DATE,
							   `duration` INT,
							   `percent_complete` INT,
							   `priority` INT,
							   `description` VARCHAR(255),
							   `ordinal` INT NOT NULL,
							   PRIMARY KEY(`id`), INDEX(`id`), UNIQUE(`id`,`title`))

   