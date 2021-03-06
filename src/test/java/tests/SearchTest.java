package tests;

import configurations.ConfigImdb;
import keywords.SearchValue;
import keywords.Log;
import keywords.Search;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
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
  public void searchTest() {
    Search.search(driver, searchInput, SearchValue.ALL.toString().toLowerCase());
    Search.selectSearchResult(driver, searchInput);
    Assert.assertEquals("Search category:", Search.getSearchProof(driver));
  }

  @After
  public void close() {
    driver.quit();
  }
}
