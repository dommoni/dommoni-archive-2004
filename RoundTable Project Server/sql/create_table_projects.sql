create table `projects` (`id` INT NOT NULL AUTO_INCREMENT, 
                         `name` VARCHAR(255) NOT NULL,
                         PRIMARY KEY(`id`), INDEX(`id`), UNIQUE(`id`,`name`))