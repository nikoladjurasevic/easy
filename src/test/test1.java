import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class test1  extends BaseTest {

        @Test
        public void test1(){

                WebDriver driver = openChromeDriver();
                BasePage page = new BasePage(driver);
                page.clickBasicExamples();




                //driver.close();
    }


}
