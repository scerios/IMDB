package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WatchList {
  private static WebDriverWait waitDriver;

  private static WebElement button;

  public static void addToWatchlist(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, LogIn.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.className("ribbonize")));

    button = driver.findElement(By.className("ribbonize"));
    button.click();
  }

  public static void getWatchlistPage(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, LogIn.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Watchlist")));

    button = driver.findElement(By.linkText("Watchlist"));
    button.click();
  }
}
