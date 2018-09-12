create table `polls` (`id` INT NOT NULL AUTO_INCREMENT, 
					  `created_by` INT NOT NULL, 
					  `poll_question` TEXT NOT NULL, 
					  `timestamp` TIMESTAMP NOT NULL,
					  PRIMARY KEY(`id`), INDEX(`id`))