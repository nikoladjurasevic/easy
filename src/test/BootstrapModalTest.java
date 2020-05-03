import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

@Test
public class BootstrapModalTest extends BaseTest {

    @Test
    public void testBootstrapSingleModal(){

        log.info("[Running Test] testBootstrapSingleModal()");
        String sExpectedTitle = "Modal Title";
        String sExpectedBody = "This is the place where the content for the modal dialog displays";

        WebDriver driver = openChromeDriver();

        try{
            BasePage basePage = new BasePage(driver);
            basePage.clickBasicExamples();
            basePage.clickBootstrapModalFromBoard();
            WebElement modal = basePage.setModal("SINGLE");

            boolean bIsModalOpen = basePage.isModalOpen(modal);
            if (!bIsModalOpen){
                basePage.clickLaunchSingleModal();
                sleepSeconds(2);
            }
            assert basePage.isModalOpen(modal) : "Single modal is NOT open!";
            String sActualTitle = basePage.getModalTitle(modal);
            assert sActualTitle.equalsIgnoreCase(sExpectedTitle) : "Modal title does NOT match! Expected: " + sExpectedTitle + ", but got: " + sActualTitle + "!";
            String sActualBody = basePage.getModalBody(modal);
            assert sActualBody.contains(sExpectedBody)  : "Actual modal body text: " + sActualBody + " does NOT contains expected modal body text " + sExpectedBody + "!";
            basePage.verifyModalFooter(modal);
            basePage.clickCloseModal(modal);

        } catch (Exception e) { //Ako nema ovog Assert.fail dela, test svejedno prodje, nisam znao, mislio sam da ce ga samo hvatanje greske oboriti. recimo ako na liniji 23 umesto "SINGLE" bude 5
            Assert.fail("Test failed: " + e.getMessage());
        }finally {
            driver.quit();
        }

    }
}
