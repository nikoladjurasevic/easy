import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

public class SingleSelectList extends BaseTest{
    @Test
    public void testSingleSelectList() {
        log.info("testSingleSelectList()");
        String sDay = "Sunday";
        String sExpectedSuccessMessage = "Day selected :- " + sDay;

        WebDriver driver = openChromeDriver();
        BasePage page = new BasePage(driver);
        page.clickBasicExamples();
        page.clickSelectDropdownListFromBoard();
//        page.clickSelectListDemoDropdown();
        page.selectValueFromSelectListDemoDropdown(sDay);
        String sCurrentSuccessMessage = page.getSelectListDemoMessage();
        assert sCurrentSuccessMessage.equals(sExpectedSuccessMessage) : "Wrong text: Expected: " + sExpectedSuccessMessage + ", but got: " +sCurrentSuccessMessage;
        driver.quit();
    }

}
