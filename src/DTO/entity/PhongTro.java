package DTO.entity;
import DTO.enums.*;

public class PhongTro {
    private String maPhong;
    private String maNha; // Khóa ngoại kết nối với NhaTro
    private double giaThue;
    private int dienTich;
    private TrangThaiPhongTro trangThai; // {DA_THUE,TRONG}
    private LoaiPhongTro loaiPhong; // {SMALL, MEDIUM, LARGE}
    private TienNghiPhongTro tienNghi;  // {CO_BAN, CAO_CAP}
    
    public PhongTro() {}
	public PhongTro(String maPhong, String maNha, double giaThue, int dienTich, TrangThaiPhongTro trangThai,
			LoaiPhongTro loaiPhong, TienNghiPhongTro tienNghi) {
		super();
		this.maPhong = maPhong;
		this.maNha = maNha;
		this.giaThue = giaThue;
		this.dienTich = dienTich;
		this.trangThai = trangThai;
		this.loaiPhong = loaiPhong;
		this.tienNghi = tienNghi;
	}
	
	// Getter và Setter...
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaNha() {
		return maNha;
	}
	public void setMaNha(String maNha) {
		this.maNha = maNha;
	}
	public double getGiaThue() {
		return giaThue;
	}
	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}
	public int getDienTich() {
		return dienTich;
	}
	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}
	public TrangThaiPhongTro getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(TrangThaiPhongTro trangThai) {
		this.trangThai = trangThai;
	}
	public LoaiPhongTro getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhongTro loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public TienNghiPhongTro getTienNghi() {
		return tienNghi;
	}
	public void setTienNghi(TienNghiPhongTro tienNghi) {
		this.tienNghi = tienNghi;
	}
	@Override
	public String toString() {
		return "PhongTro [maPhong=" + maPhong +  ", giaThue=" + giaThue + ", dienTich=" + dienTich
				+ ", trangThai=" + trangThai + ", loaiPhong=" + loaiPhong + ", tienNghi=" + tienNghi + "]";
	}
	
	

}