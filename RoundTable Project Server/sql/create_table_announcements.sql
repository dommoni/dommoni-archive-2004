create table `announcements` (`id` INT NOT NULL AUTO_INCREMENT,
                              `project_id` INT NOT NULL, 
                              `created_by` INT NOT NULL, 
                              `created_on` TIMESTAMP NOT NULL,
                              `title` VARCHAR(255),
                              `text` TEXT, 
                              INDEX(`id`), UNIQUE(`id`))