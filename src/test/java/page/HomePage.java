package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage {

    @FindBy(id = "in-logo")
    private WebElement homeLogo;

    @FindBy(className = "advanced-search")
    private WebElement searchAdvancedButton;

    @FindBy(id = "advs-keywords")
    private WebElement advancedSearchHotKey;

    @FindBy(className = "submit-advs")
    private WebElement advancedSearchButton;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isPageLoaded() {
        return waitElementIsDisplayed(homeLogo, 5).isDisplayed();
    }

    public boolean isPageAdvSearchLoaded(){
        return waitElementIsDisplayed(advancedSearchButton, 5).isDisplayed();
    }
    //public void searchHR() {
      //  searchAdvancedButton.click();
        //advancedSearchHotKey.sendKeys("HR");
    //}
public SearchPage clickAdvSearchButton(){
    searchAdvancedButton.click();
    return new SearchPage(driver);
}
    }


