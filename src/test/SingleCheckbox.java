import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;


public class SingleCheckbox extends BaseTest {

    @Test
    public void testSingleCheckboxTest() {
        log.info("testSingleCheckboxTest()");
        String sExpectedSuccessMessage = "Success - Check box is checked";

        WebDriver driver = openChromeDriver();
        BasePage page = new BasePage(driver);
        page.clickBasicExamples();
        page.clickChecBoxDemoLinkFromBoard();;
        page.checkSingleCheckboxDemo();
        String sCurrentSuccessMessage = page.getSingleCheckboxSuccessMessage();
        assert sCurrentSuccessMessage.equals(sExpectedSuccessMessage) : "Wrong text: Expected: " + sExpectedSuccessMessage + ", but got: " +sCurrentSuccessMessage;
        driver.quit();
    }
}
