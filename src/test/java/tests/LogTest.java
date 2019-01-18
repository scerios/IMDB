package tests;

import keywords.LogIn;
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
    LogIn.logIn(driver, url, email, password);
  }

//  @Test
//  public void logInTest() {
//    LogIn.logIn(driver, url, email, password);
//    Assert.assertEquals("Róbert", LogIn.getUserName(driver));
//  }

  @Test
  public void logOutTest() {
    LogIn.logOut(driver);
    Assert.assertEquals("Sign in", LogIn.logOutProof(driver));
  }

  @After
  public void close() {
    driver.quit();
  }
}
