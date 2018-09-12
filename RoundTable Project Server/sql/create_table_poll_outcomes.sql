create table `poll_outcomes` (`id` INT NOT NULL AUTO_INCREMENT, 
							  `poll_id` INT NOT NULL, 
							  `title` TEXT,
							  PRIMARY KEY(`id`), INDEX(`id`))