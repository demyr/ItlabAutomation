import Navigation.AdminMenu;
import Pages.AddUserPage;
import Pages.LoginPage;
import Pages.PeoplePage;
import Tools.Driver;
import Tools.TestUsers.Admin;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by myron on 08-Jun-17.
 */

public class AdminCreateNewUsers {
    @Before
    public void Init() {
        Driver.Initialize();
    }

    @Test
    public void AdminCanCreateNewUser() {

        LoginPage.GoTo();

        LoginPage.LoginAs(Admin.getUsername(), Admin.getPassword());

        AdminMenu.GoToPage("People");

        PeoplePage.GoToPage("Add user");

        AddUserPage.AddUserUsingCred("someuser", "email@address.com", "password")
                .withParameters("Active", "User", false).Create();

        AdminMenu.GoToPage("People");

        Assert.assertTrue("User doesn't exist", PeoplePage.IsUserExist("someuser"));
    }

    @After
    public void Close() {
        PeoplePage.DeleteUser("someuser");
        Driver.Close();
    }

}
