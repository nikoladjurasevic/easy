import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.PageUrls;

import java.io.File;

public class BaseTest {
    static final Logger log = LogManager.getLogger(BaseTest.class);

    WebDriver openChromeDriver() {
        log.debug("Setting up Chrome driver");
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
        log.debug("Opening Chrome driver");
        driver.get(PageUrls.homeUrl);
        return  driver;

    }




}
