import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PageUrls;

public class SingleInputField extends BaseTest {

        @Test
        public void testSingleInputField(){

                String sMessage = "Neki random text";

                WebDriver driver = openChromeDriver();
                BasePage page = new BasePage(driver);
                page.clickBasicExamples();
                page.clickSimpleFormDemoLinkFromBoard();
                String sCurrentUrl = driver.getCurrentUrl();
                assert sCurrentUrl.equals(PageUrls.basic_first_form_demo_url) : "Wrong URL. Expected: " + PageUrls.basic_first_form_demo_url + ", but got: " +sCurrentUrl;
                page.enterMessageForSingleInputField(sMessage);
                page.clickShowMessageForSingleInputField();
                String sCurrentMessageText = page.getYourMessageText();
                assert sCurrentMessageText.equals(sMessage) : "Expected: " + sMessage + ", but got: " + sCurrentMessageText;
                driver.close();
    }


}
