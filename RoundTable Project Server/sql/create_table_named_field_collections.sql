create table `named_field_collections` (`id` INT NOT NULL AUTO_INCREMENT, 
										`name` VARCHAR(255), 
										`project_id` INT NOT NULL,
										`context` VARCHAR(255) NOT NULL, 
										`parent_id` INT NOT NULL, 
										`created_by` INT NOT NULL, 
										`created_on` TIMESTAMP NOT NULL, 
										`description` TEXT,
										PRIMARY KEY(`id`), INDEX(`id`))