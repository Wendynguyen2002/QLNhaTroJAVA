package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {

            	String url = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=QLNhaTro;encrypt=true;trustServerCertificate=true";
                String user = "sa";
                String password = "123456";
                
                
                /*Nếu dùng DB máy thầy:
                String url = "jdbc:sqlserver://192.168.1.5:1433;databaseName=NhaTroDB;encrypt=true;trustServerCertificate=true";

                String user = "sa";
                String password = "123456"; */

                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}