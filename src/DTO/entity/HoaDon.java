package DTO.entity;
import java.sql.Date;
import DTO.enums.TrangThaiHoaDon;

public class HoaDon {
    private String maHD;
    private String maPhong;
    private double tienPhong;
    private double tienDien;
    private double tienNuoc;
    private double tienDV;
    private double tongTien;
    private Date ngayLap;
    private TrangThaiHoaDon tthd ; // "DaNop", "ChuaNop"
    
    
    public HoaDon() {}
    
    public HoaDon(String maHD, String maPhong, double tienPhong, double tienDien, double tienNuoc, double tienDV,
			 Date ngayLap, TrangThaiHoaDon tthd) {
		super();
		this.maHD = maHD;
		this.maPhong = maPhong;
		this.tienPhong = tienPhong;
		this.tienDien = tienDien;
		this.tienNuoc = tienNuoc;
		this.tienDV = tienDV;
		this.tongTien = this.tienPhong +this.tienDien+this.tienNuoc +this.tienDV ;
		this.ngayLap = ngayLap;
		this.tthd = tthd;
	}
	// Getter và Setter...
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public double getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(double tienPhong) {
		this.tienPhong = tienPhong;
	}
	public double getTienDien() {
		return tienDien;
	}
	public void setTienDien(double tienDien) {
		this.tienDien = tienDien;
	}
	public double getTienNuoc() {
		return tienNuoc;
	}
	public void setTienNuoc(double tienNuoc) {
		this.tienNuoc = tienNuoc;
	}
	public double getTienDV() {
		return tienDV;
	}
	public void setTienDV(double tienDV) {
		this.tienDV = tienDV;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien() { // Nhớ khi mô update bất kỳ tiền mô => phải gọi hàm ni
		this.tongTien = this.tienPhong +this.tienDien + this.tienNuoc+ this.tienDV;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public TrangThaiHoaDon getTthd() {
		return tthd;
	}
	public void setTthd(TrangThaiHoaDon tthd) {
		this.tthd = tthd;
	}

   
    
}