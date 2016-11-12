package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToUrl (String URL) {
    driver.get(URL);
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public WebElement waitElementIsDisplayed(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitElementIsDisplayed(WebElement element) {
    return waitElementIsDisplayed(element, 10);
    }
}
