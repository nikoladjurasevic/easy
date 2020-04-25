import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PageUrls;

import java.util.ArrayList;

public class SingleTwitterWindowPopup extends  BaseTest{
    @Test
    public void testSingleTwitterWindowPopup() {
        log.info("testSingleTwitterWindowPopup()");
        String sExpectedLink = "seleniumeasy";
        String sBasicWindowPopUpModalUrl = PageUrls.basic_window_popup_modal_demo_url;

        WebDriver driver = openChromeDriver();
        BasePage page = new BasePage(driver);
        page.clickBasicExamples();
        page.clickWindowPopupModalFromBoard();
        String oldTab = driver.getWindowHandle();
        log.debug("printing old tab handle: " + oldTab);
        log.debug("Clicking on 'Follow us on Twitter button'");
        page.clickFollowOnTwitterButton();
        ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
        assert allTabs.size()==2 : "To many open tabs. Expected 2, but got: " + allTabs.size();
        allTabs.remove(oldTab);
        String newTab = allTabs.get(0);
        log.debug("Printing new tab handle: " + newTab);
        driver.switchTo().window(newTab);
        assert driver.getCurrentUrl().contains("twitter.com") : "Url of window popup should contain 'twitter.com', but it does not. Current url: "
                + driver.getCurrentUrl();
        String sHref = driver.findElement(By.cssSelector(".fn.url.alternate-context")).getAttribute("href");
        assert sHref.contains(sExpectedLink) : "Link in popup should contain: " + sExpectedLink + ", but it contains: " + sHref;
        driver.close();
        driver.switchTo().window(oldTab);
        assert driver.getCurrentUrl().equals(sBasicWindowPopUpModalUrl) : "Driver should have moved to old tab " + sBasicWindowPopUpModalUrl +
                ", but it is on: "  + driver.getCurrentUrl();
        assert driver.getWindowHandles().size()==1 : "Pop up should be closed, but it is not";

        driver.quit();
    }

}
