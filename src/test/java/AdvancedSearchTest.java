import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginRegistrationPage;
import page.SearchPage;

/**
 * Created by Chu on 12.11.2016.
 */
public class AdvancedSearchTest extends BaseTest {

    public HomePage homePage;

    public  void  beforeTest(){
        LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage(getDriver());
        HomePage homePage = loginRegistrationPage.LogIn("j78q98x2l6@polyfaust.com", "chumachuma");
        Assert.assertTrue(homePage.isPageLoaded());
    }

    @Test(dataProvider = "searchTerms")
    public void advancedSearchTest(String searchTerm, String expectedContainedTErm) {
        SearchPage searchPage = homePage.clickAdvSearchButton();
        searchPage.fillKeywordSearchTermAndSubmit(searchTerm);
        Assert.assertEquals(searchPage.getSearchResultCount(), 10, "actual result is wrong");
        Assert.assertTrue(searchPage.getDescriptionStringList().get(0).contains(expectedContainedTErm));
    }
}
