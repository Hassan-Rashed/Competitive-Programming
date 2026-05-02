Drop Database if exists jdbc_course_db;
create DataBase jdbc_course_db;

use jdbc_course_db;

Create Table Employee(
id int (15) primary key auto_increment,
name varchar (30),
gender BOOLEAN,
birth_date Date,
Salary real
);
