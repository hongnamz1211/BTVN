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
VALUE ('D????ng','Trung','1994-12-20','2013-02-12','B???c Ninh','0123456789','5000000','500000'),
('Nguy???n','Ti???n','1992-10-12','2013-07-15','B???c Ninh','0123456788','5100000','400000'),
('Tr???n','Hu???n','1998-08-25','2013-04-13','H???i D????ng','0123456777','4900000','600000'),
('Nguy???n','H??ng','2003-10-06','2013-02-05','H???i D????ng','0123456666','4800000','700000'),
('Nguy???n','Nam','2000-11-12','2013-05-14','H?? N???i','0868886855','3000000','800000');

INSERT INTO khachhang (`tencongty`,`tengiaodich`,`diachi`,`email`,`dienthoai`,`fax`)
VALUE ('ABC','?????ng h???','HCM','abc@gmail.com','0987654321','1122334455'),
('XYZ','??i???n tho???i','???? N???ng','xyz@gmail.com','0987654322','1122332211'),
('Codegym','M??y t??nh','H?? N???i','codeym@gmail.com','0987654333','1122338888'),
('C1021H1','Tivi','H?? N???i','c1021h1@gmail.com','0987654444','1122339999');

INSERT INTO nhacungcap (`tencongty`,`tengiaodich`,`diachi`,`dienthoai`,`fax`,`email`)
VALUE ('CTY ?????ng H???','Apple Watch','C???n Th??','0999999999','99999999','ctydongho@gmail.com'),
('CTY M??y gi???t','Panasonic','Gia Lai','0888888888','88888888','ctymaygiat@gmail.com'),
('CTY Tivi','Tivi Samsung','H?? N???i','0777777777','77777777','ctytivi@gmail.com'),
('CTY M??y T??nh','Ryzen','H?? N???i','0666666666','66666666','ctymaytinh@gmail.com'),
('CTY ??i???n tho???i','Iphone','HCM','0555555555','55555555','ctydienthoai@gmail.com');

INSERT INTO loaihang(`tenloaihang`)
VALUE ('?????ng H???'),('M??y gi???t'),('Tivi'),('M??y t??nh'),('Iphone'),('M??y in'),('Xe m??y');

ALTER TABLE `baitap5.17.1`.`mathang` 
CHANGE COLUMN `DonViTinh` `DonViTinh` VARCHAR(50) NOT NULL ;

INSERT INTO mathang(`tenhang`,`macongty`,`maloaihang`,`soluong`,`donvitinh`,`giahang`)
VALUE ('Apple Watch','1','1','5','chi???c','500000'),
('Panasonic','2','2','9','chi???c','900000'),
('Tivi Samsung','3','3	','12','chi???c','3200000'),
('Ryzen','4','4','8','chi???c','2600000'),
('Iphone','5','5','18','chi???c','5000000');

INSERT INTO dondathang(`makhachhang`,`manhanvien`,`ngaydathang`,`ngaygiaohang`,`ngaychuyenhang`,`noigiaohang`)
VALUE ('1','2','2015-02-12','2015-02-13','2015-02-20','H?? N???i'),
('2','5','2015-03-20','2015-03-22','2015-04-01','HCM'),
('1','3','2016-04-22','2016-05-01','2016-05-11','H?? N???i'),
('3','5','2016-10-11','2016-10-15','2016-10-29','H?? N???i'),
('4','1','2015-09-02','2015-09-05','2015-09-15','???? N???ng'),
('4','3','2015-12-25','2016-01-02','2016-01-08','HCM'),
('1','3','2015-06-22','2015-06-24','2015-08-01','HCM'),
('2','1','2016-11-30','2016-11-30','2016-12-15','???? N???ng');

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
SELECT nv.ho, nv.ten, nv.diachi, (nv.luongcoban + nv.phucap) AS 'T???ng l????ng'
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
SELECT kh.makhachhang, kh.tencongty, kh.diachi, count(*) 'S??? ????n h??ng' 
FROM khachhang kh
JOIN dondathang ddh ON ddh.makhachhang = kh.makhachhang
GROUP BY ddh.makhachhang
HAVING count(*) = 1;

--- 7
INSERT INTO khachhang (`tencongty`,`tengiaodich`,`diachi`,`email`,`dienthoai`,`fax`)
VALUE ('ch?? Ti???n','chu???i','B???c Ninh','chutien@gmail.com','0555555555','12345678');

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
SELECT CT.MaHang 'M?? h??ng', M.TenHang 'T??n h??ng',
	SUM(CASE month(D.NgayDatHang) WHEN 1 THEN CT.SoLuong ELSE 0 END) `Th??ng 1`,
	SUM(CASE month(D.NgayDatHang) WHEN 2 THEN CT.SoLuong ELSE 0 END) `Th??ng 2`,
	SUM(CASE month(D.NgayDatHang) WHEN 3 THEN CT.SoLuong ELSE 0 END) `Th??ng 3`,
	SUM(CASE month(D.NgayDatHang) WHEN 4 THEN CT.SoLuong ELSE 0 END) `Th??ng 4`,
	SUM(CASE month(D.NgayDatHang) WHEN 5 THEN CT.SoLuong ELSE 0 END) `Th??ng 5`,
	SUM(CASE month(D.NgayDatHang) WHEN 6 THEN CT.SoLuong ELSE 0 END) `Th??ng 6`,	
	SUM(CASE month(D.NgayDatHang) WHEN 7 THEN CT.SoLuong ELSE 0 END) `Th??ng 7`,
	SUM(CASE month(D.NgayDatHang) WHEN 8 THEN CT.SoLuong ELSE 0 END) `Th??ng 8`,
	SUM(CASE month(D.NgayDatHang) WHEN 9 THEN CT.SoLuong ELSE 0 END) `Th??ng 9`,
	SUM(CASE month(D.NgayDatHang) WHEN 10 THEN CT.SoLuong ELSE 0 END) `Th??ng 10`,
	SUM(CASE month(D.NgayDatHang) WHEN 11 THEN CT.SoLuong ELSE 0 END) `Th??ng 11`,
	SUM(CASE month(D.NgayDatHang) WHEN 12 THEN CT.SoLuong ELSE 0 END) `Th??ng 12`,
    SUM(CT.SoLuong) as `C??? n??m`
	FROM donDatHang D 
    JOIN chiTietDatHang CT ON D.SoHoaDon = CT.SoHoaDon
    JOIN MatHang M ON M.MaHang = CT.MaHang
    WHERE year(D.NgayDatHang) = 2015 
    GROUP BY M.MaHang;