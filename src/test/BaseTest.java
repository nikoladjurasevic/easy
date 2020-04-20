import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.PageUrls;

public class BaseTest {

    WebDriver openChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        String path = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        System.setProperty("webdriver.chrome.driver", path+separator+"src"+separator+"driver"+separator +"chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:\\easy\\src\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(PageUrls.homeUrl);
        return  driver;

    }




}
