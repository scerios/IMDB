public class RunTest {
  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Csirke\\Desktop\\Downloads\\Geckodriver\\geckodriver.exe");
    Imdb imdb = new Imdb();
    imdb.getUrl("https://www.imdb.com");
    imdb.signIn("89.t.robert@gmail.com", "lFCTJJT0");
  }
}
