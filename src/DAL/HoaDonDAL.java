package DAL;

import DTO.entity.HoaDon;
import DTO.enums.TrangThaiHoaDon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HoaDonDAL {

    private DBHelper db = DBHelper.getInstance();

    // 1. GET ALL
    public List<HoaDon> getAll() {
        return db.query("SELECT * FROM HoaDon", this::map);
    }

    // 2. GET BY ID
    public HoaDon getById(String maHoaDon) {
        List<HoaDon> list = db.query("SELECT * FROM HoaDon WHERE MaHD=?", this::map, maHoaDon);
        return list.isEmpty() ? null : list.get(0);
    }

    // 3. EXISTS
    public boolean checkTonTai(String maHoaDon) {
        return !db.query("SELECT MaHD FROM HoaDon WHERE MaHD=?", this::map, maHoaDon).isEmpty();
    }

    // 4. GET BY MA HOP DONG
    public List<HoaDon> getByMaHopDong(int maHopDong) {
        return db.query("SELECT * FROM HoaDon WHERE MaHopDong=?", this::map, maHopDong);
    }

    // 5. INSERT
    public boolean insert(HoaDon hd) {
        return db.update(
                "INSERT INTO HoaDon(MaHD,MaHopDong,TienPhong,ChiSoDienCu,ChiSoDienMoi,ChiSoNuocCu,ChiSoNuocMoi,TienDV,NgayLap,TrangThai) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)",
                hd.getMaHoaDon(),
                hd.getMaHopDong(),
                hd.getTienPhong(),
                hd.getChiSoDienCu(),
                hd.getChiSoDienMoi(),
                hd.getChiSoNuocCu(),
                hd.getChiSoNuocMoi(),
                hd.getTienDV(),
                hd.getNgayLap(),
                hd.getTrangThai().name()
        ) > 0;
    }

    // 6. UPDATE
    public boolean update(HoaDon hd) {
        return db.update(
                "UPDATE HoaDon SET MaHopDong=?,TienPhong=?,ChiSoDienCu=?,ChiSoDienMoi=?,ChiSoNuocCu=?,ChiSoNuocMoi=?,TienDV=?,NgayLap=?,TrangThai=? " +
                "WHERE MaHD=?",
                hd.getMaHopDong(),
                hd.getTienPhong(),
                hd.getChiSoDienCu(),
                hd.getChiSoDienMoi(),
                hd.getChiSoNuocCu(),
                hd.getChiSoNuocMoi(),
                hd.getTienDV(),
                hd.getNgayLap(),
                hd.getTrangThai().name(),
                hd.getMaHoaDon()
        ) > 0;
    }

    // 7. DELETE
    public boolean delete(String maHoaDon) {
        return db.update("DELETE FROM HoaDon WHERE MaHD=?", maHoaDon) > 0;
    }

    // 8. DELETE BY MA HOP DONG
    public boolean deleteByMaHopDong(int maHopDong) {
        return db.update("DELETE FROM HoaDon WHERE MaHopDong=?", maHopDong) > 0;
    }

    // 9. MAPPER
    private HoaDon map(ResultSet rs) throws SQLException {
        HoaDon hd = new HoaDon();
        hd.setMaHoaDon(rs.getString("MaHD"));
        hd.setMaHopDong(rs.getInt("MaHopDong"));
        hd.setTienPhong(rs.getDouble("TienPhong"));
        hd.setChiSoDienCu(rs.getInt("ChiSoDienCu"));
        hd.setChiSoDienMoi(rs.getInt("ChiSoDienMoi"));
        hd.setChiSoNuocCu(rs.getInt("ChiSoNuocCu"));
        hd.setChiSoNuocMoi(rs.getInt("ChiSoNuocMoi"));
        hd.setTienDV(rs.getDouble("TienDV"));
        hd.setNgayLap(rs.getDate("NgayLap"));
        String tt = rs.getString("TrangThai");
        hd.setTrangThai("DaNop".equals(tt) ? TrangThaiHoaDon.DaNop : TrangThaiHoaDon.ChuaNop);
        return hd;
    }
}
