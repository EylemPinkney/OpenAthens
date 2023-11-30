package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DashboardPage {
    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[contains(text(),'Welcome')]")
    public WebElement welcomeMessage;

    @FindBy(xpath = "(//tbody)[1]//tr[1]//td[2]")
    public WebElement verifyJob1Seen;

    @FindBy(xpath = "(//tbody)[1]//tr[2]//td[2]")
    public WebElement verifyJob2Seen;

    @FindBy(xpath = "(//tbody)[1]//tr[3]//td[2]")
    public WebElement verifyJob3Seen;

    @FindBy(xpath = "(//tbody)[1]//tr[4]//td[2]")
    public WebElement verifyJob4Seen;

    @FindBy(xpath = "(//tbody)[1]//tr[5]//td[2]")
    public WebElement verifyJob5Seen;




}
