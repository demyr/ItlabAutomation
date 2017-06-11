package Pages;

import Tools.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Tools.Driver;

/**
 * Created by myron on 08-Jun-17.
 */
public class PeoplePage {
    public static void GoToPage(String s)
    {
        if (s == "Add user")
        {
            WebElement addUserLink = (new WebDriverWait(Driver.Instance, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add user")));
            addUserLink.click();
        }
    }
}
