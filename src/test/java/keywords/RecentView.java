package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecentView {
  private static WebDriverWait waitDriver;

  private static WebElement activityButton;
  private static WebElement clearButton;

  public static void getActivityPage(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, Log.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("nbusername")));
    activityButton = driver.findElement(By.id("nbusername"));
    activityButton.click();
  }

  public static void clearHistory(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, Log.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("clear_rvi")));
    clearButton = driver.findElement(By.id("clear_rvi"));
    clearButton.click();
  }
}
