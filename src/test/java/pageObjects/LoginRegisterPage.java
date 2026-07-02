package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginRegisterPage
{
    WebDriver driver;

    // Constructor
    public LoginRegisterPage(WebDriver driver)
    {
        this.driver = driver;
    }

   
    // PAGE 1 - MOBILE / EMAIL
   

    By txtMobileEmail = By.id("userName");

    By btnContinue = By.id("checkUser");

   
    // PAGE 2 - REGISTRATION
 

    By txtName = By.id("j_name");

    By txtDOB = By.id("j_dob");

    By txtEmail = By.id("j_username_new");

    By txtPassword = By.id("j_password");

    By btnRegisterContinue = By.id("userSignup");

    
    // VALIDATION MESSAGES
    
    By lblEmailValidation = By.id("j_username_new-error");

    By lblPasswordValidation = By.id("j_password-error");

    
    // WEBELEMENT METHODS


    public WebElement mobileEmailTextBox()
    {
        return driver.findElement(txtMobileEmail);
    }

    public WebElement continueButton()
    {
        return driver.findElement(btnContinue);
    }

    public WebElement nameTextBox()
    {
        return driver.findElement(txtName);
    }

    public WebElement dobTextBox()
    {
        return driver.findElement(txtDOB);
    }

    public WebElement emailTextBox()
    {
        return driver.findElement(txtEmail);
    }

    public WebElement passwordTextBox()
    {
        return driver.findElement(txtPassword);
    }

    public WebElement registerContinueButton()
    {
        return driver.findElement(btnRegisterContinue);
    }

    public WebElement emailValidationMessage()
    {
        return driver.findElement(lblEmailValidation);
    }

    public WebElement passwordValidationMessage()
    {
        return driver.findElement(lblPasswordValidation);
    }

   
    // ACTION METHODS
  
    public void enterMobileEmail(String value)
    {
        mobileEmailTextBox().clear();
        mobileEmailTextBox().sendKeys(value);
    }

    public void clickContinue()
    {
        continueButton().click();
    }

    public void enterName(String name)
    {
        nameTextBox().clear();
        nameTextBox().sendKeys(name);
    }

    public void enterDOB(String dob)
    {
        dobTextBox().clear();
        dobTextBox().sendKeys(dob);
    }

    public void enterEmail(String email)
    {
        emailTextBox().clear();
        emailTextBox().sendKeys(email);
    }

    public void enterPassword(String password)
    {
        passwordTextBox().clear();
        passwordTextBox().sendKeys(password);
    }

    public void clickRegisterContinue()
    {
        registerContinueButton().click();
    }

    // VALIDATION METHODS
    
    public String getEmailValidation()
    {
        return emailValidationMessage().getText();
    }

    public String getPasswordValidation()
    {
        return passwordValidationMessage().getText();
    }

}