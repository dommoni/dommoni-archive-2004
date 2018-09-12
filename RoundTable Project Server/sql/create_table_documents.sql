create table `documents` (`id` INT NOT NULL AUTO_INCREMENT,
						  `name` VARCHAR(255) NOT NULL,
						  `filename` VARCHAR(255) NOT NULL,
						  `owner_id` INT NOT NULL,
						  `project_id` INT NOT NULL,
						  `document_type` INT,
						  `document` BLOB(50M) NOT NULL,
						  `createdon` TIMESTAMP NOT NULL,
						  `description` TEXT,
						  `content_summary` TEXT,
						  PRIMARY KEY(`id`), INDEX(`id`))
                          
   