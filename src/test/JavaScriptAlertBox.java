import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

public class JavaScriptAlertBox extends BaseTest{
    @Test
    public void testJavaScriptAlertBox() {
        log.info("testJavaScriptAlertBox()");
        String sExpectedAlertMessage = "I am an alert box!";

        WebDriver driver = openChromeDriver();
        BasePage page = new BasePage(driver);
        page.clickBasicExamples();
        page.clickJavaScriptAlertsFromBoard();
        page.clickJavaScriptAlertBoxButton();
        Alert alert = driver.switchTo().alert();
        String sCurrentAlertMessage = driver.switchTo().alert().getText();
        assert sCurrentAlertMessage.equals(sExpectedAlertMessage) : "Wrong text: Expected: " + sExpectedAlertMessage
                + ", but got: " + sCurrentAlertMessage;
        alert.accept();
        driver.quit();
    }
}
