package Pages;

import Tools.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

/**
 * Created by myron on 09-Jun-17.
 */
public class AddUserPage
{
    public static void GoTo()
    {

    }

    public static CreateAccCommand AddUserUsingCred(String userName, String email, String password)
    {
        return new CreateAccCommand(userName, email, password);
    }

    public static class CreateAccCommand {
        private String userName;
        private String email;
        private String password;
        private String status;
        private String role;
        private boolean notification;


        public CreateAccCommand(String userName, String email, String password) {
            this.userName = userName;
            this.email = email;
            this.password = password;
        }

        public CreateAccCommand withParameters(String status, String role, boolean notification)
        {
            this.status = status;
            this.role = role;
            this.notification = notification;
            return this;
        }



        public void Create()
        {
            // type username
            WebElement editName = new WebDriverWait(Driver.Instance, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("edit-name")));
            editName.sendKeys(userName);

            // type email
            WebElement editEmail = Driver.Instance.findElement(By.id("edit-mail"));
            editEmail.sendKeys(email);

            // type password
            WebElement editPass = Driver.Instance.findElement(By.id("edit-pass-pass1"));
            editPass.sendKeys(password);

            // type confirm password
            WebElement editConfPass = Driver.Instance.findElement(By.id("edit-pass-pass2"));
            editConfPass.sendKeys(password);

            // set status radiobutton
            if (status == "Active")
            {
                WebElement statusRadios = Driver.Instance.findElement(By.id("edit-status-1"));
                statusRadios.click();
            }
            else
            {
                WebElement statusRadios = Driver.Instance.findElement(By.id("edit-status-0"));
                statusRadios.click();
            }

            // set role checkbox
            if (role == "User")
            {
                WebElement roleChBox = Driver.Instance.findElement(By.id("edit-roles-4"));
                roleChBox.click();
            }
            else if (role == "Admin")
            {
                WebElement roleChBox = Driver.Instance.findElement(By.id("edit-roles-3"));
                roleChBox.click();

            }
            else if (role == "Manager")
            {
                WebElement roleChBox = Driver.Instance.findElement(By.id("edit-roles-5"));
                roleChBox.click();

            }

            // set notification checkbox
            if(notification)
            {
                WebElement notifyChkBox = Driver.Instance.findElement(By.id("edit-notify"));
                notifyChkBox.click();
            }

            // set 'edit personal data' checkbox
            WebElement editPersonalData = Driver.Instance.findElement(By.id("edit-personal-data"));
            editPersonalData.click();

            // click create button
            WebElement createBtn = Driver.Instance.findElement(By.id("edit-submit"));
            createBtn.click();

            // wait user creating
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        }
}
