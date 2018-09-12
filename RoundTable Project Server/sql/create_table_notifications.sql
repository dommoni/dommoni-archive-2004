create table `notifications` (`id` INT NOT NULL AUTO_INCREMENT,
                              `project_id` INT NOT NULL,
                              `name` VARCHAR(255),
                              `context` VARCHAR(255),
                              `created_by` INT NOT NULL,
                              `created_on` TIMESTAMP,
                              `type` INT NOT NULL,
                              `operation` INT NOT NULL,
                              PRIMARY KEY(`id`), INDEX(`id`))