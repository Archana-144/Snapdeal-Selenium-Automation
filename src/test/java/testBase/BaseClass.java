package testBase;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class BaseClass
{
    public WebDriver driver;

    // Switch to Child Window
    public void switchToChildWindow(String parent)
    {
        Set<String> windows = driver.getWindowHandles();

        for (String win : windows)
        {
            if (!win.equals(parent))
            {
                driver.switchTo().window(win);
                break;
            }
        }
    }

    // Switch back to Parent Window
    public void switchToParentWindow(String parent)
    {
        driver.switchTo().window(parent);
    }
}