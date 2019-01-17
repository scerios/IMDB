package tests;

import keywords.LogIn;
import keywords.Search;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTest {
  private WebDriver driver;
  private String email = "89.t.robert@gmail.com";
  private String password = "lFCTJJT0";
  private String url = "https://www.imdb.com";
  private String searchInput = "Far From Home";
  private String searchValue = "tt";

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
  }

  @Test
  public void searchTest() {
    LogIn.logIn(driver, url, email, password);
    Search.search(driver, searchInput, searchValue);
    Assert.assertEquals("Search category:", Search.getSearchProof(driver));
  }

  @After
  public void close() {
    driver.quit();
  }
}
