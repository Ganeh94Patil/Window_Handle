package demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image_urls {
   ChromeDriver driver;
    public Image_urls()
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
       
    public  void testCase04(){
        System.out.println("Start Test case: testCase01");
       // driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    
    
    //get URL www.google.com
    driver.get("https://www.google.co.in");
     

    //Locate search bar using locater "ID" APjFqb |sendkeys("https://in.bookmyshow.com/explore/home/chennai")

    driver.findElement(By.id("APjFqb")).sendKeys("https://in.bookmyshow.com/explore/home/chennai");

    //click on google search button using locater "Name" btnk
    driver.findElement(By.name("btnk")).click();
 
        // Find and print the image URLs for all "Recommended Movies"
        System.out.println("Image URLs for Recommended Movies:");
        for (WebElement element : driver.findElements(By.xpath("//div[@class='cards']//img"))) {
            System.out.println(element.getAttribute("src"));
        }

        // Find and print the Name & Language of the 2nd item in the "Premiere" list
        WebElement premiereItem = driver.findElements(By.xpath("//div[@data-filter-name='Premiere']//div[@class='cards']")).get(1);
        String name = premiereItem.findElement(By.xpath(".//div[@class='detail']//a")).getText();
        String language = premiereItem.findElement(By.xpath(".//div[@class='detail']//div[contains(text(), 'Language:')]/following-sibling::div")).getText();

        System.out.println("Name of the 2nd Premiere item: " + name);
        System.out.println("Language of the 2nd Premiere item: " + language);

        // Close the browser
        driver.quit();
    }

}