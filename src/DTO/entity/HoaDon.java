package DTO.entity;
import java.sql.Date;
import DTO.enums.TrangThaiHoaDon;

public class HoaDon {
    private String maHoaDon;
    private int maHopDong;
    private int chiSoDienCu;
    private int chiSoDienMoi;
    private int chiSoNuocCu;
    private int chiSoNuocMoi;
    private double tienPhong;
    private double tienDien;
    private double tienNuoc;
    private double tienDV;
    private Date ngayLap;
    private TrangThaiHoaDon trangThai;

    public HoaDon() {}

    public HoaDon(String maHoaDon, int maHopDong,
                  int chiSoDienCu, int chiSoDienMoi,
                  int chiSoNuocCu, int chiSoNuocMoi,
                  double tienPhong, double tienDien, double tienNuoc, double tienDV,
                  Date ngayLap, TrangThaiHoaDon trangThai) {
        this.maHoaDon = maHoaDon;
        this.maHopDong = maHopDong;
        this.chiSoDienCu = chiSoDienCu;
        this.chiSoDienMoi = chiSoDienMoi;
        this.chiSoNuocCu = chiSoNuocCu;
        this.chiSoNuocMoi = chiSoNuocMoi;
        this.tienPhong = tienPhong;
        this.tienDien = tienDien;
        this.tienNuoc = tienNuoc;
        this.tienDV = tienDV;
        this.ngayLap = ngayLap;
        this.trangThai = trangThai;
    }

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public int getMaHopDong() { return maHopDong; }
    public void setMaHopDong(int maHopDong) { this.maHopDong = maHopDong; }

    public int getChiSoDienCu() { return chiSoDienCu; }
    public void setChiSoDienCu(int chiSoDienCu) { this.chiSoDienCu = chiSoDienCu; }

    public int getChiSoDienMoi() { return chiSoDienMoi; }
    public void setChiSoDienMoi(int chiSoDienMoi) { this.chiSoDienMoi = chiSoDienMoi; }

    public int getChiSoNuocCu() { return chiSoNuocCu; }
    public void setChiSoNuocCu(int chiSoNuocCu) { this.chiSoNuocCu = chiSoNuocCu; }

    public int getChiSoNuocMoi() { return chiSoNuocMoi; }
    public void setChiSoNuocMoi(int chiSoNuocMoi) { this.chiSoNuocMoi = chiSoNuocMoi; }

    public double getTienPhong() { return tienPhong; }
    public void setTienPhong(double tienPhong) { this.tienPhong = tienPhong; }

    public double getTienDien() { return tienDien; }
    public void setTienDien(double tienDien) { this.tienDien = tienDien; }

    public double getTienNuoc() { return tienNuoc; }
    public void setTienNuoc(double tienNuoc) { this.tienNuoc = tienNuoc; }

    public double getTienDV() { return tienDV; }
    public void setTienDV(double tienDV) { this.tienDV = tienDV; }

    public Date getNgayLap() { return ngayLap; }
    public void setNgayLap(Date ngayLap) { this.ngayLap = ngayLap; }

    public TrangThaiHoaDon getTrangThai() { return trangThai; }
    public void setTrangThai(TrangThaiHoaDon trangThai) { this.trangThai = trangThai; }

    public double getTongTien() {
        return tienPhong + tienDien + tienNuoc + tienDV;
    }
}
