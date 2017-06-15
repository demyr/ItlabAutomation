package Navigation;

import Tools.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by myron on 06-Jun-17.
 */
public class AdminMenu
{

        public static boolean IsAt()
        {
            WebElement adminMenuWrapper = (new WebDriverWait(Driver.Instance, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("admin-menu-wrapper"))));
            String textOfMenu = adminMenuWrapper.getText();

            if(textOfMenu.contains("Dashboard"))
                return true;
            else
                return false;
        }


    public static void GoToPage(String s) {
        if (s == "People")
        {
            WebElement peopleBtn = (new WebDriverWait(Driver.Instance, 10)
            .until(ExpectedConditions.presenceOfElementLocated(By.linkText("People"))));
            peopleBtn.click();
        }
    }
}