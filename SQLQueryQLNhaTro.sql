-- 1. Tạo Database
CREATE DATABASE QuanLyNhaTro;
GO
USE QuanLyNhaTro;
GO

-- 2. Bảng Tài khoản
CREATE TABLE TaiKhoan (
    Username VARCHAR(50) PRIMARY KEY,
    Password VARCHAR(50) NOT NULL,
    Role INT -- 1: Admin, 0: Guest
);

-- 3. Bảng Chủ Trọ
CREATE TABLE ChuTro (
    MaChuTro VARCHAR(12) PRIMARY KEY,
    HoTen NVARCHAR(100),
    GioiTinh NVARCHAR(10),
    NgaySinh DATE, -- Đã chuyển sang DATE
    DiaChi NVARCHAR(255),
    SDT VARCHAR(15)
);

-- 4. Bảng Khách Hàng
CREATE TABLE KhachHang (
    MaKhachHang VARCHAR(12) PRIMARY KEY,
    HoTen NVARCHAR(100),
    GioiTinh NVARCHAR(10),
    NgaySinh DATE, -- Đã chuyển sang DATE
    SDT VARCHAR(15),
    QueQuan NVARCHAR(100),
    NgheNghiep NVARCHAR(100)
);

-- 5. Bảng Nhà Trọ
CREATE TABLE NhaTro (
    MaNha VARCHAR(10) PRIMARY KEY,
    TenNha NVARCHAR(100),
    DiaChi NVARCHAR(255),
    MaChuTro VARCHAR(12),
    FOREIGN KEY (MaChuTro) REFERENCES ChuTro(MaChuTro)
);

-- 6. Bảng Phòng Trọ
CREATE TABLE PhongTro (
    MaPhong VARCHAR(10) PRIMARY KEY,
    MaNha VARCHAR(10),
    GiaThue FLOAT,
    DienTich INT,
    TrangThai NVARCHAR(20),
    LoaiPhong NVARCHAR(20),
    TienNghi NVARCHAR(50),
    FOREIGN KEY (MaNha) REFERENCES NhaTro(MaNha)
);

-- 7. Bảng Thuê Phòng
CREATE TABLE ThuePhong (
    MaPhong VARCHAR(10),
    MaKhachHang VARCHAR(12),
    TienDatCoc FLOAT,
    NgayBatDau DATE, -- Đã chuyển sang DATE
    NgayKetThuc DATE, -- Đã chuyển sang DATE
    PRIMARY KEY (MaPhong, MaKhachHang),
    FOREIGN KEY (MaPhong) REFERENCES PhongTro(MaPhong),
    FOREIGN KEY (MaKhachHang) REFERENCES KhachHang(MaKhachHang)
);

-- 8. Bảng Hóa Đơn
CREATE TABLE HoaDon (
    MaHD VARCHAR(10) PRIMARY KEY,
    MaPhong VARCHAR(10),
    TienPhong FLOAT,
    TienDien FLOAT,
    TienNuoc FLOAT,
    TienDV FLOAT,
    TongTien FLOAT,
    NgayLap DATE, -- Đã chuyển sang DATE
    TrangThai NVARCHAR(20),
    FOREIGN KEY (MaPhong) REFERENCES PhongTro(MaPhong)
);
GO

-- ---------------------------------------------------------
-- CHÈN DỮ LIỆU MẪU (ĐỊNH DẠNG CHUẨN YYYY-MM-DD)
-- ---------------------------------------------------------

-- Chủ trọ & Khách hàng
INSERT INTO ChuTro VALUES 
('1082946357', N'Nguyen Van A', N'Nam', '1980-04-01', N'08 Ha Van Tinh, phuong Hoa Khanh, Tp.Da Nang', '0383145674'),
('201564789321', N'Lê Thị Lan', N'Nữ', '1975-05-15', N'45 Ngô Quyền, Sơn Trà, Đà Nẵng', '0905123456'),
('302456123789', N'Trần Văn Hùng', N'Nam', '1982-11-20', N'120 Núi Thành, Hải Châu, Đà Nẵng', '0914987654');

