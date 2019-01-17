package tests;

import keywords.Account;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInTest {
  private WebDriver driver;
  private WebDriverWait waitDriver;
  private String email = "89.t.robert@gmail.com";
  private String password = "lFCTJJT0";
  private String url = "https://www.imdb.com";
  private String userName;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
//    driver.manage().window().maximize();
  }

  @Test
  public void logIn() {
    Account.logIn(driver, url, email, password);
    userName = driver.findElement(By.id("nbusername")).getText();
    System.out.println(userName);
    Assert.assertEquals("Róbert", userName);
  }

  @After
  public void close() {
    driver.quit();
  }
}
