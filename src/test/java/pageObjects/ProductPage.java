package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage
{
    WebDriver driver;

    // Constructor
    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
    }

   
    // Locators
    

    By btnAddToCart = By.xpath("//span[text()='add to cart']");
      
    // WebElement Methods
  
    public WebElement addToCartButton()
    {
        return driver.findElement(btnAddToCart);
    }
  
    // Action Methods
    

    public void clickAddToCart()
    {
        addToCartButton().click();
    }
   

}