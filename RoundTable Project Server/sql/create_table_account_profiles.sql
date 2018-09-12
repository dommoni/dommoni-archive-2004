create table `account_profiles` (`account_id` INT NOT NULL, 
                                 `profile_text` TEXT, 
                                 `picture` BLOB, 
                                 INDEX(`account_id`), UNIQUE(`account_id`))