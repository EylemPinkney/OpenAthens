package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class ReusableMethods {

    public static void switchIframeByWebElement(String xpath){
        WebElement iframeElement = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.getDriver().switchTo().frame(iframeElement);
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element is not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Element is not found: " + element);
        }
    }



}
