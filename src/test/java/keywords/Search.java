package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Search {
  private static WebDriverWait waitDriver;
  private static Select quickSearch;

  private static WebElement quickSearchDropDown;
  private static WebElement searchProof;

  public static void search(WebDriver driver, String input, String searchValue) {
    waitDriver = new WebDriverWait(driver, Account.WAIT_TIMEOUT);
    waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("navbar-query")));
    driver.findElement(By.id("navbar-query")).sendKeys(input);
    quickSearchDropDown = driver.findElement(By.id("quicksearch"));
    quickSearch = new Select(quickSearchDropDown);
    quickSearch.selectByValue(searchValue);
    driver.findElement(By.id("navbar-submit-button")).click();
  }

  public static String getSearchProof(WebDriver driver) {
    waitDriver = new WebDriverWait(driver, Account.WAIT_TIMEOUT);
    searchProof = waitDriver.until(ExpectedConditions.presenceOfElementLocated(By.id("findSubHeaderLabel")));
    return searchProof.getText();
  }
}
