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
       

        hp.clickFirstProduct();

        Thread.sleep(2000);

        switchToChildWindow(parent);

        Thread.sleep(1000);

        pp.clickAddToCart();

        Thread.sleep(2000);

        driver.close();

        switchToParentWindow(parent);

        Thread.sleep(2000);

       
        // SECOND PRODUCT
       

        hp.clickSecondProduct();

        Thread.sleep(2000);

        switchToChildWindow(parent);

        Thread.sleep(2000);

        pp.clickAddToCart();

        Thread.sleep(2000);

        driver.close();

        switchToParentWindow(parent);

        Thread.sleep(2000);

       
        // THIRD PRODUCT
      
        hp.clickThirdProduct();

        Thread.sleep(1000);

        switchToChildWindow(parent);

        Thread.sleep(2000);

        pp.clickAddToCart();

        Thread.sleep(2000);

        driver.close();

        switchToParentWindow(parent);

        Thread.sleep(3000);

        
        // CART
     

        hp.clickCart();

        Thread.sleep(1000);

        cp.clickRemove();

        Thread.sleep(3000);   

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