create table `recentchanges` (`id` int not null auto_increment,
                              `project_id` int not null,
                              `change_message` mediumtext,
                              `timestamp` TIMESTAMP,
                              PRIMARY KEY(`id`), INDEX(`id`))