package demo;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Count_hyperlinks {
    ChromeDriver driver;
    public Count_hyperlinks()
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
       
      /**
     * 
     */
    public  void testCase02(){
      
         System.out.println("Start Test case: testCase01");
        // driver.get("https://www.google.com");
         System.out.println("end Test case: testCase02");


    
        //get URL www.google.com
        driver.get("https://www.google.co.in");
     

        //Locate search bar using locater "ID" APjFqb |sendkeys("https://in.bookmyshow.com/explore/home/chennai")
       driver.findElement(By.id("APjFqb")).sendKeys("https://in.bookmyshow.com/explore/home/chennai");

       //click on google search button using locater "Name" btnk
        driver.findElement(By.name("btnk")).click();

      
            // Find all the hyperlinks on the page
            List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));

            // Print the count of hyperlinks
            int hyperlinkCount = hyperlinks.size();
            System.out.println("Total hyperlinks on the page: " + hyperlinkCount);

            // Close the browser
            driver.quit();
      }
    
    }

  
