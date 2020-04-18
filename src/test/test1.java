import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BasePage;

public class test1 extends BaseTest {

        @Test
        public void test1(){

                WebDriver driver = openChromeDriver();
                BasePage page = new BasePage(driver);
                WebDriverWait wait = new WebDriverWait(driver,1);
                page.clickBasicExamples();




                //driver.close();
    }


}
