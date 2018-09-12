create table `forum_replies` (`id` INT NOT NULL AUTO_INCREMENT, 
                              `forum_id` INT NOT NULL, 
                              `reply` TEXT NOT NULL, 
                              `account_id` INT NOT NULL, 
                              `timestamp` TIMESTAMP NOT NULL,
                              PRIMARY KEY(`id`), INDEX(`id`))