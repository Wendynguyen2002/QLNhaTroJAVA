package DAL;

import DTO.entity.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TaiKhoanDAL {

    private DBHelper db = DBHelper.getInstance();

    // ========================
    // 1. GET ALL
    // ========================
    public List<TaiKhoan> getAll() {

        return db.query(
                "SELECT * FROM TaiKhoan",
                this::map
        );
    }
    
    
    
    //KIỂM TRA TỒN TẠI
    public boolean checkTonTai(String username) {

        return !db.query(
                "SELECT username FROM TaiKhoan WHERE username=?",
                this::map,
                username
        ).isEmpty();
    }

    

    // ========================
    // 2. GET BY USERNAME
    // ========================
    public TaiKhoan getByUsername(String username) {

        List<TaiKhoan> list = db.query(
                "SELECT * FROM TaiKhoan WHERE username=?",
                this::map,
                username
        );

        return list.isEmpty() ? null : list.get(0);
    }

    // ========================
    // 3. INSERT
    // ========================
    public boolean insert(TaiKhoan tk) {

        return db.update(
                "INSERT INTO TaiKhoan(username, password, role, userId) VALUES (?,?,?,?)",
                tk.getUsername(),
                tk.getPassword(),
                tk.getRole(),
                tk.getUserId()
        ) > 0;
    }

    // ========================
    // 4. UPDATE
    // ========================
    public boolean update(TaiKhoan tk) {

        return db.update(
                "UPDATE TaiKhoan SET password=?, role=?, userId=? WHERE username=?",
                tk.getPassword(),
                tk.getRole(),
                tk.getUserId(),
                tk.getUsername()
        ) > 0;
    }

    // ========================
    // 5. DELETE
    // ========================
    public boolean delete(String username) {

        return db.update(
                "DELETE FROM TaiKhoan WHERE username=?",
                username
        ) > 0;
    }

    
    // ========================
    // MAPPER
    // ========================
    private TaiKhoan map(ResultSet rs) throws SQLException {

        TaiKhoan tk = new TaiKhoan();

        tk.setUsername(rs.getString("username"));
        tk.setPassword(rs.getString("password"));
        tk.setRole(rs.getInt("role"));
        tk.setUserId(rs.getString("userId"));

        return tk;
    }
}
