import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Imdb {
  private WebDriver driver = new FirefoxDriver();

  public void getUrl(String url) {
    driver.get(url);
  }

  public void signIn(String email, String password) {
    driver.findElement(By.className("signin-imdb-text")).click();
    driver.findElement(By.className("provider-imdb")).click();
    driver.findElement(By.id("ap_email")).sendKeys(email);
    driver.findElement(By.id("ap_password")).sendKeys(password);
    driver.findElement(By.id("signInSubmit")).click();
  }
}
