package DTO.entity;

public class NhaTro {

    private String maNha;
    private String tenNha;

    private String soNhaDuong;
    private String quan;
    private String tinh;

    private String maChuTro;

    public NhaTro() {}

	public String getMaNha() {
		return maNha;
	}

	public void setMaNha(String maNha) {
		this.maNha = maNha;
	}

	public String getTenNha() {
		return tenNha;
	}

	public void setTenNha(String tenNha) {
		this.tenNha = tenNha;
	}

	public String getSoNhaDuong() {
		return soNhaDuong;
	}

	public void setSoNhaDuong(String soNhaDuong) {
		this.soNhaDuong = soNhaDuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getMaChuTro() {
		return maChuTro;
	}

	public void setMaChuTro(String maChuTro) {
		this.maChuTro = maChuTro;
	}

	@Override
	public String toString() {
		return "NhaTro [maNha=" + maNha + ", tenNha=" + tenNha + ", soNhaDuong=" + soNhaDuong + ", quan=" + quan
				+ ", tinh=" + tinh + ", maChuTro=" + maChuTro + "]";
	}


    
    
    
}