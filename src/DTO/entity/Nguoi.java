package DTO.entity;
import DTO.enums.*;
import java.sql.Date;

public abstract class Nguoi {
    protected String id; // CCCD
    protected String hoTen;
    protected GioiTinh gioiTinh;
    protected Date ngaySinh; // Đồng bộ với kiểu DATE trong SQL
    protected String sdt;

    public Nguoi() {}

    public Nguoi(String id, String hoTen, GioiTinh gioiTinh, Date ngaySinh, String sdt) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
    }
    // Getter và Setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

    
    
   
}