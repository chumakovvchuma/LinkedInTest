import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://www.linkedin.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchTermsData(){
        return new Object[][]{
                {"HR","HR"},
                {"hr","hr"}
        };
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
