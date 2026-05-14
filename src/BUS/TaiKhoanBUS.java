package BUS;
import DAL.TaiKhoanDAL;
import DTO.entity.TaiKhoan;
import DTO.DTOs.*;
import java.util.List;



public class TaiKhoanBUS {
	private TaiKhoanDAL dal = new TaiKhoanDAL();
	
	
	// 1.ĐĂNG NHẬP
	public ResultDTO dangNhap(String username, String password) {

	    // validate
	    if (username == null || username.trim().isEmpty()) {
	        return new ResultDTO(false, "Username không được rỗng");
	    }

	    if (password == null || password.trim().isEmpty()) {
	        return new ResultDTO(false, "Mật khẩu không được rỗng");
	    }

	    TaiKhoan tk = dal.getByUsername(username);

	    if (tk == null) {
	        return new ResultDTO(false, "Tài khoản không tồn tại");
	    }

	    if (!tk.getPassword().equals(password)) {
	        return new ResultDTO(false, "Sai mật khẩu");
	    }

	    return new ResultDTO(true, "Đăng nhập thành công", tk);
	}
	
	
	
	// 2.ĐĂNG KÝ
	public ResultDTO dangKy(String username, String password) {

	    if (username == null || username.trim().isEmpty()) {
	        return new ResultDTO(false, "Username không hợp lệ");
	    }

	    if (password == null || password.trim().isEmpty()) {
	        return new ResultDTO(false, "Mật khẩu không hợp lệ");
	    }

	    if (dal.checkTonTai(username)) {
	        return new ResultDTO(false, "Username đã tồn tại");
	    }

	    TaiKhoan tk = new TaiKhoan();
	    tk.setUsername(username);
	    tk.setPassword(password);
	    tk.setRole(1);
	    tk.setUserId(null);

	    dal.insert(tk);

	    return new ResultDTO(true, "Đăng ký thành công");
	}
	
	
	// 3. ĐỔI MKHAU
	public ResultDTO doiMatKhau(String username, String matKhauCu, String matKhauMoi) {

	    if (username == null || username.trim().isEmpty())
	        return new ResultDTO(false, "Username không hợp lệ");

	    if (matKhauCu == null || matKhauCu.trim().isEmpty())
	        return new ResultDTO(false, "Mật khẩu cũ không hợp lệ");

	    if (matKhauMoi == null || matKhauMoi.trim().isEmpty())
	        return new ResultDTO(false, "Mật khẩu mới không hợp lệ");

	    if (matKhauMoi.length() < 6)
	        return new ResultDTO(false, "Mật khẩu phải >= 6 ký tự");

	    TaiKhoan tk = dal.getByUsername(username);

	    if (tk == null)
	        return new ResultDTO(false, "Tài khoản không tồn tại");

	    if (!tk.getPassword().equals(matKhauCu))
	        return new ResultDTO(false, "Mật khẩu cũ không đúng");

	    tk.setPassword(matKhauMoi);
	    dal.update(tk);

	    return new ResultDTO(true, "Đổi mật khẩu thành công");
	}
	
	
	// CHECK USER NÀY ĐÃ TỒN TẠI?
	public ResultDTO checkTonTai(String username) {

	    if (username == null || username.trim().isEmpty()) {
	        return new ResultDTO(false, "Username không hợp lệ");
	    }

	    boolean exist = dal.checkTonTai(username);

	    if (exist) {
	        return new ResultDTO(true, "Tài khoản đã tồn tại", true);
	    } else {
	        return new ResultDTO(true, "Tài khoản chưa tồn tại", false);
	    }
	}
	
	
	
	// READ ALL
	public ResultDTO getAll() {
		List<TaiKhoan> dS =  dal.getAll();
		return new ResultDTO(true,"Lấy danh sách thành công",dS);
	}
	
	// READ BY USER NAME
	public ResultDTO getByUsername(String username) {

	    if (username == null || username.trim().isEmpty()) {
	        return new ResultDTO(false, "Username không hợp lệ");
	    }

	    TaiKhoan tk = dal.getByUsername(username);

	    if (tk == null) {
	        return new ResultDTO(false, "Không tìm thấy tài khoản");
	    }

	    return new ResultDTO(true, "Tìm thấy tài khoản", tk);
	}
	
	
	
	
	// CẬP NHẬT CCCD KHÁCH HÀNG VÀO TKHOAN LAN DAU
	public ResultDTO linkCCCD(TaiKhoan tk, String cccd) {

	    if (tk == null) {
	        return new ResultDTO(false, "Tài khoản không tồn tại");
	    }

	    if (cccd == null || cccd.trim().isEmpty()) {
	        return new ResultDTO(false, "CCCD không hợp lệ");
	    }

	    if (tk.getUserId() != null) {
	        return new ResultDTO(false, "Tài khoản đã được liên kết");
	    }

	    tk.setUserId(cccd);
	    dal.update(tk);

	    return new ResultDTO(true, "Liên kết CCCD thành công", tk);
	}
	
	

}
