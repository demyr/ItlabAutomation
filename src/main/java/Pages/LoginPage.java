package Pages;

import Tools.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.jca.GetInstance;


public class LoginPage
{
    public static void GoTo()
    {
        Driver.Instance.get("http://demyro.0fees.us/");
        WebElement loginBtn = new WebDriverWait(Driver.Instance,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("login-btn")));
        loginBtn.click();


    }

    public static LoginCommand LoginAs(String userName)
    {
        return new LoginCommand(userName);
    }

    public static class LoginCommand
    {
        private String userName;
        private String password;

        public LoginCommand(String userName)
        {
            this.userName = userName;
        }

        public LoginCommand withPassword(String password) {
            this.password = password;
            return this;
        }

        public void Login()
        {

            WebElement loginInput = (new WebDriverWait(Driver.Instance,10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("edit-name"))));
            loginInput.sendKeys(userName);

            WebElement passInput = (new WebDriverWait(Driver.Instance,10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("edit-pass"))));
            passInput.sendKeys(password);

            WebElement submitBtn = (new WebDriverWait(Driver.Instance,10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("edit-submit"))));
            submitBtn.click();
        }
    }
}
