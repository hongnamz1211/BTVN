create database `baitap5.17.1`;
use `baitap5.17.1`;

create table chiTietDatHang(
SoHoaDon int auto_increment,
MaHang int,
GiaBan int not null,
SoLuong int not null,
MucGiamGia int not null,
PRIMARY KEY (SoHoaDon, MaHang),
FOREIGN KEY (SoHoaDon) REFERENCES DonDatHang(SoHoaDon),
FOREIGN KEY (MaHang) REFERENCES MatHang(MaHang)
);

CREATE TABLE donDatHang(
SoHoaDon int auto_increment primary key,
MaKhachHang int,
MaNhanVien int not null,
NgayDatHang date not null,
NgayGiaoHang date not null,
NgayChuyenHang date not null,
NoiGiaoHang varchar(50) not null,
FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang),
FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);

CREATE TABLE KhachHang(
MaKhachHang int auto_increment primary key,
TenCongTy varchar(50) not null,
TenGiaoDich varchar(50) not null,
DiaChi varchar(50) not null,
Email varchar(50) not null,
DienThoai varchar(50) not null,
Fax varchar(50) not null
);

CREATE TABLE NhanVien(
MaNhanVien int auto_increment primary key,
Ho varchar(10) not null,
Ten varchar(10) not null,
NgaySinh date not null,
NgayLamViec date  not null,
DiaChi varchar(50) not null,
DienThoai varchar(10) not null,
LuongCoBan int not null,
PhuCap int not null
);

ALTER TABLE `baitap5.17.1`.`nhanvien` 
CHANGE COLUMN `LuongCoBan` `LuongCoBan` DOUBLE NOT NULL ,
CHANGE COLUMN `PhuCap` `PhuCap` DOUBLE NOT NULL ;


CREATE TABLE MatHang(
MaHang int auto_increment primary key,
TenHang varchar(50) not null,
MaCongTy int not null,
MaLoaiHang int not null,
SoLuong int not null,
DonViTinh int not null,
GiaHang int not null,
FOREIGN KEY (MaCongTy) REFERENCES NhaCungCap(MaCongTy),
FOREIGN KEY (MaLoaiHang) REFERENCES LoaiHang(MaLoaiHang)
);

CREATE TABLE NhaCungCap(
MaCongTy int auto_increment primary key,
TenCongTy varchar(50) not null,
TenGiaoDich varchar(50) not null,
DiaChi varchar(50) not null,
DienThoai varchar(10) not null,
Fax varchar(50) not null,
Email varchar(50) not null
);

CREATE TABLE LoaiHang(
MaLoaiHang int auto_increment primary key,
TenLoaiHang varchar(50) not null
);

INSERT INTO nhanvien (`ho`,`ten`,`ngaysinh`,`ngaylamviec`,`diachi`,`dienthoai`,`luongcoban`,`phucap`)
VALUE ('Dương','Trung','1994-12-20','2013-02-12','Bắc Ninh','0123456789','5000000','500000'),
('Nguyễn','Tiến','1992-10-12','2013-07-15','Bắc Ninh','0123456788','5100000','400000'),
('Trần','Huấn','1998-08-25','2013-04-13','Hải Dương','0123456777','4900000','600000'),
('Nguyễn','Hùng','2003-10-06','2013-02-05','Hải Dương','0123456666','4800000','700000'),
('Nguyễn','Nam','2000-11-12','2013-05-14','Hà Nội','0868886855','3000000','800000');

INSERT INTO khachhang (`tencongty`,`tengiaodich`,`diachi`,`email`,`dienthoai`,`fax`)
VALUE ('ABC','Đồng hồ','HCM','abc@gmail.com','0987654321','1122334455'),
('XYZ','Điện thoại','Đà Nẵng','xyz@gmail.com','0987654322','1122332211'),
('Codegym','Máy tính','Hà Nội','codeym@gmail.com','0987654333','1122338888'),
('C1021H1','Tivi','Hà Nội','c1021h1@gmail.com','0987654444','1122339999');

