/**
 * CREATE Script for init of DB
 */
-- Create Subscribers
insert into subscriber (id, email, name, active, subscribe_date) values (1, 'test1@newsletter.de', 'Test 1', 1, NOW() - 5);
insert into subscriber (id, email, name, active, subscribe_date) values (2, 'test2@newsletter.de', 'Test 2', 0, NOW() - 3);
insert into subscriber (id, email, name, active, subscribe_date) values (3, 'test3@newsletter.de', 'Test 3', 0, NOW() - 2);
insert into subscriber (id, email, name, active, subscribe_date) values (4, 'test4@newsletter.de', 'Test 4', 1, NOW());