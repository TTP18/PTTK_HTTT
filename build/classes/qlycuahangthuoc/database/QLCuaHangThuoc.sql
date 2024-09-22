

------------------------------------------------Quan Ly Cua Hang Thuoc-------------------------------------

-- Tạo cơ sở dữ liệu
CREATE DATABASE QLCUAHANGTHUOC;
GO

-- Sử dụng cơ sở dữ liệu mới tạo
USE QLCUAHANGTHUOC;
GO

-- Đặt ngày tháng theo định dạng DMY
SET DATEFORMAT DMY;
GO

-- Tạo bảng NHANVIEN
CREATE TABLE NHANVIEN
(
    MaNV VARCHAR(50) PRIMARY KEY,
    HoTen NVARCHAR(100) NOT NULL,
    NgaySinh DATE NOT NULL,
    DiaChi NVARCHAR(100),
    SDT VARCHAR(100),
    CMND INT NOT NULL UNIQUE
);
GO

-- Tạo bảng TAIKHOAN
CREATE TABLE TAIKHOAN
(
    UserName VARCHAR(50) NOT NULL,
    Pass VARCHAR(50) NOT NULL,
    idNhanVien VARCHAR(50) NOT NULL,
    idTaiKhoan VARCHAR(50) PRIMARY KEY,
    loaitk INT not null,  -- 1: nếu là admin, 2: nếu là nhân viên

    FOREIGN KEY (idNhanVien) REFERENCES NHANVIEN(MaNV)
);
GO

-- Tạo bảng KHACHHANG
CREATE TABLE KHACHHANG
(
    MaKH VARCHAR(50) PRIMARY KEY,
    HoTen NVARCHAR(100) NOT NULL,
    NgaySinh DATE NOT NULL,
    DiaChi NVARCHAR(100),
    SDT VARCHAR(100)
);
GO

-- Tạo bảng NHACUNGCAP
CREATE TABLE NHACUNGCAP
(
    MaNCC VARCHAR(50) PRIMARY KEY,
    TenNCC NVARCHAR(100) NOT NULL,
    DiaChi NVARCHAR(100),
    SDT VARCHAR(100)
);
GO

-- Tạo bảng HOADON
CREATE TABLE HOADON
(
    MaHD VARCHAR(50) PRIMARY KEY,
    MaKH VARCHAR(50) NOT NULL,
    MaNV VARCHAR(50) NOT NULL,
    NgayLap DATE NOT NULL,

    FOREIGN KEY (MaKH) REFERENCES KHACHHANG(MaKH),
    FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV)
);
GO

-- Tạo bảng PHANLOAITHUOC 
CREATE TABLE PHANLOAITHUOC
(
    MaLoai VARCHAR(50) PRIMARY KEY,
    TenLoai NVARCHAR(100) NOT NULL
);
GO

-- Tiếp theo, tạo bảng THUOC
CREATE TABLE THUOC
(
    MaThuoc VARCHAR(50) PRIMARY KEY,
    TenThuoc NVARCHAR(100) NOT NULL,
    GiaBan MONEY NOT NULL,
    SoLuong INT NOT NULL,
    HanSuDung DATE,
    MaNCC VARCHAR(50),
    MaLoai VARCHAR(50),

    FOREIGN KEY (MaNCC) REFERENCES NHACUNGCAP(MaNCC),
    FOREIGN KEY (MaLoai) REFERENCES PHANLOAITHUOC(MaLoai)
);
GO

-- Tạo bảng CTHD
CREATE TABLE CTHD
(
    MaHD VARCHAR(50) NOT NULL,
    MaThuoc VARCHAR(50) NOT NULL,
    SoLuong INT NOT NULL,
    Thanhtien MONEY DEFAULT '0',

    FOREIGN KEY (MaHD) REFERENCES HOADON(MaHD),
    FOREIGN KEY (MaThuoc) REFERENCES THUOC(MaThuoc)
);
GO

-- Tạo bảng NHAPTHUOC
CREATE TABLE NHAPTHUOC
(
    MaPhieuNhap VARCHAR(50) PRIMARY KEY,
    MaNV VARCHAR(50) NOT NULL,
    NgayNhap DATE NOT NULL,
    MaNCC VARCHAR(50) NOT NULL,

    FOREIGN KEY (MaNV) REFERENCES NHANVIEN(MaNV),
    FOREIGN KEY (MaNCC) REFERENCES NHACUNGCAP(MaNCC)
);
GO

