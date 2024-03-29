import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCOracle {

    public static void main(String[] args) {
        String dbUrl = "jdbc:oracle:thin:@//ИМЯ_СЕРВЕРА:ПОРТ/ИМЯ_СЕРВИСА";
        String username = "";
        String password = "";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");


                connection.close();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}