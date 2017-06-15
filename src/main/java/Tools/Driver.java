package Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by myron on 06-Jun-17.
 */
public class Driver {

    public static WebDriver Instance;

    public static void Initialize()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/browserDrivers/chromedriver.exe");

        Instance = new ChromeDriver();
        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void Close() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instance.close();
    }
}

