import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    public String homeUrl = "https://www.seleniumeasy.com/test/";





    WebDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\easy\\src\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(homeUrl);
        return  driver;

    }




}
