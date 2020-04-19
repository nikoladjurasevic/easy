import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BasePage;

public class SingleInputField extends BaseTest {

        @Test
        public void testSingleInputField(){

                String sMessage = "Neki random text";

                WebDriver driver = openChromeDriver();
                BasePage page = new BasePage(driver);
                WebDriverWait wait = new WebDriverWait(driver,2);
                page.clickBasicExamples();
                page.clickSimpleFormDemoFromBoard();
                String currentUrl = driver.getCurrentUrl();
                assert currentUrl.contains("basic-first-form-demo") : "Wrong URL";
                page.enterMessageForSingleInputField(sMessage);
                page.clickShowMessageForSingleInputField();
                String sCurrentMessageText = page.getYourMessageText();
                assert sCurrentMessageText.equals(sMessage) : "Expected: " + sMessage + ", but got: " + sCurrentMessageText;
                driver.close();
    }


}
