
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new
                URL("http://selenium-hub:4444/wd/hub"), caps);
        driver.get("http://170.75.171.209:30190/petclinic");
    }
    @Test
    public void petclinic {
        driver.manage().window().setSize(new Dimension(1920, 1040));
        driver.findElement(By.cssSelector("li:nth-child(2) span:nth-child(2)")).click();
        driver.findElement(By.name("lastName")).click();
        driver.findElement(By.name("lastName")).sendKeys("MEFTAH");
        driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
        driver.findElement(By.linkText("Add Owner")).click();
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("Herve");
        driver.findElement(By.id("lastName")).sendKeys("MEFTAH");
        driver.findElement(By.id("address")).sendKeys("rue de couvin");
        driver.findElement(By.id("city")).sendKeys("MONTBARD");
        driver.findElement(By.id("telephone")).sendKeys("0630290109");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.cssSelector("li:nth-child(3) span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("li:nth-child(2) span:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".glyphicon-th-list")).click();
        driver.findElement(By.cssSelector("li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("li:nth-child(4) > a")).click();
        driver.findElement(By.cssSelector("li:nth-child(3) > a")).click();
        driver.findElement(By.cssSelector("li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("html")).click();
        driver.findElement(By.cssSelector("html")).click();
    }










    @Test
    public void searchString() {
        // find search box and enter search string
        String pagecontent = driver.getPageSource();
        String search="Pipeline";
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