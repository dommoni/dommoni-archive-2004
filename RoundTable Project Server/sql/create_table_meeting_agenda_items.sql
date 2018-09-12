create table `meeting_agenda_items` (`id` INT NOT NULL,
									 `meeting_id` INT NOT NULL, 
									 `title` VARCHAR(255), 
									 `notes` TEXT, 
									 `ordinal` INT NOT NULL,
									 PRIMARY KEY(`id`), INDEX(`id`))