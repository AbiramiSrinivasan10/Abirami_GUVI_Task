#creating database 
create database JATDB1;
#switching to databadse
use JATDB1;
#creating table
create table empdata(empcode int,empname varchar(20),empage int,esalary int);
describe empdata;
select * from empdata;