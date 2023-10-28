package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Post_on_linkedin {
     ChromeDriver driver;
    public Post_on_linkedin()
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
       
    public  void testCase03(){
        System.out.println("Start Test case: testCase01");
       // driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");

         
    //get URL www.google.com
    driver.get("https://www.google.co.in");
     

    //Locate search bar using locater "ID" APjFqb |sendkeys(" https://in.linkedin.com/")
    driver.findElement(By.id("APjFqb")).sendKeys("https://in.linkedin.com");

    //click on google search button using locater "Name" btnk
    driver.findElement(By.name("btnk")).click();
    


        WebElement emailField = driver.findElement(By.id("session_key"));
        WebElement passwordField = driver.findElement(By.id("session_password"));
        WebElement signInButton = driver.findElement(By.cssSelector(".sign-in-form__submit-button"));


        // Provide your actual email and password here
        emailField.sendKeys("your_email");
        passwordField.sendKeys("your_password");
        signInButton.click();

        WebElement profileViews = driver.findElement(By.cssSelector(".mn-connections__entity-info strong"));
        WebElement postImpressions = driver.findElement(By.cssSelector(".mn-feed-summary__viewer-count"));

        System.out.println("Who's viewed your profile: " + profileViews.getText());
        System.out.println("Impressions of your post: " + postImpressions.getText());

        

       // close the browser
        driver.quit();
    }

}