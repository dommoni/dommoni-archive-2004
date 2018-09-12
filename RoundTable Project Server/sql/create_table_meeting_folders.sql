create table meeting_folders(id INT NOT NULL AUTO_INCREMENT, 
							 meeting_id INT NOT NULL, 
							 folder_name VARCHAR(255) NOT NULL, 
							 parent_folder_id INT, 
							 created_by INT NOT NULL, 
							 created_on DATETIME,
							 PRIMARY KEY(`id`), INDEX(`id`))