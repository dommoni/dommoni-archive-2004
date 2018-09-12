create table `accounts` (`id` INT NOT NULL AUTO_INCREMENT, 
                         `name` VARCHAR(255),
                         `nick_name` VARCHAR(255), 
                         `username` VARCHAR(255) NOT NULL, 
                         `password` VARCHAR(255) NOT NULL, 
                         `account_type` INT NOT NULL,
                         PRIMARY KEY(`id`), unique(`username`), index(`id`))