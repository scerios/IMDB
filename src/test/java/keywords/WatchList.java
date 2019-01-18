package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WatchList {
  public static long sumOfMoviesAdded = 0;
  private static WebDriverWait waitDriver;

  private static WebElement button;
  private static WebElement added;

  public static void addToWatchlist(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, LogIn.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.className("ribbonize")));

    try {
      added = driver.findElement(By.className("wl-ribbon standalone retina inWL"));
    } catch (NoSuchElementException e) {
      System.out.println("There is no element like that.");
    }

    button = driver.findElement(By.className("ribbonize"));
    if (added == null) {
      setSumOfMoviesAdded();
      button.click();
    }
  }

  public static void getWatchlistPage(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, LogIn.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Watchlist")));

    button = driver.findElement(By.linkText("Watchlist"));
    button.click();
  }

  public static void setSumOfMoviesAdded() {
    sumOfMoviesAdded++;
  }
}
