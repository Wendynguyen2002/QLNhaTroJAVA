package DTO.entity;
import java.sql.Date;

public class ThuePhong {
    private String maPhong;
    private String maKhachHang;
    private double tienDatCoc; // Lưu tiền đặt cọc
    private Date ngayBatDau;
    private Date ngayKetThuc;
    
    
    
    public ThuePhong() {}
    
    public ThuePhong(String maPhong, String maKhachHang, double tienDatCoc, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.maPhong = maPhong;
		this.maKhachHang = maKhachHang;
		this.tienDatCoc = tienDatCoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
    
	// Getter và Setter...
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public double getTienDatCoc() {
		return tienDatCoc;
	}
	public void setTienDatCoc(double tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@Override
	public String toString() {
		return "ThuePhong [maPhong=" + maPhong + ", maKhachHang=" + maKhachHang + ", tienDatCoc=" + tienDatCoc
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + "]";
	}
	
	

   
    
}