package Tools.TestUsers;

import Tools.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by myron on 11-Jun-17.
 */
public class Admin {

    public static String getUsername() {

        ConnectDB connectDB = new ConnectDB();
        String query = "Select username from users where id = 1";
        String username = "";

        try {
            Statement statement = connectDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                username = resultSet.getString("username");
            }

            connectDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username;
    }

    public static String getPassword(){
        ConnectDB connectDB = new ConnectDB();
        String query = "Select password from users where id = 1";
        String password = "";

        try {
            Statement statement = connectDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                password = resultSet.getString("password");
            }

            connectDB.closeConnection();
        }catch (SQLException e){
        e.printStackTrace();
        }
        return password;
    }
}
