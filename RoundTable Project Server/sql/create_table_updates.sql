create table `updates` (`id` INT NOT NULL AUTO_INCREMENT, 
                        `project_id` INT NOT NULL, 
                        `poster_id` INT NOT NULL, 
                        `timestamp` TIMESTAMP NOT NULL, 
                        `message` TEXT NOT NULL,
                        PRIMARY KEY(`id`), INDEX(`id`))