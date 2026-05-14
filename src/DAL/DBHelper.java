package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

    private static DBHelper instance;
    private Connection conn;

    private DBHelper() {
        conn = DBConnection.getConnection();
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }


    //MAPPER
  
    public interface RowMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

   
    // SELECT
 
    public <T> List<T> query(String sql, RowMapper<T> mapper, Object... params) {

        List<T> list = new ArrayList<>();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {  // Tạo PreparedStatement -> dùng xong tự close()

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapper.map(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

   
    // INSERT / UPDATE / DELETE

    public int update(String sql, Object... params) {

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}