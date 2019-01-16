public class RunTest {
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    Imdb imdb = new Imdb();
    imdb.getUrl("https://www.imdb.com");
    imdb.signIn("89.t.robert@gmail.com", "lFCTJJT0");
    Thread.sleep(2000);
    imdb.search("Far From Home", "tt");
  }
}
