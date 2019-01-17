package tests;

import keywords.Account;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInTest {
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
    Account.logIn(driver, url, email, password);
    Assert.assertEquals("Róbert", Account.getUserName(driver));
  }

  @After
  public void close() {
    driver.quit();
  }
}
