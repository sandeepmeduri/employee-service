DROP TABLE IF EXISTS tb_employee;

CREATE TABLE tb_employee (
  id int  PRIMARY KEY,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  salary NUMERIC (15, 2) NOT NULL);
  
  INSERT INTO tb_employee VALUES 
	(1,'Leslie','Andrews','leslie@infy.com',20000),
	(2,'Emma','Baumgarten','emma@infy.com',30000),
	(3,'Avani','Gupta','avani@infy.com',40000),
	(4,'Yuri','Petrov','yuri@infy.com',50000),
	(5,'Juan','Vega','juan@infy.com',60000);
