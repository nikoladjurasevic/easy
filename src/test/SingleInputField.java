import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BasePage;

public class SingleInputField extends BaseTest {

        @Test
        public void testSingleInputField(){

                WebDriver driver = openChromeDriver();
                BasePage page = new BasePage(driver);
                WebDriverWait wait = new WebDriverWait(driver,2);
                //Thread.sleep(500);
                page.clickBasicExamples();
                page.clickSimpleFormDemoFromBoard();
                String currentUrl = driver.getCurrentUrl();
                assert currentUrl.contains("basic-first-form-demo") : "Wrong URL";
                page.enterMessageForSingleInputField("Neki random text");




                //driver.close();
    }


}
