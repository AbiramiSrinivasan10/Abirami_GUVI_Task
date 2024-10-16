#creating database 
create database JATDB1;
#switching to databadse
use JATDB1;

#creating table
create table Employedetails(empno int,ename varchar(20),job varchar(20),mgr int,hiredate date,sal int,comm int,deptno int);

describe Employedetails;

insert into Employedetails values(8369,'SMITH','CLERK',8902,'1990-02-18',800.00,NULL,20);
insert into Employedetails values(8499,'ANYA','SALESMAN',8698,'1991-02-20',1600.00,300.00,30);
insert into Employedetails values(8521,'SETH','SALESMAN',8698,'1991-12-22',500.00,500.00,30);
insert into Employedetails values(8566,'MAHADEVAN','MANAGER',8839,'1991-04-02',2985.00,NULL,20);
insert into Employedetails values(8698,'BINA','MANAGER',8839,'1991-05-01',2850.00,NULL,30);
insert into Employedetails values(8882,'SHIVANSH','MANAGER',8839,'1991-06-09',2450.00,NULL,10);
insert into Employedetails values(8888,'SCOTT','ANALYST',8566,'1992-12-09',3000.00,NULL,20);
insert into Employedetails values(8839,'AMIR','PRESIDENT',NULL,'1991-11-18',5000.00,NULL,10);
insert into Employedetails values(8844,'KULDEEP','SALESMAN',8698,'1991-09-08',1500.00,0.00,30);

describe Employedetails ;
select * from Employedetails ;

SELECT ename,sal
FROM  Employedetails 
WHERE Sal<=2200;

select * from Employedetails where comm is null or comm=0 ;

Select ename,sal from employedetails where sal not between 2500 and 4000;

select ename , job , sal from employedetails where mgr is null;

select * from employedetails where ename like '__A%' ;

select ename from employedetails where ename like '%T' ;






