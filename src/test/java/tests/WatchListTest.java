package tests;

import configurations.ConfigImdb;
import keywords.Log;
import keywords.WatchList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WatchListTest {
  private WebDriver driver;
  private String email = System.getenv("email");
  private String password = System.getenv("password");
  private String url = "https://www.imdb.com";
  private String searchInput = "Spider-Man: Far From Home";

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", ConfigImdb.driver);
    driver = new ChromeDriver();
    Log.logIn(driver, url, email, password);
  }

  @Test
  public void isMovieAdded() {
    WatchList.getWatchlistPage(driver);
    Assert.assertEquals("(" + WatchList.convertSumOfMoviesAddedToString() + ")", WatchList.getActualSumOfMoviesAdded(driver));
  }

  @After
  public void close() {
    driver.quit();
  }
}