INSERT INTO nhacungcap (`tencongty`,`tengiaodich`,`diachi`,`dienthoai`,`fax`,`email`)
VALUE ('CTY Đồng Hồ','Apple Watch','Cần Thơ','0999999999','99999999','ctydongho@gmail.com'),
('CTY Máy giặt','Panasonic','Gia Lai','0888888888','88888888','ctymaygiat@gmail.com'),
('CTY Tivi','Tivi Samsung','Hà Nội','0777777777','77777777','ctytivi@gmail.com'),
('CTY Máy Tính','Ryzen','Hà Nội','0666666666','66666666','ctymaytinh@gmail.com'),
('CTY Điện thoại','Iphone','HCM','0555555555','55555555','ctydienthoai@gmail.com');

INSERT INTO loaihang(`tenloaihang`)
VALUE ('Đồng Hồ'),('Máy giặt'),('Tivi'),('Máy tính'),('Iphone'),('Máy in'),('Xe máy');

ALTER TABLE `baitap5.17.1`.`mathang` 
CHANGE COLUMN `DonViTinh` `DonViTinh` VARCHAR(50) NOT NULL ;

INSERT INTO mathang(`tenhang`,`macongty`,`maloaihang`,`soluong`,`donvitinh`,`giahang`)
VALUE ('Apple Watch','1','1','5','chiếc','500000'),
('Panasonic','2','2','9','chiếc','900000'),
('Tivi Samsung','3','3	','12','chiếc','3200000'),
('Ryzen','4','4','8','chiếc','2600000'),
('Iphone','5','5','18','chiếc','5000000');

INSERT INTO dondathang(`makhachhang`,`manhanvien`,`ngaydathang`,`ngaygiaohang`,`ngaychuyenhang`,`noigiaohang`)
VALUE ('1','2','2015-02-12','2015-02-13','2015-02-20','Hà Nội'),
('2','5','2015-03-20','2015-03-22','2015-04-01','HCM'),
('1','3','2016-04-22','2016-05-01','2016-05-11','Hà Nội'),
('3','5','2016-10-11','2016-10-15','2016-10-29','Hà Nội'),
('4','1','2015-09-02','2015-09-05','2015-09-15','Đà Nẵng'),
('4','3','2015-12-25','2016-01-02','2016-01-08','HCM'),
('1','3','2015-06-22','2015-06-24','2015-08-01','HCM'),
('2','1','2016-11-30','2016-11-30','2016-12-15','Đà Nẵng');

ALTER TABLE `baitap5.17.1`.`chitietdathang` 
DROP FOREIGN KEY `chitietdathang_ibfk_1`;
ALTER TABLE `baitap5.17.1`.`chitietdathang` 
CHANGE COLUMN `SoHoaDon` `SoHoaDon` INT NOT NULL ;
ALTER TABLE `baitap5.17.1`.`chitietdathang` 
ADD CONSTRAINT `chitietdathang_ibfk_1`
  FOREIGN KEY (`SoHoaDon`)
  REFERENCES `baitap5.17.1`.`dondathang` (`SoHoaDon`);

ALTER TABLE `chitietdathang`
ADD CONSTRAINT `FK_sohoadon` FOREIGN KEY (`SoHoaDon`) REFERENCES `dondathang` (`SoHoaDon`);

INSERT INTO chitietdathang(`sohoadon`,`mahang`,`giaban`,`soluong`,`mucgiamgia`)
VALUE ('25','13','4000000','2','3800000'),
('26','15','8000000','6','7900000'),
('27','12','1300000','1','1100000'),
('28','14','3300000','5','3100000'),
('29','14','3300000','8','3050000'),
('30','13','3990000','4','3750000'),
('31','14','3300000','1','3250000'),
('32','11','900000','3','780000');

USE `baitap5.17.1`;

--- 1
SELECT nv.Ho, nv.Ten, nv.diachi, nv.ngaylamviec
FROM nhanvien nv;

--- 2
SELECT m.mahang, m.tenhang
FROM mathang m 
WHERE m.giahang > 100000
AND m.soluong < 50;

--- 3
SELECT m.mahang, m.tenhang, cc.macongty, cc.tencongty
FROM mathang m
JOIN nhacungcap cc
ON m.macongty = cc.macongty;

