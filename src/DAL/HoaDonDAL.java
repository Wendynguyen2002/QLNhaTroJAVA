package DAL;

import DTO.entity.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAL {

    private Connection conn;

    public HoaDonDAL() {
        conn = DBConnection.getConnection();
    }

    // ========================
    // 1. Lấy tất cả / By ID / By FK
    // ========================

    public List<HoaDon> getAll() {
        return new ArrayList<>();
    }

    public HoaDon getById(String maHD) {
    	
    	// Querry.....??
        return null;
    }

    public List<HoaDon> getByMaPhong(String maPhong) {
    	
    	// Querry.....??
        return new ArrayList<>();
    }

    // ========================
    // 2. Thêm
    // ========================

    public boolean insert(HoaDon hd) {
    	// Querry.....???
        return false;
    }

    // ========================
    // 3. Update
    // ========================

    public boolean update(HoaDon hd) {
    	// Querry.....??
        return false;
    }

    // ========================
    // 4. Xoá byID / Xoá by FK
    // ========================

    public boolean delete(String maHD) {
        return false;
    }

    public boolean deleteByMaPhong(String maPhong) {
        return false;
    }

    // ========================
    // 5. Check tồn tại
    // ========================

    public boolean exists(String maHD) {
        return false;
    }
}