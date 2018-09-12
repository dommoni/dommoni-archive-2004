create table `forums` (`id` INT NOT NULL AUTO_INCREMENT, 
                       `subject` VARCHAR(255) NOT NULL, 
                       `message` TEXT, 
                       `project_id` INT NOT NULL, 
                       `created_by` INT NOT NULL, 
                       `created_on` TIMESTAMP NOT NULL,
                       PRIMARY KEY(`id`), INDEX(`id`))
