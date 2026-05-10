package DTO.entity;

public class TaiKhoan {

    private String username;
    private String password;
    private int role;   // 1 = ChuTro, 0 = KhachHang, (có thể thêm admin)
    private String userId; // QUAN TRỌNG: liên kết với ChuTro hoặc KhachHang

    public TaiKhoan() {}

    public TaiKhoan(String username, String password, int role, String userId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.userId = userId;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    
    
}