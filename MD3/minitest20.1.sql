CREATE DATABASE `minitest20.1`;

USE `minitest20.1`;

CREATE TABLE DiemDenDuLich (
dd_id int primary key auto_increment,
dd_tenDiemDen varchar(50) not null,
dd_moTa varchar(50) not null,
dd_giaTrungBinh int not null unique,
tp_id int not null,
FOREIGN KEY (tp_id) REFERENCES ThanhPho(tp_id)
);

CREATE TABLE KhachHang (
kh_id int primary key auto_increment,
kh_hoten varchar (50) not null,
kh_cmnd int not null,
kh_ngaysinh date not null,
tp_id int not null,
FOREIGN KEY (tp_id) REFERENCES ThanhPho(tp_id)
);

CREATE TABLE ThanhPho (
tp_id int primary key auto_increment,
tp_tenthanhpho varchar(50) not null);

CREATE TABLE BangTour (
bt_id int primary key auto_increment,
bt_maTour int not null,
lt_id int not null,
bt_price int not null,
bt_startDay date not null,
bt_endDay date not null,
dd_id int not null,
FOREIGN KEY (lt_id) REFERENCES LoaiTour(lt_id),
FOREIGN KEY (dd_id) REFERENCES DiemDenDuLich(dd_id)
);

CREATE TABLE LoaiTour (
lt_id int primary key auto_increment,
lt_maLoaiTour varchar(10) not null,
lt_tenloaiTour varchar(50) not null);

CREATE TABLE HoaDonTour (
hdt_id int primary key auto_increment,
bt_id int not null,
kh_id int not null,
hdt_status varchar(50) not null,
FOREIGN KEY (bt_id) REFERENCES BangTour(bt_id),
FOREIGN KEY (kh_id) REFERENCES KhachHang(kh_id)
);

INSERT INTO ThanhPho (`tp_tenthanhpho`)
VALUE ('Hà Nội'),('Hồ Chí Minh'),('Đà Nẵng'),('Đà Lạt'),('Phú Quốc');

INSERT INTO KhachHang (`kh_hoten`,`kh_cmnd`,`kh_ngaysinh`,`tp_id`)
VALUE ('Nguyễn Hồng Nam','0123456789','2000-11-12','1'),
('Trần Quang Tuyến','0123456788','2002-02-02','3'),
('Hà Thanh Long','0123456777','1996-03-03','4'),
('Hoàng Minh Tiến','0123456666','1998-04-04','2'),
('Nguyễn Trọng Hiếu','0123455555','1999-05-05','2'),
('Trần Tấn Huấn','0123444444','1998-06-06','3'),
('Dương Văn Trung','0123333333','1994-07-07','3'),
('Nguyễn Duy Tiến','01222222222','1992-08-08','2'),
('Lê Văn Hùng','0111111111','2003-09-09','4'),
('Dương Quốc Cường','0101010101','1998-10-11','5');

INSERT INTO DiemDenDuLich(`dd_tenDiemDen`,`dd_moTa`,`dd_giaTrungBinh`,`tp_id`)
VALUE ('Phố Cổ','Tham quan 36 phố cổ tại Hà Nội','4200000','1'),
('Công viên nước Đầm Sen','Tham gia hết các trò chơi tại công viên','3800000','2'),
('Bà Nà Hills','Đi bộ lên đỉnh Bà Nà Hills','8800000','3'),
('Resort Nghỉ dưỡng','Ngủ','6300000','4'),
('Hòn Đồi Mồi ','Thử thách sinh tồn trên đảo','7500000','5');

INSERT INTO LoaiTour (`lt_maLoaiTour`,`lt_tenloaiTour`)
VALUE ('DL654853','Du lịch nghỉ dưỡng'),
('DL869214','Du lịch văn hóa');

INSERT INTO BangTour (`bt_maTour`,`lt_id`,`bt_price`,`bt_startDay`,`bt_endDay`,`dd_id`)
VALUE ('456152','1','7500000','2020-01-30','2020-02-05','5'),
('865484','2','4200000','2020-01-31','2020-02-03','1'),
('514893','1','3800000','2020-01-28','2020-02-08','2'),
('654512','2','4200000','2020-02-05','2020-02-20','1'),
('032051','2','8800000','2020-02-10','2020-02-20','3'),
('652012','2','8800000','2020-02-15','2020-02-28','3'),
('021236','1','7500000','2020-02-26','2020-03-03','5'),
('321508','1','6300000','2020-03-02','2020-03-10','4'),
('031646','2','4200000','2020-03-05','2020-03-20','1'),
('948120','1','6300000','2020-03-12','2020-03-16','4'),
('654891','1','3800000','2020-03-20','2020-03-28','2'),
('654813','1','7500000','2020-03-18','2020-03-25','5'),
('849130','2','8800000','2020-03-20','2020-03-25','3'),
('031354','2','4200000','2020-03-27','2020-04-05','1'),
('613798','1','6300000','2020-03-30','2020-04-07','4');

INSERT INTO HoaDonTour(`bt_id`,`kh_id`,`hdt_status`)
VALUE ('3','1','Đã đặt'),
('1','2','Sẵn sàng'),
('10','3','Đã đặt'),
('8','2','Đang chờ'),
('7','4','Sẵn sàng'),
('2','5','Đã đặt'),
('5','1','Đang chờ'),
('9','7','Đã đặt'),
('6','9','Sẵn sàng'),
('4','1','Đang chờ');

----- Thống kê số lượng tour và thu nhập của các thành phố
SELECT tp.tp_id, tp.tp_tenthanhpho, count(dd.tp_id) AS 'SoTour', sum(bt.bt_price) AS 'ThuNhap'
FROM thanhpho tp
JOIN diemdendulich dd ON dd.tp_id = tp.tp_id
JOIN bangtour bt ON bt.dd_id = dd.dd_id
GROUP BY tp.tp_id;

----- Tính số tour có ngày bắt đầu trong tháng 3 năm 2020
SELECT month(bt_startDay) AS 'Thang3/2020', count(*) AS 'SoTour' 
FROM bangtour 
WHERE month(bt_startDay) = 3
AND year(bt_startDay) = 2020;

----- Tính số tour có ngày kết thúc trong tháng 4 năm 2020
SELECT month(bt_endDay) AS 'Thang4/2020', count(*) AS 'SoTour'
FROM bangtour
WHERE month(bt_endDay) = 4
AND YEAR (bt_endDay) = 2020;

----- Tổng thu nhập của các loại tour
SELECT lt.lt_id, lt.lt_maLoaiTour, lt.lt_tenloaiTour, sum(bt_price) AS 'ThuNhap'
FROM loaiTour lt
JOIN bangTour bt ON lt.lt_id = bt.lt_id
GROUP BY lt.lt_id;

----- Khách hàng tham gia nhiều tour nhất
SELECT * FROM tour_views
WHERE SoTour = (SELECT max(SoTour) FROM tour_views);

CREATE VIEW tour_views AS
SELECT kh.kh_id, kh.kh_hoten, count(hdt_id) 'SoTour'
FROM khachhang kh
JOIN hoadontour hdt ON hdt.hdt_id = kh.kh_id
GROUP BY hdt.kh_id; 

----- Xóa khách hàng chưa tham gia tour nào
DELETE FROM khachhang kh
WHERE NOT EXISTS (SELECT * FROM hoadontour hdt
					WHERE hdt.kh_id = kh.kh_id);