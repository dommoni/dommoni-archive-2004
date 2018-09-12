create table `poll_vote_records` (`id` INT NOT NULL AUTO_INCREMENT, 
                                  `account_id` INT NOT NULL, 
                                  `outcome_id` INT NOT NULL, 
                                  `timestamp` TIMESTAMP NOT NULL)