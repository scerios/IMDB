package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Log {
  public static final int WAIT_TIMEOUT = 10;
  private static WebDriverWait waitDriver;
  private static Actions mouseOver;

  private static WebElement signIn;
  private static WebElement signInWithImdb;
  private static WebElement logInUser;
  private static WebElement logInPassword;
  private static WebElement userName;
  private static WebElement submit;
  private static WebElement logOutButton;


  public static void logIn(WebDriver driver, String url, String email, String password) {
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

  public static void logOut(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("nbusername")));

    userName = driver.findElement(By.id("nbusername"));
    mouseOver = new Actions(driver);
    mouseOver.moveToElement(userName).build().perform();
    waitDriver.until(ExpectedConditions.elementToBeClickable(By.id("nblogout")));
    logOutButton = driver.findElement(By.id("nblogout"));
    logOutButton.click();
  }

  public static String getUserName(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
    userName = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("nbusername")));
    return userName.getText();
  }

  public static String logOutProof(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, WAIT_TIMEOUT);
    userName = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.className("signin-imdb-text")));
    return userName.getText();
  }
}
