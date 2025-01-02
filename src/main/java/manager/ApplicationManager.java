package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //private WebDriver driver;
    private EventFiringWebDriver driver;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        //driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        driver.register(new WDListener());
    }

    @AfterMethod
    public void tearDown(){
//        if(driver != null)
//            driver.quit();
    }
}
