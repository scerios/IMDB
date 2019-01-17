package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class WatchList {
  private static WebDriverWait waitDriver;

  private static WebElement quickSearchDropDown;
  private static WebElement watchListMenu;
  private static WebElement button;
  private static List<WebElement> searchResult;

  public static void addToWatchlist(WebDriver driver, String searchInput) {
    waitDriver = new WebDriverWait(driver, LogIn.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("navWatchlistMenu")));

    watchListMenu = driver.findElement(By.id("navWatchlistMenu"));
    watchListMenu.click();
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.className("button-title")));

    button = driver.findElement(By.className("button-title"));
    button.click();
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-list-search")));

    quickSearchDropDown = driver.findElement(By.id("add-to-list-search"));
    quickSearchDropDown.sendKeys(searchInput);
    searchResult = driver.findElements(By.xpath("//div[@id='add-to-list-search-results']//a[@class='search_item']"));
    System.out.println(searchResult.size());
  }
}
