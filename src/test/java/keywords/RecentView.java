package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecentView {
  private static WebDriverWait waitDriver;

  private static WebElement activityButton;

  public static void getActivityPage(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, LogIn.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("nbusername")));
    activityButton = driver.findElement(By.id("nbusername"));
    activityButton.click();
  }
}
