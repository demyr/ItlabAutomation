package Tools.TestUsers;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by myron on 11-Jun-17.
 */
public class User {


    private int id;
    private static String username;
    private static String password;
    private String email;

    private static String URL = "jdbc:mysql://localhost:3306/itlabtestdatadb?useSSL=true";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private Connection connection;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User() {

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

    public static void main(String[] args) {

        User user = new User();

        String query = "Select * from users where id = 1";


        try {
            Statement statement = user.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
            user.closeConnection();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        System.out.println(User.getPassword());
        System.out.println(User.getUsername());
    }
}
