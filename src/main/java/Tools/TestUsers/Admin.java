package Tools.TestUsers;

import java.sql.ParameterMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by myron on 11-Jun-17.
 */
public class Admin
{


    public static void main(String[] args)
    {

        User admin = new User();

        String query = "Select * from users where id = 1";


        try {
            Statement statement = admin.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
            }
            admin.closeConnection();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        System.out.println(User.getPassword());
        System.out.println(User.getUsername());


    }


}
