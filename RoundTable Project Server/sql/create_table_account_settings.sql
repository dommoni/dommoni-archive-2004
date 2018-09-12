create table `account_settings` (`account_id` INT NOT NULL, 
                                 `notification_system_message` BOOL DEFAULT 1, 
                                 `notification_desktop_pager` BOOL DEFAULT 0,
                                 `notification_email` BOOL DEFAULT 0,
                                 `email_address` VARCHAR(255))