package demo;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Window_Handle {
   ChromeDriver driver;
    public Window_Handle()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
       
    public  void testCase07(){
        System.out.println("Start Test case: testCase01");
       // driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    
    
    //get URL www.google.com
    driver.get("https://www.google.co.in");
     

    //Locate search bar using locater "ID" APjFqb |sendkeys("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open")
    driver.findElement(By.id("APjFqb")).sendKeys("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

    //click on google search button using locater "Name" btnk
    driver.findElement(By.name("btnk")).click();


        // Switch to the iframe containing the "Try it" button
        driver.switchTo().frame("iframeResult");

        // Find and click the "Try it" button
        WebElement tryItButton = driver.findElement(By.cssSelector("button[onclick*='openWin()']"));
        tryItButton.click();

        // Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        // Get the URL and Title of the new window
        String newWindowURL = driver.getCurrentUrl();
        String newWindowTitle = driver.getTitle();

        // Take a screenshot (you need to import TakesScreenshot)
        // ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Close the new window
        driver.close();

        // Switch back to the original window
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        // Continue working with the original window

        // Close the browser
        driver.quit();
    }
}
