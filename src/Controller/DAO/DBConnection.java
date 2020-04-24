package Controller.DAO;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static Connection connection = null;
    private static Statement stmt = null;

    /**
     * Ouvre un connexion avec la BDD
     * @return connection
     */
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

    /**
     * Envoi une requête SQL afin de récupérer des données dans la BDD
     * @param sql : requête SQL
     * @return
     * @throws SQLException
     */
    public static ResultSet query(String sql) throws SQLException {
        Connection conn = openConnection();

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        return rs;
    }

    /**
     * Envoi un requête SQL afin de rajouter des données dans la BDD
     * @param sql : requête SQL
     * @return
     * @throws SQLException
     */
    public static int exec(String sql) throws SQLException {
        Connection conn = openConnection();
        int res = stmt.executeUpdate(sql);

        return res;
    }
}