INSERT INTO KhachHang VALUES  
('012345678901', N'Nguyen Van An', N'Nam', '2004-07-05', '0912345678', N'Thái Bình', N'sinh vien'),
('123456789012', N'Nguyen Duc Cuong', N'Nam', '2000-05-13', '0987654321', N'Quảng Ninh', N'lap trinh vien'),
('234567890123', N'Phan Thi My Tam', N'Nu', '2002-01-16', '0901234567', N'Da Nang', N'giao vien'),
('111111111111', N'Nguyen A', N'Nu', '2005-02-20', '0346821405', N'Da Nang', N'sinh vien'),
('345678901234', N'Hoang Thuy Linh', N'Nu', '1999-08-11', '0976543210', N'Hue', N'bac si'),
('567890123456', N'Nguyen Phuoc Thinh', N'Nam', '2002-02-22', '0967890123', N'Quang Tri', N'ky su'),
('789012345678', N'Nguyen Cong Phuong', N'Nam', '1998-01-21', '0945678901', N'Nghe An', N'giao vien');

-- Nhà trọ & Phòng trọ
INSERT INTO NhaTro VALUES  
('A01', N'Nha tro DMC', N'so 08,Ha Van Tinh,Hoa Khanh Nam,Lien Chieu,Da Nang', '1082946357'),
('A02', N'Nha tro Sinh Vien', N'so 14,Duong Dinh Nghe,An Hai Bac,Son Tra,Da Nang', '1082946357'),
('B01', N'Nhà trọ Hoa Hồng', N'22 Lê Văn Hiến, Ngũ Hành Sơn, Đà Nẵng', '201564789321'),
('C01', N'Ký túc xá Tư nhân Cẩm Lệ', N'15 Cách Mạng Tháng 8, Cẩm Lệ, Đà Nẵng', '302456123789');

INSERT INTO PhongTro VALUES  
('A01001', 'A01', 2000000, 20, N'DaThue', 'Small', 'Coban'),
('A01002', 'A01', 2500000, 20, N'DaThue', 'Small', 'CaoCap'),
('A01003', 'A01', 3000000, 30, N'DaThue', 'Medium', 'Coban'),
('A01005', 'A01', 3500000, 30, N'Trong', 'Medium', 'CaoCap'),
('B01001', 'B01', 3000000, 25, N'DaThue', 'Medium', 'CaoCap'),
('B01002', 'B01', 3000000, 25, N'Trong', 'Medium', 'CaoCap'),
('C01001', 'C01', 1500000, 15, N'DaThue', 'Small', 'Coban'),
('C01002', 'C01', 1500000, 15, N'DaThue', 'Small', 'Coban');

-- Thuê phòng
INSERT INTO ThuePhong VALUES  
('A01001', '012345678901', 2000000, '2025-07-05', '2025-12-05'),
('A01002', '123456789012', 2500000, '2025-07-10', '2025-12-10'),
('A01003', '111111111111', 2000000, '2025-12-24', '2026-02-24'),
('B01001', '345678901234', 3000000, '2026-01-01', '2027-01-01'),
('C01001', '567890123456', 1500000, '2026-02-15', '2026-08-15'),
('C01002', '789012345678', 1500000, '2026-03-01', '2027-03-01');

-- Hóa đơn
INSERT INTO HoaDon VALUES  
('HD101', 'A01001', 2000000, 180000, 30000, 15000, 2225000, '2025-10-01', N'DaNop'),
('HD102', 'A01001', 2000000, 170000, 30000, 25000, 2225000, '2025-11-01', N'ChuaNop'),
('HD201', 'B01001', 3000000, 250000, 50000, 30000, 3330000, '2026-02-01', N'DaNop'),
('HD202', 'C01001', 1500000, 120000, 40000, 10000, 1670000, '2026-03-01', N'ChuaNop'),
('HD203', 'C01002', 1500000, 100000, 40000, 10000, 1650000, '2026-04-01', N'ChuaNop');

-- Tài khoản
INSERT INTO TaiKhoan VALUES 
('admin', '123', 1), 
('guest1', '123', 0), 
('guest2', '123', 0),
('guest3', '123', 0),
('linhht', '444', 0),
('thinhnp', '555', 0),
('phuongnc', '666', 0);