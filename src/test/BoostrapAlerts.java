import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;


public class BoostrapAlerts extends BaseTest {
    @Test
    public void testBoostrapAlerts() throws InterruptedException {
        log.info("testBoostrapAlerts()");

        String sButtonName = "Autocloseable success message";
        String sAlertText = "I'm an autocloseable success  message. I will hide in 5 seconds.";
        String firstAutoClosableAlert = "success alert-autocloseable-success";

        WebDriver driver = openChromeDriver();
        BasePage page = new BasePage(driver);
        page.clickBasicExamples();
        page.clickBootstrapAlertFromBoard();
        int iNumberOfButtons = page.getNumberOfAlertButtonsPresent();
        assert page.areAllAlertsButtonsPresent(8) : "Wrong number of buttons. Expected: 8, but got: " + iNumberOfButtons;

        page.clickAlertButtonWithLabel(sButtonName);
        assert page.isAlertWithTextShown(firstAutoClosableAlert) : "Expected alert text to be: " + sAlertText;
        sleepSeconds(6);
        assert page.isAlertClosed(firstAutoClosableAlert) : "Alert should be closed after 5 seconds, but it is not";

        driver.quit();
    }

}
