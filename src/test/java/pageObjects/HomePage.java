package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class HomePage
{
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    // Locators
  

    By firstProduct = By.xpath("(//picture[@class='picture-elem'])[1]");

    By secondProduct = By.xpath("(//picture[@class='picture-elem'])[2]");

    By thirdProduct = By.xpath("(//picture[@class='picture-elem'])[3]");



    By btnCart = By.xpath("//span[text()='Cart']");
    By signIn = By.xpath("//span[text()='Sign In']");

    By register = By.xpath("//span[text()='Register']");

    By firstProductName = By.xpath("(//p[contains(@class,'product-title')])[1]");

    By secondProductName = By.xpath("(//p[contains(@class,'product-title')])[2]");

    By thirdProductName = By.xpath("(//p[contains(@class,'product-title')])[3]");
    //filters
    
 // Sort By Dropdown
    By sortDropdown = By.xpath("//div[@class='sort-selected']");

    // Price Low To High Option
    By priceLowToHigh = By.xpath("(//li[@data-index='1'])[2]");
    
    By productPrices = By.xpath("//span[@class='lfloat product-price']");
    
    By fourStarRating = By.xpath("//label[@for='avgRating-4.0']");
    
    By discount20to30 = By.xpath("//label[@for='discount-20 - 30']");
    // WebElement Methods
   

    public WebElement firstProduct()
    {
        return driver.findElement(firstProduct);
    }

    public WebElement secondProduct()
    {
        return driver.findElement(secondProduct);
    }

    public WebElement thirdProduct()
    {
        return driver.findElement(thirdProduct);
    }

    public WebElement firstProductName()
    {
        return driver.findElement(firstProductName);
    }

    public WebElement secondProductName()
    {
        return driver.findElement(secondProductName);
    }

    public WebElement thirdProductName()
    {
        return driver.findElement(thirdProductName);
    }
    public WebElement cartButton()
    {
        return driver.findElement(btnCart);
    }
    public WebElement signInMenu()
    {
        return driver.findElement(signIn);
    }

    public WebElement registerButton()
    {
        return driver.findElement(register);
    }
    public WebElement sortDropdown()
    {
        return driver.findElement(sortDropdown);
    }

    public WebElement priceLowToHigh()
    {
        return driver.findElement(priceLowToHigh);
    }
    public List<WebElement> getProductPrices()
    {
        return driver.findElements(productPrices);
    }
    public WebElement fourStarRating()
    {
        return driver.findElement(fourStarRating);
    }
    public WebElement discount20to30()
    {
        return driver.findElement(discount20to30);
    }
    // Action Methods
    

    public void clickFirstProduct()
    {
        firstProduct().click();
    }

    public void clickSecondProduct()
    {
        secondProduct().click();
    }

    public void clickThirdProduct()
    {
        thirdProduct().click();
    }
    public void clickCart()
    {
        cartButton().click();
    }
    public void hoverSignIn()
    {
        Actions act = new Actions(driver);

        act.moveToElement(signInMenu()).perform();
    }

    public void clickRegister()
    {
        registerButton().click();
    }
    public String getFirstProductName()
    {
        return firstProductName().getText();
    }

    public String getSecondProductName()
    {
        return secondProductName().getText();
    }

    public String getThirdProductName()
    {
        return thirdProductName().getText();
    }
    public void clickSortDropdown()
    {
        sortDropdown().click();
    }

    public void clickPriceLowToHigh()
    {
        priceLowToHigh().click();
    }
    public void clickFourStarRating()
    {
        fourStarRating().click();
    }
    public void clickDiscount20to30()
    {
        discount20to30().click();
    }
}