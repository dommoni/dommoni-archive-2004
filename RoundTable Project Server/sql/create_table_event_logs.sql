create table `event_logs` (`id` INT NOT NULL AUTO_INCREMENT,
                           `session_id` INT,
                           `instigator_id` INT NOT NULL,
                           `project_id` INT,
                           `context` VARCHAR(255),
                           `operation_type` INT,
                           `operation_name` VARCHAR(255),
                           `timestamp` TIMESTAMP NOT NULL,
                           PRIMARY KEY(`id`), INDEX(`id`))