package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account {
  public static final int WAIT_TIMEOUT = 5;
  private static WebDriverWait waitDriver;

  private static WebElement logInUser;
  private static WebElement logInPassword;
  private static WebElement userName;

  public static void logIn(WebDriver driver, String url, String email, String password) {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    driver.manage().window().maximize();
    driver.get(url);

    waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.elementToBeClickable(By.className("signin-imdb-text")));
    driver.findElement(By.className("signin-imdb-text")).click();
    waitDriver.until(ExpectedConditions.elementToBeClickable(By.className("provider-imdb")));
    driver.findElement(By.className("provider-imdb")).click();

    logInUser = driver.findElement(By.id("ap_email"));
    logInPassword = driver.findElement(By.id("ap_password"));
    logInUser.sendKeys(email);
    logInPassword.sendKeys(password);
    driver.findElement(By.id("signInSubmit")).click();
  }

  public static String getUserName(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
    userName = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("nbusername")));
    return userName.getText();
  }
}
