CREATE SCHEMA `vexillum_schema` ;

CREATE TABLE IF NOT EXISTS user_profile (
	key_id bigint(10) AUTO_INCREMENT
	user_id varchar(10) NOT NULL,
	password varchar(20) NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20),
	age int NOT NULL	,
	dob varchar(10) NOT NULL,
	address varchar(100) NOT NULL,
	email_id varchar(30) NOT NULL,
	phone_no bigint(10) NOT NULL,
	is_store_admin int DEFAULT 0,
	created_on timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_on varchar(10),
	is_deleted int default 0,
	PRIMARY KEY(key_id, user_id)
)AUTO_INCREMENT=10001;

