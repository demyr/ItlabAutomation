package Pages;

import Tools.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Tools.Driver;

import java.util.List;

/**
 * Created by myron on 08-Jun-17.
 */
public class PeoplePage {

    public static void GoTo()
    {
        Driver.Instance.get("http://demyro.0fees.us/admin/people");
    }

    public static void GoToPage(String s)
    {
        if (s == "Add user")
        {
            WebElement addUserLink = (new WebDriverWait(Driver.Instance, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add user")));
            addUserLink.click();
        }
    }

    public static boolean IsUserExist(String userName) {

        // find table with users
        WebElement table = Driver.Instance.findElement(By.xpath("//*[@id=\"user-admin-account\"]/div/table[2]"));

        // grab table rows
        List<WebElement> allRows = table.findElements(By.tagName("tr"));

        // check if first row contains userName
        return allRows.get(1).getText().contains(userName);
    }

    public static void DeleteUser(String userName)
    {
        // find table with users
        WebElement table = Driver.Instance.findElement(By.xpath("//*[@id=\"user-admin-account\"]/div/table[2]"));

        //grab rows from table
        List<WebElement> allRows = table.findElements(By.tagName("tr"));

        // get each row from rows
        for (WebElement row : allRows) {
            // get data from row if it contains userName
            if (row.getText().contains(userName))
            {
                List<WebElement> cells  = row.findElements(By.tagName("td"));
                // get first cell and click checkbox in it
                WebElement userChBox = cells.get(0).findElement(By.cssSelector("input.form-checkbox"));
                userChBox.click();
                }
            }

        // select the "Cancel account" option from the "Update option" drop down list and click it
        WebElement updateOptionDDlist = Driver.Instance.findElement(By.id("edit-operation"));
        List<WebElement> options = updateOptionDDlist.findElements(By.cssSelector("option"));
        for (WebElement option :
                options) {
            if ("Cancel the selected user accounts".equals(option.getText()))
            {
                option.click();
            }
        }

        //click the "Update" button
        WebElement updateBtn = Driver.Instance.findElement(By.id("edit-submit--2"));
        updateBtn.click();

        // select "Delete acc and its content" option
        WebElement deleteAccAndContent = Driver.Instance.findElement(By.id("edit-user-cancel-method--5"));
        deleteAccAndContent.click();

        // click "Cancel acc" button
        WebElement cancelAccBtn = Driver.Instance.findElement(By.id("edit-submit"));
        cancelAccBtn.click();


    }
}
