package Tools;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.sql.Driver;

/**
 * Created by myron on 11-Jun-17.
 */
public class ConnectDB {


    private static String URL = "jdbc:mysql://localhost:3306/itlabtestdatadb?useSSL=true";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private Connection connection;


    public ConnectDB() {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }


}
