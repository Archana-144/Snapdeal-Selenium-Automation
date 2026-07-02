package pageObjects;

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
}