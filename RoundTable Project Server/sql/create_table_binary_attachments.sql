create table `binary_attachments` (`id` INT NOT NULL AUTO_INCREMENT,
                                   `project_id` INT NOT NULL,
                                   `created_by` INT NOT NULL,
                                   `created_on` TIMESTAMP NOT NULL,
                                   `object_id` INT NOT NULL,
                                   `object_context` VARCHAR(255) NOT NULL,
                                   `attachment` BLOB,
                                   `notes` TEXT,
                                   `name` VARCHAR(255),
                                   PRIMARY KEY(`id`), INDEX(`id`))