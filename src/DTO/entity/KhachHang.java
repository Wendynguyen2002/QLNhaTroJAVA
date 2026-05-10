package DTO.entity;
import DTO.enums.*;

import java.sql.Date;

// Class Khách hàng
public class KhachHang extends Nguoi {
	private String queQuan;
	private String ngheNghiep;
	
	public KhachHang() { super();}
	
	public KhachHang(String id, String hoTen, GioiTinh gioiTinh, Date ngaySinh, String sdt,String qQ, String ngheNghiep) {
		super(id, hoTen, gioiTinh, ngaySinh, sdt);
		this.queQuan = qQ;
		this.ngheNghiep = ngheNghiep;
	}
	// get + set

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	@Override
	public String toString() {
		return "KhachHang [queQuan=" + queQuan + ", ngheNghiep=" + ngheNghiep + ", id=" + id + ", hoTen=" + hoTen
				+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", sdt=" + sdt + "]";
	}
	
	

}
