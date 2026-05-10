package DTO.entity;
import DTO.enums.*;

import java.sql.Date;


public class ChuTro extends Nguoi {
    private String diaChi;

    public ChuTro() {
    	super();
    }
    
    
    public ChuTro(String id, String hoTen, GioiTinh gioiTinh, Date ngaySinh, String sdt,String dc) {
		super(id, hoTen, gioiTinh, ngaySinh, sdt);
		this.diaChi = dc;
	}

	// Get + Set
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }


	@Override
	public String toString() {
		return "ChuTro [diaChi=" + getDiaChi() + ", hoTen=" + getHoTen() + ", gioiTinh=" + getGioiTinh() + ", ngaySinh="
				+ getNgaySinh() + ", sdt=" + getSdt() + "]";
	}
    
    
    
}

