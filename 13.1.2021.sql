create table student_manager(
id int auto_increment primary key,
name varchar(50) not null,
address varchar(50) not null,
sex int not null default 1,
age int not null check (age > 18 and age < 25),
email varchar(50) not null unique,
phone varchar(10) not null
);

-- 2
create table class_manager(
idClass int auto_increment primary key,
nameClass varchar(50) not null unique
);

-- 3 4
alter table student_manager
add column classId int,
add constraint foreign key (classId) references class_manager (idClass);

-- 5
insert into class_manager (`nameClass`)
value ('C08'), ('C09'), ('C10'), ('C11'), ('C12');

-- 6
insert into student_manager (`name`,`address`,`age`,`email`,`phone`,`classId`)
values ('Nguyễn Hồng Nam','HN','22','hongnam1211@gmail.com','0868886855',1),
('Nguyễn Duy Tiến','BN','24','tientien@gmail.com','0123456789',2),
('Bùi Tấn Huấn','HD','22','huan@gmail.com','0123456788',3),
('Dương Văn Trung','BN','24','trung@gmail.com','0123456666',4),
('Lê Văn Hùng','HD','19','hung@gmail.com','0123456777',5);

insert into student_manager(`name`,`address`,`age`,`email`,`phone`,`classId`)
values ('Hehe','HCM','20','hehe@gmail.com','0123456789',3);

insert into student_manager(`name`,`address`,`age`,`email`,`phone`,`classId`)
values ('Haha','HCM','22','haha@gmail.com','0123456789',3),
('Hihi','HCM','23','hihi@gmail.com','0123456789',3);

update `bai2.13.1`.`student_manager` set sex = 0 where id = 1;

update `bai2.13.1`.student_manager set classId = 5 where id = 1;

-- 7
select * from student_manager
order by `name` asc;

-- 8
select * from student_manager
order by age desc;

-- 9
select nameClass, count(*)from class_manager
join student_manager on student_manager.classId = class_manager.idClass
group by nameClass;

create view total2 as select nameClass, count(idClass) as count from class_manager
join student_manager on student_manager.classId = class_manager.idClass
group by nameClass;

-- 10
select * from total2
where count = (select max(count) from total2);

-- 11
select * from total2
where count = (select min(count) from total2);

-- 12
select address, count(*)from student_manager
group by address;

-- 13
select nameClass, count(*)from class_manager
join student_manager on student_manager.classId = class_manager.idClass
group by nameclass
having count(*) > 3;

-- 14
select address, count(*)from student_manager
group by address
having count(*) >= 3;

-- 15c1
select name, age from student_manager
where age = (select max(age) from student_manager);

-- 15c2
select * from student_manager
order by age desc
limit 1;

-- 16
select * from student_manager
order by age asc
limit 1;

SET SQL_SAFE_UPDATES = 0;

-- 17
DELETE FROM `baitap2.13.1`.`student_manager` WHERE (`address` = 'HD');


-- 18
update `baitap2.13.1`.`student_manager` set sex = 0 where address = "HCM";

-- 19
select name, age
from student_manager
where age = (select max(age) from student_manager
where age < (select max(age) from student_manager));

-- 20
select name, age
from student_manager
where age = (select min(age) from student_manager
where age > (select min(age) from student_manager));