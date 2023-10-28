package demo;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Imdb_Ratings {
    ChromeDriver driver;
    public Imdb_Ratings()
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
       
    public  void testCase06(){
        System.out.println("Start Test case: testCase01");
       // driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    
    
    //get URL www.google.com
    driver.get("https://www.google.co.in");
     

    //Locate search bar using locater "ID" APjFqb |sendkeys("https://www.imdb.com/chart/top")


    driver.findElement(By.id("APjFqb")).sendKeys("https://www.imdb.com/chart/top");

    //click on google search button using locater "Name" btnk
    driver.findElement(By.name("btnk")).click();
  


        // Find the table of top-rated movies
        WebElement topRatedTable = driver.findElement(By.tagName("tbody"));

        // Find all rows (movies) in the table
        List<WebElement> movieRows = topRatedTable.findElements(By.tagName("tr"));

        // Task 1: Get the highest rated movie on IMDb
        WebElement highestRatedMovie = movieRows.get(0);
        String highestRatedMovieTitle = highestRatedMovie.findElement(By.tagName("a")).getText();
        System.out.println("Highest rated movie on IMDb: " + highestRatedMovieTitle);

        // Task 2: Get the total number of movies in the table
        int numberOfMovies = movieRows.size();
        System.out.println("Number of movies in the table: " + numberOfMovies);

        // Task 3: Find the oldest movie on the list
        WebElement oldestMovie = movieRows.get(movieRows.size() - 1);
        String oldestMovieTitle = oldestMovie.findElement(By.tagName("a")).getText();
        System.out.println("Oldest movie on the list: " + oldestMovieTitle);

        // Task 4: Find the most recent movie on the list
        WebElement mostRecentMovie = movieRows.get(0);
        String mostRecentMovieTitle = mostRecentMovie.findElement(By.tagName("a")).getText();
        System.out.println("Most recent movie on the list: " + mostRecentMovieTitle);

        // Task 5: Find the movie with the most user ratings
        WebElement movieWithMostRatings = movieRows.get(0);
        String movieWithMostRatingsTitle = movieWithMostRatings.findElement(By.tagName("a")).getText();
        System.out.println("Movie with the most user ratings: " + movieWithMostRatingsTitle);

        // Close the browser
        driver.quit();
    }

}