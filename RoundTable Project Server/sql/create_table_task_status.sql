create table task_status (`id` INT NOT NULL AUTO_INCREMENT, 
                          `project_id` INT NOT NULL, 
					  	  `title` VARCHAR(255),
					  	  `is_global` BOOL, 
					      PRIMARY KEY(`id`), INDEX(`id`))