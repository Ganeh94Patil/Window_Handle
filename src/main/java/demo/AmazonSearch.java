
    package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {
    ChromeDriver driver;
    public AmazonSearch()
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
       
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
       // driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    
    
    //get URL www.google.com
    driver.get("https://www.google.co.in");
     

    //Locate search bar using locater "ID" APjFqb |sendkeys("amazon")
    driver.findElement(By.id("APjFqb")).sendKeys("amazon");

    //click on google search button using locater "Name" btnk
    driver.findElement(By.name("btnk")).click();

    //find the link amazon.in or amazon.com using locater "Xpath" herf="http://www.amazon.in/"
   boolean status = driver.findElement(By.xpath("//a[contains(@herf,'amazon.in') or contains(@herf,'amazon.com')]")).isDisplayed();

   //Return true if the link element is found
   if (status)
   {
    System.out.println(status);
   }

   

   
}


}



    


