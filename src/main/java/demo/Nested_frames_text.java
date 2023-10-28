package demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_frames_text {
  ChromeDriver driver;
    public Nested_frames_text()
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
       
    public  void testCase05(){
        System.out.println("Start Test case: testCase01");
       // driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    
    
    //get URL www.google.com
    driver.get("https://www.google.co.in");
     

    //Locate search bar using locater "ID" APjFqb |sendkeys("https://the-internet.herokuapp.com/nested_frames")


    driver.findElement(By.id("APjFqb")).sendKeys("https://the-internet.herokuapp.com/nested_frames");

    //click on google search button using locater "Name" btnk
    driver.findElement(By.name("btnk")).click();


        
        // Switch to the top frame
        driver.switchTo().frame("frame-top");

        // Switch to the left frame
        driver.switchTo().frame("frame-left");

        // Get the text from the left frame
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text in the left frame: " + leftFrameText);

        // Switch back to the top frame
        driver.switchTo().defaultContent();

        // Switch to the middle frame
        driver.switchTo().frame("frame-middle");

        // Get the text from the middle frame
        String middleFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text in the middle frame: " + middleFrameText);

        // Switch back to the top frame
        driver.switchTo().defaultContent();

        // Switch to the right frame
        driver.switchTo().frame("frame-right");

        // Get the text from the right frame
        String rightFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text in the right frame: " + rightFrameText);

        // Switch back to the top frame
        driver.switchTo().defaultContent();

        // Switch to the bottom frame
        driver.switchTo().frame("frame-bottom");

        // Get the text from the bottom frame
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Text in the bottom frame: " + bottomFrameText);

        // Close the browser
        driver.quit();
    }

}

