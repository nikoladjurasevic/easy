import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class test1 {

        @Test
        public void test1() {

                WebDriver driver;
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "C:\\easy\\src\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get("https://www.seleniumeasy.com/test/");
                driver.close();
    }


}