-- Tạo bảng CTPNHAP
CREATE TABLE CTPNHAP
(
    MaPhieuNhap VARCHAR(50) NOT NULL,
    MaThuoc VARCHAR(50) NOT NULL,
    SoLuongNhap INT NOT NULL,
    Thanhtien MONEY DEFAULT '0',

    FOREIGN KEY (MaPhieuNhap) REFERENCES NHAPTHUOC(MaPhieuNhap),
    FOREIGN KEY (MaThuoc) REFERENCES THUOC(MaThuoc)
);
GO

-- Tạo bảng KHOTHUOC
CREATE TABLE KHOTHUOC
(
    MaKho VARCHAR(50) PRIMARY KEY,
    MaPhieuNhap VARCHAR(50) NOT NULL,
    MaThuoc VARCHAR(50) NOT NULL,
    SoLuongMoiLoai INT NOT NULL,
    SoLoaiThuoc INT NOT NULL,

    FOREIGN KEY (MaPhieuNhap) REFERENCES NHAPTHUOC(MaPhieuNhap),
    FOREIGN KEY (MaThuoc) REFERENCES THUOC(MaThuoc)
);
GO

--Thêm dữ liệu vào bảng

INSERT INTO NHANVIEN (MaNV, HoTen, NgaySinh, DiaChi, SDT, CMND)
VALUES 
    ('NV001', 'Nguyen Van A', '1990-01-01', N'123 Đường ABC', '0123456789', 123456789),
    ('NV002', 'Tran Thi B', '1995-02-02', N'456 Đường XYZ', '0987654321', 987654321),
    ('NV003', 'Le Van C', '1985-03-03', N'789 Đường DEF', '0369852147', 456123789),
    ('NV004', 'Pham Thi D', '1988-04-04', N'101 Đường GHI', '0258741963', 789456123),
    ('NV005', 'Hoang Van E', '1992-05-05', N'222 Đường KLM', '0369852147', 123789456);

INSERT INTO KHACHHANG (MaKH, HoTen, NgaySinh, DiaChi, SDT)
VALUES 
    ('KH001', 'Le Van C', '1985-03-03', N'789 Đường DEF', '0369852147'),
    ('KH002', 'Pham Thi D', '1988-04-04', N'101 Đường GHI', '0258741963'),
    ('KH003', 'Tran Van E', '1990-05-05', N'222 Đường KLM', '0369852147'),
    ('KH004', 'Nguyen Thi F', '1993-06-06', N'333 Đường NOP', '0258741963'),
    ('KH005', 'Hoang Van G', '1986-07-07', N'444 Đường QRS', '0369852147');

INSERT INTO NHACUNGCAP (MaNCC, TenNCC, DiaChi, SDT)
VALUES 
    ('NCC001', 'Công ty A',N'XYZ Street', '0123456789'),
    ('NCC002', 'Công ty B',N'ABC Street', '0987654321'),
    ('NCC003', 'Công ty C',N'DEF Street', '0369852147'),
    ('NCC004', 'Công ty D',N'GHI Street', '0258741963'),
    ('NCC005', 'Công ty E',N'KLM Street', '0369852147');

INSERT INTO HOADON (MaHD, MaKH, MaNV, NgayLap)
VALUES 
    ('HD001', 'KH001', 'NV001', '2024-04-25'),
    ('HD002', 'KH002', 'NV002', '2024-04-26'),
    ('HD003', 'KH003', 'NV003', '2024-04-27'),
    ('HD004', 'KH004', 'NV004', '2024-04-28'),
    ('HD005', 'KH005', 'NV005', '2024-04-29');

INSERT INTO PHANLOAITHUOC (MaLoai, TenLoai)
VALUES 
    ('L001', 'Loại 1'),
    ('L002', 'Loại 2'),
    ('L003', 'Loại 3'),
    ('L004', 'Loại 4'),
    ('L005', 'Loại 5');

INSERT INTO THUOC (MaThuoc, TenThuoc, GiaBan, SoLuong, HanSuDung, MaNCC, MaLoai)
VALUES 
    ('T001', 'Thuốc 1', 50000, 100, '2024-12-31', 'NCC001', 'L001'),
    ('T002', 'Thuốc 2', 80000, 50, '2025-06-30', 'NCC002', 'L002'),
    ('T003', 'Thuốc 3', 30000, 200, '2023-11-30', 'NCC003', 'L003'),
    ('T004', 'Thuốc 4', 60000, 150, '2024-09-30', 'NCC004', 'L004'),
    ('T005', 'Thuốc 5', 40000, 120, '2025-08-31', 'NCC005', 'L005');

