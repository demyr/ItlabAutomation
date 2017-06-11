import Navigation.AdminMenu;
import Pages.AddUserPage;
import Pages.LoginPage;
import Pages.PeoplePage;
import Tools.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by myron on 08-Jun-17.
 */

public class CreateANewUser {
    @Before
    public void Init()
    {
        Driver.Initialize();
    }

    @Test
    public void AdminCanCreateANewUser()
    {
        LoginPage.GoTo();
        LoginPage.LoginAs("admin").withPassword("demyropass").Login();

        AdminMenu.GoToPage("People");
        PeoplePage.GoToPage("Add user");
        AddUserPage.AddUserUsingCred("someuser", "email@address.com", "password")
                .withParameters("Active", "User", false).Create();
    }

    @After
    public void Close()
    {
//        Driver.Close();
    }

}
