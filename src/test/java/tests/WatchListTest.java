package tests;

import keywords.LogIn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WatchListTest {
  private WebDriver driver;
  private String email = "89.t.robert@gmail.com";
  private String password = "lFCTJJT0";
  private String url = "https://www.imdb.com";
  private String searchInput = "Spider-Man: Far From Home";

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
    LogIn.logIn(driver, url, email, password);
  }

  @Test
  public void isMovieAdded() {

  }

  @After
  public void close() {
    driver.quit();
  }
}
