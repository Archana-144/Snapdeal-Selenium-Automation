package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage
{
    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Locators


    By btnRemove = By.xpath("//div[@class='remove-item-div']");

    By btnCloseCartPopup = By.cssSelector("span.close-popup-icon");
    By cartProductName = By.xpath("//span[@class='product-name']/a");
    By cartItemCount = By.xpath("//h3/span");

    //By btnStartShopping = By.xpath("//a[text()='START SHOPPING NOW']");


    // WebElement Methods
   

    public WebElement removeButton()
    {
        return driver.findElement(btnRemove);
    }
    public WebElement closeCartPopupButton()
    {
        return driver.findElement(btnCloseCartPopup);
    }

    public WebElement cartProductName()
    {
        return driver.findElement(cartProductName);
    }
    public WebElement cartItemCount()
    {
        return driver.findElement(cartItemCount);
    }
//    public WebElement startShoppingButton()
//    {
//        return driver.findElement(btnStartShopping);
//    }

   
   

    // Action Methods
    

    public void clickRemove()
    {
        removeButton().click();
    }
    
    public void clickCloseCartPopup()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(btnCloseCartPopup));

        closeCartPopupButton().click();
    }
    //getter method
  
    public String getCartProductName()
    {
        return cartProductName().getText();
    }
  
    public String getCartItemCount()
    {
        return cartItemCount().getText();
    }


//    public boolean isStartShoppingDisplayed()
//    {
//        return startShoppingButton().isDisplayed();
//    }

}