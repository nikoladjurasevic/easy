import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PageUrls;

public class SingleCheckbox extends BaseTest {

    @Test
    public void testSingleCheckboxTest() {
        log.info("testSingleCheckboxTest()");
        String sExpectedSuccessMessage = "Success - Check box is checked";

        WebDriver driver = openChromeDriver();
        BasePage page = new BasePage(driver);
        page.clickBasicExamples();
        page.clickChecBoxDemoLinkFromBoard();;
        String sCurrentUrl = driver.getCurrentUrl();
        assert sCurrentUrl.contains(PageUrls.basic_checkbox_demo_url) : "Wrong URL. Expected: " + PageUrls.basic_checkbox_demo_url + ", but got: " + sCurrentUrl;
        page.checkSingleCheckboxDemo();
        String sCurrentSuccessMessage = page.getSingleCheckboxSuccessMessage();
        assert sCurrentSuccessMessage.equals(sExpectedSuccessMessage) : "Wrong text: Expected: " + sExpectedSuccessMessage + ", but got: " +sCurrentSuccessMessage;
        driver.quit();
    }
}
