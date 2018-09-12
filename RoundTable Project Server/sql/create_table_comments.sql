create table `comments` (`id` INT NOT NULL AUTO_INCREMENT,
                      `project_id` INT NOT NULL,
                      `object_id` INT NOT NULL,
                      `context` VARCHAR(255) NOT NULL,
                      `created_by` INT NOT NULL,
                      `created_on` TIMESTAMP NOT NULL,
                      `comment` TEXT,
					  PRIMARY KEY(`id`), INDEX(`id`))