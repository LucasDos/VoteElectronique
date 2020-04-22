package Controller.DAO;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static Connection connection = null;

    public static Connection openConnection() {
        if(connection != null) {
            return connection;
        } else {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

    public static ResultSet query(String sql) throws SQLException {
        Connection conn = openConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        return rs;
    }

    public static int exec(String sql) throws SQLException {
        Connection conn = openConnection();

        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }
}
