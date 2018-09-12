create table `session_logs` (`id` INT NOT NULL AUTO_INCREMENT,
                             `session_id` VARCHAR(255) NOT NULL,
                             `account_id` INT NOT NULL,
                             `type` INT NOT NULL,
                             `start_time` TIMESTAMP,
                             `end_time` TIMESTAMP,
                             `remote_ip_address` VARCHAR(255),
                             PRIMARY KEY(`id`), INDEX(`id`))