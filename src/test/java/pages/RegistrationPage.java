package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {
    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//input[@type='url']")
    public WebElement webAddress;

    @FindBy(xpath = "//textarea[@id='jobInterests']")
    public WebElement additionalNotes;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(xpath = "//button[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//p[text()='You must provide a valid email address']")
    public WebElement errorMessageForInvalidEmail;

    @FindBy(xpath = "//p[text()='You must provide at least one job interest.']")
    public WebElement errorMessageForInvalidInterest;

    @FindBy(xpath = "//p[text()='Your password must be longer than 8 characters']")
    public WebElement errorMessageForShortPassword;

    @FindBy(xpath = "//p[text()='Your passwords did not match']")
    public WebElement errorMessageForMismatchedPassword;





}
