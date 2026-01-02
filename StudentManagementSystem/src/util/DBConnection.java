package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Vishnu@6302";

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            System.out.println(e.getMessage());
        }

        return con;
    }
}
