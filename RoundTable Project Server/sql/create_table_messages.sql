create table `messages` (`id` INT NOT NULL AUTO_INCREMENT, 
                         `to_id` INT NOT NULL, 
                         `from_id` INT, 
                         `text` TEXT, 
                         `type` INT,
                         PRIMARY KEY(`id`), INDEX(`id`))
