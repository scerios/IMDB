package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {
  public static final int WAIT_TIMEOUT = 10;
  private static WebDriverWait waitDriver;

  private static WebElement signIn;
  private static WebElement signInWithImdb;
  private static WebElement logInUser;
  private static WebElement logInPassword;
  private static WebElement userName;
  private static WebElement submit;

  public static void logIn(WebDriver driver, String url, String email, String password) {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    driver.manage().window().maximize();
    driver.get(url);

    waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.elementToBeClickable(By.className("signin-imdb-text")));

    signIn = driver.findElement(By.className("signin-imdb-text"));
    signIn.click();
    waitDriver.until(ExpectedConditions.elementToBeClickable(By.className("provider-imdb")));

    signInWithImdb = driver.findElement(By.className("provider-imdb"));
    signInWithImdb.click();
    waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));

    logInUser = driver.findElement(By.id("ap_email"));
    logInPassword = driver.findElement(By.id("ap_password"));
    logInUser.sendKeys(email);
    logInPassword.sendKeys(password);
    submit = driver.findElement(By.id("signInSubmit"));
    submit.submit();
  }

  public static String getUserName(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
    userName = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("nbusername")));
    return userName.getText();
  }
}
