package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(id = "advs")
    private WebElement advanceSearchButton;

    @FindBy(id = "advs-keywords")
    private WebElement keywordsField;

    @FindBy(xpath = "//div[@class='description']")
    private List<WebElement> searchResultDescriptionList;

    @FindBy(xpath = "//div[@class='search-info']/p[contains(text(),'результатов для') or contains(text(),'results for') ]")
    private WebElement serchResultForHR;




    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        waitElementIsDisplayed(advanceSearchButton);
    }
    public void fillKeywordSearchTermAndSubmit(String searchTerm){
        waitElementIsDisplayed(keywordsField, 10);
        keywordsField.sendKeys(searchTerm);
        keywordsField.submit();
        waitElementIsDisplayed(serchResultForHR);
    }

    public int getSearchResultCount()
    {
        return searchResultDescriptionList.size();
    }

    public List<String> getDescriptionStringList(){

        List<String> getResultDescriptionStringList = new ArrayList<String>();

        for (WebElement getResultDescriptionElement : searchResultDescriptionList)
            getResultDescriptionStringList.add(getResultDescriptionElement.getText());
            return getResultDescriptionStringList;
        }
    }


