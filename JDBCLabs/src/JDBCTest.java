import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", "GUEST", "GUEST");

            DatabaseMetaData dbmd = conn.getMetaData();

            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("User Name: " + dbmd.getUserName());

            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}