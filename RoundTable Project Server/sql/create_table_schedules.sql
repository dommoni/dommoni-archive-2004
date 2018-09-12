create table `schedules` (`id` INT NOT NULL AUTO_INCREMENT,
                          `name` VARCHAR(255) NOT NULL,
                          `project_id` INT NOT NULL,
                          `created_by` INT NOT NULL,
                          `created_on` TIMESTAMP NOT NULL)