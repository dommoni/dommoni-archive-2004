create table `custom_fields` (`id` INT NOT NULL AUTO_INCREMENT, 
                              `project_id` INT NOT NULL, 
                              `context` VARCHAR(255), 
                              `parent_id` INT NOT NULL, 
                              `name` VARCHAR(255) NOT NULL, 
                              `created_by` INT NOT NULL, 
                              `created_on` TIMESTAMP NOT NULL, 
                              `type` INT NOT NULL, 
                              `ordinal` INT, 
                              `hidden` BOOL NOT NULL,
                              PRIMARY KEY(`id`), INDEX(`id`))