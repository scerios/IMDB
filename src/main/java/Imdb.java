import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class Imdb {
  private WebDriver driver = new FirefoxDriver();

  void getUrl(String url) {
    driver.get(url);
    driver.manage().window().maximize();
  }

  void signIn(String email, String password) {
    driver.findElement(By.className("signin-imdb-text")).click();
    driver.findElement(By.className("provider-imdb")).click();
    driver.findElement(By.id("ap_email")).sendKeys(email);
    driver.findElement(By.id("ap_password")).sendKeys(password);
    driver.findElement(By.id("signInSubmit")).click();
  }

  void search(String input, String searchValue) {
    driver.findElement(By.id("navbar-query")).sendKeys(input);
    WebElement quickSearchDropDown = driver.findElement(By.id("quicksearch"));
    Select quickSearch = new Select(quickSearchDropDown);
    quickSearch.selectByValue(searchValue);
    driver.findElement(By.id("navbar-submit-button")).click();
  }
}
