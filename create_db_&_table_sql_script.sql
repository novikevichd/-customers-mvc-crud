CREATE DATABASE IF NOT EXISTS customers_of_service;
USE customers_of_service;

--
--
--

DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
id int not null auto_increment,
first_name varchar(40) default null,
last_name varchar(40) default null,
email varchar(20) default null,
primary key(id));

--
--
--
INSERT INTO customers (first_name, last_name, email)
VALUES ('James', 'Hetfield', 'hetfield@metmail.com'),
('Kirk', 'Hammett','hammett@metmail.com'),
('Roberto Agustín Miguel Santiago Samuel', 'Trujillo', 'trujillo@metmail.com'),
('Lars', 'Ulrich', 'ulrich@metmail.com')

--