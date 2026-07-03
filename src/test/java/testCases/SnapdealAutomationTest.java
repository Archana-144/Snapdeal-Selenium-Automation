package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginRegisterPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class SnapdealAutomationTest extends BaseClass
{

    @Test
    public void snapdealAutomation() throws InterruptedException
    {

        // Launch Browser
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Snapdeal
        driver.get("https://www.snapdeal.com/products/women-apparel-sarees");

        // Store Parent Window
        String parent = driver.getWindowHandle();

        // Create Objects
        HomePage hp = new HomePage(driver);

        ProductPage pp = new ProductPage(driver);

        CartPage cp = new CartPage(driver);
        
        CheckoutPage chk = new CheckoutPage(driver);
        LoginRegisterPage lp = new LoginRegisterPage(driver);

       
     // FIRST PRODUCT

        String expectedProduct1 = hp.getFirstProductName().trim();

        System.out.println("Expected Product 1 : " + expectedProduct1);

        hp.clickFirstProduct();

        Thread.sleep(2000);

        switchToChildWindow(parent);

        Thread.sleep(1000);

        pp.clickAddToCart();

        Thread.sleep(2000);

        String actualCartProduct1 = cp.getCartProductName().trim();

        System.out.println("Cart Product 1 : " + actualCartProduct1);

        String expected1 = expectedProduct1.split("\\(")[0].trim();
        String actual1 = actualCartProduct1.split("\\(")[0].trim();

        Assert.assertEquals(actual1, expected1);

        System.out.println("Product 1 Successfully Added To Cart");
        driver.close();

        switchToParentWindow(parent);

        Thread.sleep(2000);
     // SECOND PRODUCT

        String expectedProduct2 = hp.getSecondProductName().trim();

        System.out.println("Expected Product 2 : " + expectedProduct2);

        hp.clickSecondProduct();

        Thread.sleep(2000);

        switchToChildWindow(parent);

        Thread.sleep(1000);

        pp.clickAddToCart();

        Thread.sleep(2000);

        String actualCartProduct2 = cp.getCartProductName().trim();

        System.out.println("Cart Product 2 : " + actualCartProduct2);

        String expected2 = expectedProduct2.split("\\(")[0].trim();
        String actual2 = actualCartProduct2.split("\\(")[0].trim();

        Assert.assertEquals(actual2, expected2);

        System.out.println("Product 2 Successfully Added To Cart");

        driver.close();

        switchToParentWindow(parent);

        Thread.sleep(2000);
      
     // THIRD PRODUCT

        String expectedProduct3 = hp.getThirdProductName().trim();

        System.out.println("Expected Product 3 : " + expectedProduct3);

        hp.clickThirdProduct();

        Thread.sleep(2000);

        switchToChildWindow(parent);

        Thread.sleep(1000);

        pp.clickAddToCart();

        Thread.sleep(2000);

        String actualCartProduct3 = cp.getCartProductName().trim();

        System.out.println("Cart Product 3 : " + actualCartProduct3);
        String expected3 = expectedProduct3.split("\\(")[0].trim();
        String actual3 = actualCartProduct3.split("\\(")[0].trim();

        Assert.assertEquals(actual3, expected3);
        System.out.println("Product 3 Successfully Added To Cart");

        driver.close();

        switchToParentWindow(parent);

        Thread.sleep(2000);
        
        // CART
     

        hp.clickCart();

        Thread.sleep(1000);
        String beforeRemove = cp.getCartItemCount();

        System.out.println("Items Before Remove : " + beforeRemove);

        Assert.assertEquals(beforeRemove, "(3 Items)");

        System.out.println("Cart contains 3 Items");

        cp.clickRemove();

        Thread.sleep(3000);   
        String afterRemove = cp.getCartItemCount();

        System.out.println("Items After Remove : " + afterRemove);

        Assert.assertEquals(afterRemove, "(2 Items)");

        System.out.println("Product Removed Successfully. Cart now has 2 Items.");

        chk.clickProceedToPay();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.className("razorpay-checkout-frame")));
        chk.clickClosePopup();
        
        Thread.sleep(1000);
        
        chk.clickyes();
        driver.switchTo().defaultContent();
        
        cp.clickCloseCartPopup();

        hp.hoverSignIn();

        Thread.sleep(2000);
        

        hp.clickRegister();
        driver.switchTo().frame(driver.findElement(By.id("loginIframe")));

        Thread.sleep(2000);
        lp.enterMobileEmail("9731343351");

        Thread.sleep(1000);

        lp.clickContinue();
        
        Thread.sleep(2000);

     // Switch back
     driver.switchTo().defaultContent();

     // Switch again into the login iframe
     
     driver.switchTo().frame("loginIframe");
     // REGISTRATION PAGE
  
     // Enter Name
    
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j_name")));
     lp.clearDOB();
     lp.enterName("Archana");

     // Enter DOB
     lp.enterDOB("15/05/2004");

     // Enter Invalid Email
     lp.enterEmail("abc");

     // Leave Password Empty

     // Click Continue
     lp.clickRegisterContinue();

     Thread.sleep(2000);

    

     String actualEmailValidation = lp.getEmailValidation();

     System.out.println("Actual Email Validation : " + actualEmailValidation);

     Assert.assertEquals(actualEmailValidation, "Please enter a valid email");

     System.out.println("Email Validation Passed");

     String actualPasswordValidation = lp.getPasswordValidation();

     System.out.println("Actual Password Validation : " + actualPasswordValidation);

     Assert.assertEquals(actualPasswordValidation, "Please enter a password");

     System.out.println("Password Validation Passed");
     lp.clearEmail();

     lp.enterEmail("archana@gmail.com");

     // Password Still Empty

     lp.clickRegisterContinue();

     Thread.sleep(2000);

   
     actualPasswordValidation = lp.getPasswordValidation();

     Assert.assertEquals(actualPasswordValidation, "Please enter a password");

     System.out.println("Password Mandatory Validation Passed");

     lp.enterPassword("Archana@123");

     lp.clickRegisterContinue();

     Thread.sleep(5000);

     System.out.println("Registration Flow Completed Successfully");

     // Close Browser
     driver.quit();

    }

}