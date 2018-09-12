create table `task_reminder` (`id` INT NOT NULL AUTO_INCREMENT,
                              `task_id INT NOT NULL`
                              `reminder_time` TIMESTAMP NOT NULL,
                              PRIMARY KEY(`id`), INDEX(`id`), UNIQUE(`id`))