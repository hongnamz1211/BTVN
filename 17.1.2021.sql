create database `baitap4.17.1`;
use `baitap4.17.1`;

create table myBook (
id int auto_increment primary key,
bookName varchar(50) not null,
price int not null,
quantity int default 1,
bookType varchar(20) not null,
author varchar(50) not null,
bookDate datetime not null
);

INSERT INTO myBook
VALUE (1,'Cây chuối ngọt của tôi' , 50000, 4, 'khoa học', 'chú Tiến', '2018-12-26'),
(2,'Luật tâm thức' , 220000, 3, 'chính trị', 'Nguyễn Văn A', '2015-10-26'),
(3,'Không bao giờ là thất bại' , 67000, 7, 'khoa học', 'chú Trung', '2020-12-26'),
(4,'Khởi nghiệp bán lẻ' , 120000, 12, 'tiểu thuyết', 'chú Huấn', '2016-02-26'),
(5,'Nhà giả kim' , 110000, 2, 'chính trị', 'chú Hùng', '2018-2-22'),
(6,'Ngày đòi nợ' , 300000, 7, 'khoa học', 'Nguyễn Thị E', '2012-12-05'),
(7,'Đời ngắn đừng ngủ dài' , 80000, 24, 'tiểu thuyết', 'Nguyễn Văn B', '2016-11-12'),
(8,'Những giấc mơ ở hiệu sách Morisaki' , 130000, 5, 'tiểu thuyết', 'Nguyễn Duy D', '2015-02-02'),
(9,'Đại dương đen' , 180000, 9, 'chính trị', 'Trung Văn Dương', '2012-07-20'),
(10,'Những tù nhân của định lý' , 157000, 30, 'khoa học', 'Nguyễn Văn C', '2005-10-22');

---
SELECT * FROM myBook;

---
SELECT sum(price*quantity) as 'Tổng tiền tất cả sách'
FROM myBook;

---
SELECT * FROM myBook
WHERE price = (SELECT MAX(price) FROM myBook);

---
SELECT * FROM myBook
WHERE price = (SELECT MIN(price) FROM myBook);

---
SELECT avg(price) AS 'Gia trung binh sach khoa hoc'
FROM myBook
WHERE bookType = 'Khoa học';

---
SELECT * FROM myBook
WHERE author = 'chú Tiến';

---
SELECT * FROM myBook
WHERE price BETWEEN 90000 AND 130000;

--- 
SELECT * FROM myBook
WHERE bookType = 'Khoa học';

--- 
SELECT * FROM myBook
WHERE price = "300000";

---
SELECT * FROM myBook
WHERE bookDate = '2018-02-22 00:00:00';

---
SELECT * FROM myBook
WHERE bookDate BETWEEN '2015-01-01 00:00:00' AND '2016-01-01 00:00:00';