INSERT INTO TAIKHOAN (UserName, Pass, idNhanVien, idTaiKhoan, loaitk)
VALUES 
    ('admin', 'admin123', 'NV001', 'TK001', 1),
    ('employee1', '123456', 'NV002', 'TK002', 2),
    ('employee2', 'password', 'NV003', 'TK003', 2),
    ('employee3', 'qwerty', 'NV004', 'TK004', 2),
    ('employee4', 'abc123', 'NV005', 'TK005', 2);

-- Chèn dữ liệu vào bảng CTHD
INSERT INTO CTHD (MaHD, MaThuoc, SoLuong, Thanhtien)
VALUES 
    ('HD001', 'T001', 2, 100000),
    ('HD002', 'T002', 1, 80000),
    ('HD003', 'T003', 3, 90000),
    ('HD004', 'T004', 2, 120000),
    ('HD005', 'T005', 4, 160000);

-- Chèn dữ liệu vào bảng NHAPTHUOC
INSERT INTO NHAPTHUOC (MaPhieuNhap, MaNV, NgayNhap, MaNCC)
VALUES 
    ('PN001', 'NV001', '2024-04-20', 'NCC001'),
    ('PN002', 'NV002', '2024-04-21', 'NCC002'),
    ('PN003', 'NV003', '2024-04-22', 'NCC003'),
    ('PN004', 'NV004', '2024-04-23', 'NCC004'),
    ('PN005', 'NV005', '2024-04-24', 'NCC005');

-- Chèn dữ liệu vào bảng CTPNHAP
INSERT INTO CTPNHAP (MaPhieuNhap, MaThuoc, SoLuongNhap, Thanhtien)
VALUES 
    ('PN001', 'T001', 5, 250000),
    ('PN002', 'T002', 3, 240000),
    ('PN003', 'T003', 4, 120000),
    ('PN004', 'T004', 6, 360000),
    ('PN005', 'T005', 7, 280000);

-- Chèn dữ liệu vào bảng KHOTHUOC
INSERT INTO KHOTHUOC (MaKho, MaPhieuNhap, MaThuoc, SoLuongMoiLoai, SoLoaiThuoc)
VALUES 
    ('K001', 'PN001', 'T001', 100, 1),
    ('K002', 'PN002', 'T002', 50, 1),
    ('K003', 'PN003', 'T003', 200, 1),
    ('K004', 'PN004', 'T004', 150, 1),
    ('K005', 'PN005', 'T005', 120, 1);

/*
--Xóa dữ liệu trong bảng
-- Xóa dữ liệu từ bảng CTPNHAP
DELETE FROM CTPNHAP;

-- Xóa dữ liệu từ bảng KHOTHUOC
DELETE FROM KHOTHUOC;

-- Xóa dữ liệu từ bảng NHAPTHUOC
DELETE FROM NHAPTHUOC;

-- Xóa dữ liệu từ bảng CTHD
DELETE FROM CTHD;

-- Xóa dữ liệu từ bảng HOADON
DELETE FROM HOADON;

-- Xóa dữ liệu từ bảng THUOC
DELETE FROM THUOC;

-- Xóa dữ liệu từ bảng PHANLOAITHUOC
DELETE FROM PHANLOAITHUOC;

-- Xóa dữ liệu từ bảng NHACUNGCAP
DELETE FROM NHACUNGCAP;

-- Xóa dữ liệu từ bảng KHACHHANG
DELETE FROM KHACHHANG;

-- Xóa dữ liệu từ bảng TAIKHOAN
DELETE FROM TAIKHOAN;

-- Xóa dữ liệu từ bảng NHANVIEN
DELETE FROM NHANVIEN;

-- Xóa các bảng
DROP TABLE IF EXISTS KHOTHUOC;
DROP TABLE IF EXISTS CTPNHAP;
DROP TABLE IF EXISTS NHAPTHUOC;
DROP TABLE IF EXISTS PHANLOAITHUOC;
DROP TABLE IF EXISTS THUOC;
DROP TABLE IF EXISTS CTHD;
DROP TABLE IF EXISTS HOADON;
DROP TABLE IF EXISTS NHACUNGCAP;
DROP TABLE IF EXISTS KHACHHANG;
DROP TABLE IF EXISTS TAIKHOAN;
DROP TABLE IF EXISTS NHANVIEN;

-- Xóa cơ sở dữ liệu
DROP DATABASE IF EXISTS QLCUAHANGTHUOC; */


