package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.DashboardPage;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class StepDefinitions {

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    DashboardPage dashboardPage = new DashboardPage();
    Faker faker = new Faker();
    public static String fakeName;
    public static String fakeEmailAddress;
    public static String fakePassword;

    @Given("student navigates to homepage")
    public void student_navigates_to_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("homepage_url"));
    }
    @Given("clicks on the {string} link from the homepage")
    public void clicks_on_the_link_from_the_homepage(String string) {
        homePage.Register.click();
    }

    @Given("the student is on the register page now")
    public void the_student_is_on_the_register_page_now() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("register.html"));
    }

    @When("enters a valid first name")
    public void enters_a_valid_first_name() {
        fakeName = faker.name().fullName();
        registrationPage.name.sendKeys(fakeName);
    }
    @And("enters a valid email address")
    public void enters_a_valid_email_address() {
        fakeEmailAddress = faker.internet().emailAddress();
        registrationPage.email.sendKeys(fakeEmailAddress);
    }
    @And("enters a valid web address")
    public void enters_a_valid_web_address() {
        registrationPage.webAddress.sendKeys("https://www.google.co.uk/");
    }
    @And("enters an interest")
    public void enters_an_interest() {
        ReusableMethods.switchIframeByWebElement("//iframe[@id='iframe']");
        registrationPage.additionalNotes.sendKeys("Selenium Cucumber");
        Driver.getDriver().switchTo().defaultContent();
    }
    @And("enters a valid password")
    public void enters_a_valid_password() {
        fakePassword = faker.internet().password(8,10);
        registrationPage.password.sendKeys(fakePassword);
    }

    @And("confirms the password")
    public void confirms_the_password() {
        registrationPage.confirmPassword.sendKeys(fakePassword);
    }

    @And("clicks on the register button")
    public void clicks_on_the_register_button() {
        registrationPage.registerButton.click();
    }
    @Then("verify that register is successful with personalized greeting is displayed")
    public void verify_that_register_is_successful_with_personalized_greeting_is_displayed() {
        Assert.assertTrue(dashboardPage.welcomeMessage.getText().contains(fakeName));
    }

    @Then("verify that a list of {int} job vacancies is displayed on the Dashboard Page")
    public void verify_that_a_list_of_job_vacancies_is_displayed_on_the_dashboard_page(Integer int1) {
        ReusableMethods.verifyElementDisplayed(dashboardPage.verifyJob1Seen);
        ReusableMethods.verifyElementDisplayed(dashboardPage.verifyJob2Seen);
        ReusableMethods.verifyElementDisplayed(dashboardPage.verifyJob3Seen);
        ReusableMethods.verifyElementDisplayed(dashboardPage.verifyJob4Seen);
        ReusableMethods.verifyElementDisplayed(dashboardPage.verifyJob5Seen);
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

    @When("user enters an invalid email address {string}")
    public void user_enters_an_invalid_email_address(String string) throws InterruptedException {
        registrationPage.email.sendKeys(string+ Keys.ENTER);
        Thread.sleep(5000);
    }
    @Then("verify invalid email address alert is seen")
    public void verify_invalid_email_address_alert_is_seen() {
       ReusableMethods.verifyElementDisplayed(registrationPage.errorMessageForInvalidEmail);
    }

    @When("user enters an invalid web address {string}")
    public void user_enters_an_invalid_web_address(String string) {
        registrationPage.webAddress.sendKeys(string+ Keys.ENTER);
    }

    @Then("verify invalid job interest alert is seen")
    public void verify_invalid_job_interest_alert_is_seen() throws InterruptedException {
        Thread.sleep(5000);
        ReusableMethods.verifyElementDisplayed(registrationPage.errorMessageForInvalidInterest);
        Thread.sleep(5000);

    }

    @When("user enters invalid characters in {string} and {string} fields")
    public void user_enters_invalid_characters_in_and_fields(String string, String string2) {
       registrationPage.password.sendKeys(string);
       registrationPage.confirmPassword.sendKeys(string2);

    }
    @Then("verify alert for password must be longer is seen")
    public void verify_alert_for_password_must_be_longer_is_seen() {
       ReusableMethods.verifyElementDisplayed(registrationPage.errorMessageForShortPassword);
    }

    @Then("verify alert for passwords did not match is seen")
    public void verify_alert_for_passwords_did_not_match_is_seen() {
        ReusableMethods.verifyElementDisplayed(registrationPage.errorMessageForMismatchedPassword);
    }

    @Then("verify alert for email, password fields must be entered")
    public void verify_alert_for_email_password_fields_must_be_entered() {
        ReusableMethods.verifyElementDisplayed(registrationPage.errorMessageForInvalidInterest);
        ReusableMethods.verifyElementDisplayed(registrationPage.errorMessageForShortPassword);
        ReusableMethods.verifyElementDisplayed(registrationPage.errorMessageForMismatchedPassword);
    }





}
