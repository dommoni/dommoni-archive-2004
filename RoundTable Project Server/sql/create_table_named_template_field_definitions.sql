create table `named_template_field_definitions` (`named_field_template_id` INT NOT NULL, 
												 `name` VARCHAR(255), 
												 `type` INT NOT NULL,
												 `ordinal` INT,
												 `hidden` BOOL NOT NULL,
												 `description` TEXT)