package tests;

import keywords.Log;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogInTest {
  private WebDriver driver;
  private String email = System.getenv("email");
  private String password = System.getenv("password");
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

  @After
  public void close() {
    driver.quit();
  }
}
