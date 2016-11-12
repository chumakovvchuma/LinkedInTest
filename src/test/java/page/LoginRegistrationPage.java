package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginRegistrationPage extends BasePage{


    @FindBy(id = "reg-firstname")
    private WebElement firstNameField;

    @FindBy(id = "reg-lastname")
    private WebElement lastNameField;

    @FindBy(id = "reg-email")
    private WebElement mailField;

    @FindBy(id = "reg-password")
    private WebElement passwordField;

    @FindBy(id = "registration-submit")
    private WebElement buttonJoinNow;

    @FindBy(id = "login-email")
    private WebElement loginSignInField;

    @FindBy(id = "login-password")
    private WebElement passwordSignInField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(className = "alert-content")
    private WebElement errorEmptyMessage;



    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }



    public HomePage LogIn (String login,String password) {
        loginSignInField.sendKeys(login);
        passwordSignInField.sendKeys(password);
        signInButton.click();
        return new HomePage(driver);


    }
// Method for submit empty registration page
    public void RegistrationFieldSubmit (String firstName, String lastName, String mail, String password)  {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        mailField.sendKeys(mail);
        passwordField.sendKeys(password);
        buttonJoinNow.click();

    }
    public String GetErrorMessageText (){
        return errorEmptyMessage.getText();
    }



    }



