package security;
import DTO.entity.TaiKhoan;

public class Auth {
	
	// sau khi đăng nhập gọi TaiKhoan tk => đến login(tk) để cấp quyền truy cập các tab sau
	public static void login(TaiKhoan tk) {
		Session.userHienTai = tk;
	}
	// Đăng xuất
	public static void logout() {
		Session.userHienTai = null;
	}
	
	public static boolean isLoggedIn() {
        return Session.userHienTai != null;
    }
	
	public static TaiKhoan getUser() {
		return Session.userHienTai;
	}

}

/* Sau khi Auth:
 
 LÂY USER TÀI KHOẢN ĐANG ĐĂNG NHẬP
 TaiKhoan user = Auth.getUser();
 
 Check có đang đắng nhập ko??
 if(!Auth.isLoggedIn()) {

	JOptionPane.showMessageDialog(null, "Vui lòng đăng nhập");

	new Login().setVisible(true);

	dispose();

	return;
}


lblUsername.setText(user.getUsername()); Hiển thị tên cho vui

LOGOUT như vầy:


Auth.logout();

new Login().setVisible(true);

dispose();






*/