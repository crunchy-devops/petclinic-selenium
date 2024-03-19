
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class test {

    WebDriver driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        ChromeOptions caps= new ChromeOptions();
        caps.setPlatformName("LINUX");
        caps.setBrowserVersion("120.0");

        //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setBrowserName("chrome");
        //caps.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new
                URL("http://selenium-hub:4444/wd/hub"), caps);
        driver.get("http://192.168.1.44:30190/petclinic");
    }
    @Test
    public void searchString() {
        // find search box and enter search string
        String pagecontent = driver.getPageSource();
        String search="bonjour";
        if (pagecontent.toLowerCase().indexOf(search.toLowerCase()) != -1) {
            System.out.println("OK");
        }else {
            System.out.println("Error Webpage content");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
