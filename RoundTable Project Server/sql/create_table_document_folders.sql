create table `document_folders` (`id` INT NOT NULL AUTO_INCREMENT, 
                                 `folder_name` VARCHAR(255) NOT NULL, 
                                 `project_id` INT NOT NULL, 
                                 `parent_folder_id` INT,
                                 PRIMARY KEY(`id`), INDEX(`id`))