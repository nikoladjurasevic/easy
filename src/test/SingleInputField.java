import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

public class SingleInputField extends BaseTest {


        @Test
        public void testSingleInputField(){
                log.info("testSingleInputField()");
                String sMessage = "Neki random text";

                WebDriver driver = openChromeDriver();
                BasePage page = new BasePage(driver);
                log.debug("click on Basic examples button");
                page.clickBasicExamples();
                log.debug("click on Simple form demo");
                page.clickSimpleFormDemoLinkFromBoard();
                page.enterMessageForSingleInputField(sMessage);
                page.clickShowMessageForSingleInputField();
                String sCurrentMessageText = page.getYourMessageText();
                assert sCurrentMessageText.equals(sMessage) : "Expected: " + sMessage + ", but got: " + sCurrentMessageText;;
                driver.quit();
    }


}
