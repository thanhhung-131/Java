package hung11101;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testconection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://DESKTOP-8622U14:1433;"
                        + "database=QuanLyDonHang;"
                        + "user=sa;"
                        + "password=hung1312002;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}