--- 4
SELECT nv.ho, nv.ten, nv.diachi, (nv.luongcoban + nv.phucap) AS 'Tổng lương'
FROM nhanvien nv;

--- 5
UPDATE nhanvien SET luongcoban = (luongcoban * 1.5)
WHERE manhanvien IN (SELECT manhanvien FROM test WHERE tongsoluong >= 10);

CREATE VIEW test AS
SELECT nv.manhanvien, ddh.sohoadon, sum(ctdh.soluong) as 'tongsoluong'
FROM nhanvien nv
JOIN dondathang ddh ON ddh.manhanvien = nv.manhanvien
JOIN chitietdathang ctdh ON ctdh.sohoadon = ddh.sohoadon
-- WHERE YEAR(ddh.ngaygiaohang) = 2015 
GROUP BY nv.manhanvien;

SELECT * FROM test;

--- 6
SELECT kh.makhachhang, kh.tencongty, kh.diachi, count(*) 'Số đơn hàng' 
FROM khachhang kh
JOIN dondathang ddh ON ddh.makhachhang = kh.makhachhang
GROUP BY ddh.makhachhang
HAVING count(*) = 1;

--- 7
INSERT INTO khachhang (`tencongty`,`tengiaodich`,`diachi`,`email`,`dienthoai`,`fax`)
VALUE ('chú Tiến','chuối','Bắc Ninh','chutien@gmail.com','0555555555','12345678');

SELECT * FROM khachhang;

DELETE FROM khachhang kh
WHERE NOT EXISTS (SELECT * FROM dondathang ddh
				  WHERE ddh.makhachhang = kh.makhachhang);
                  
--- 8
SELECT * FROM test
WHERE TongSoLuong = (SELECT max(TongSoLuong) FROM test);

--- 9
UPDATE nhanvien SET phucap = (phucap * 1.5)
WHERE manhanvien IN (SELECT manhanvien FROM test
WHERE TongSoLuong = (SELECT max(TongSoLuong) FROM test));

--- 10
SELECT CT.MaHang 'Mã hàng', M.TenHang 'Tên hàng',
	SUM(CASE month(D.NgayDatHang) WHEN 1 THEN CT.SoLuong ELSE 0 END) `Tháng 1`,
	SUM(CASE month(D.NgayDatHang) WHEN 2 THEN CT.SoLuong ELSE 0 END) `Tháng 2`,
	SUM(CASE month(D.NgayDatHang) WHEN 3 THEN CT.SoLuong ELSE 0 END) `Tháng 3`,
	SUM(CASE month(D.NgayDatHang) WHEN 4 THEN CT.SoLuong ELSE 0 END) `Tháng 4`,
	SUM(CASE month(D.NgayDatHang) WHEN 5 THEN CT.SoLuong ELSE 0 END) `Tháng 5`,
	SUM(CASE month(D.NgayDatHang) WHEN 6 THEN CT.SoLuong ELSE 0 END) `Tháng 6`,	
	SUM(CASE month(D.NgayDatHang) WHEN 7 THEN CT.SoLuong ELSE 0 END) `Tháng 7`,
	SUM(CASE month(D.NgayDatHang) WHEN 8 THEN CT.SoLuong ELSE 0 END) `Tháng 8`,
	SUM(CASE month(D.NgayDatHang) WHEN 9 THEN CT.SoLuong ELSE 0 END) `Tháng 9`,
	SUM(CASE month(D.NgayDatHang) WHEN 10 THEN CT.SoLuong ELSE 0 END) `Tháng 10`,
	SUM(CASE month(D.NgayDatHang) WHEN 11 THEN CT.SoLuong ELSE 0 END) `Tháng 11`,
	SUM(CASE month(D.NgayDatHang) WHEN 12 THEN CT.SoLuong ELSE 0 END) `Tháng 12`,
    SUM(CT.SoLuong) as `Cả năm`
	FROM donDatHang D 
    JOIN chiTietDatHang CT ON D.SoHoaDon = CT.SoHoaDon
    JOIN MatHang M ON M.MaHang = CT.MaHang
    WHERE year(D.NgayDatHang) = 2015 
    GROUP BY M.MaHang;