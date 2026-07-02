package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage
{
    WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Locators

    By btnProceedToPay = By.xpath("//input[@id='rzp-cart-button']");
    By btnClosePopup = By.xpath("//button[contains(@class,'modal-close')]");

    By yesbtn=By.xpath("//div [@id='positiveBtn']");


    // WebElement

    public WebElement proceedToPayButton()
    {
        return driver.findElement(btnProceedToPay);
    }

    public WebElement closePopupButton()
    {
        return driver.findElement(btnClosePopup);
    }
    public WebElement yesButton()
    {
        return driver.findElement(yesbtn);
    }
    // Action Method

public void clickProceedToPay()
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement button = wait.until(
            ExpectedConditions.visibilityOfElementLocated(btnProceedToPay));

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", button);

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", button);
}
public void clickClosePopup()
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement closeBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(btnClosePopup));

    closeBtn.click();
}
    public void clickyes()
    {
        yesButton().click();
    }
}