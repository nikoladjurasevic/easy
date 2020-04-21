import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

public class SingleRadioButton extends BaseTest{

    @Test
    public void testSingleRadioButton() {
        log.info("testSingleRadioButton()");
        String sExpectedSuccessMessage = "Radio button 'Male' is checked";

        WebDriver driver = openChromeDriver();
        BasePage page = new BasePage(driver);
        page.clickBasicExamples();
        page.clickRadioButtonsDemoLinkFromBoard();
        page.clickMaleRadioButtonInRadioButtonDemoSection();
        page.clickGetCheckedValueButton();
        String sCurrentSuccessMessage = page.getRadioButtonDemoMessage();
        assert sCurrentSuccessMessage.equals(sExpectedSuccessMessage) : "Wrong text: Expected: " + sExpectedSuccessMessage + ", but got: " +sCurrentSuccessMessage;
        driver.quit();
    }

}
