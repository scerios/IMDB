package tests;

import keywords.Log;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogTest {
  private WebDriver driver;
  private String email = "89.t.robert@gmail.com";
  private String password = "lFCTJJT0";
  private String url = "https://www.imdb.com";

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
  }

  @Test
  public void logInTest() {
    Log.logIn(driver, url, email, password);
    Assert.assertEquals("Róbert", Log.getUserName(driver));
  }

  @Test
  public void logOutTest() {
    Log.logOut(driver);
    Assert.assertEquals("Sign in", Log.logOutProof(driver));
  }

  @After
  public void close() {
    driver.quit();
  }
}
