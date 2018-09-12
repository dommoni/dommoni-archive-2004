create table `named_field_templates` (`id` INT NOT NULL AUTO_INCREMENT, 
                                      `name` VARCHAR(255) NOT NULL, 
                                      `project_id` INT NOT NULL,
                                      `context` VARCHAR(255), 
                                      `created_by` INT NOT NULL, 
                                      `created_on` TIMESTAMP, 
                                      `description` TEXT,
                                      PRIMARY KEY(`id`), INDEX(`id`))