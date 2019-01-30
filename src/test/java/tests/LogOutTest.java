package tests;

import keywords.Log;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogOutTest {
  private WebDriver driver;
  private String email = System.getenv("email");
  private String password = System.getenv("password");
  private String url = "https://www.imdb.com";

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
    Log.logIn(driver, url, email, password);
  }

  @After
  public void close() {
    driver.quit();
  }

  @Test
  public void logOutTest() {
    Log.logOut(driver);
    Assert.assertEquals("Sign in", Log.logOutProof(driver));
  }
}