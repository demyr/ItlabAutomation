import Navigation.AdminMenu;
import Pages.LoginPage;
import Tools.Driver;
import Tools.TestUsers.Admin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by myron on 04-Jun-17.
 */

public class LoginTests {

    @Before
    public void Init() {
        Driver.Initialize();

    }

    @Test
    public void AdminUserCanLogin() {
        LoginPage.GoTo();
        LoginPage.LoginAs(Admin.getUsername()).withPassword(Admin.getPassword()).Login();

        Assert.assertTrue("Admins menu didn't show up", AdminMenu.IsAt());
    }

    @After
    public void Close()
    {
        Driver.Close();
    }

}
