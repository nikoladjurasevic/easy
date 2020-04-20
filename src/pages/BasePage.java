package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static final Logger log = LogManager.getLogger(BasePage.class);
    //Home page locators

    @FindBy(id= "site-name")
    WebElement homeLogoLocator;

    @FindBy(className = "panel panel-default")
    WebElement leftSideMenuLocator;

    @FindBy(id = "home_bar")
    WebElement homeButtonLocator;

    @FindBy(id = "basic_example")
    WebElement basicExampleButtonLocator;

    //Simple Form Demo page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./basic-first-form-demo.html')]")
    WebElement simpleFormDemoBoardLocator;

    @FindBy(id = "user-message")
    WebElement messageLocator;

    @FindBy(xpath = "//form[@id='get-input']//button[@class ='btn btn-default']")
    WebElement showMessageButtonLocator;

    @FindBy(xpath = "//div[@id='user-message']//span")
    WebElement customMessageTextLocator;

    //Basic Checkbox Demo page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./basic-checkbox-demo.html')]")
    WebElement checkboxDemoBoardLocator;

    @FindBy(id = "isAgeSelected")
    WebElement singleCheckboxLocator;

    @FindBy(id = "txtAge")
    WebElement successMessageForCheckboxLocator;

    protected WebDriver driver = null;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //General methods

    private Boolean isElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Boolean isPresent = element.isDisplayed();
        String sElement = element.toString();
        assert isPresent : "WebElement: " + sElement + " is not present on Page";
        return isPresent;
    }

    //Home page methods

    public void clickBasicExamples() {
        assert isElementPresent(basicExampleButtonLocator) : "Basic Examples Link is not present on page";
        basicExampleButtonLocator.click();
    }

    public void clickSimpleFormDemoLinkFromBoard() {
        assert isElementPresent(simpleFormDemoBoardLocator) : "Simple Form Demo Locator on Board is not present";
        simpleFormDemoBoardLocator.click();
    }

    public void clickChecBoxDemoLinkFromBoard() {
        assert isElementPresent(checkboxDemoBoardLocator) : "Checkbox Demo locator on Board is not present";
        checkboxDemoBoardLocator.click();

    }

    //Simple Form demo page methods

    public void enterMessageForSingleInputField(String sText) {
        assert isElementPresent(messageLocator) : "Single Input Field is not present on page";
        messageLocator.sendKeys(sText);
    }

    public void clickShowMessageForSingleInputField() {
        assert isElementPresent(showMessageButtonLocator) : "Show message button is not present on page ";
        showMessageButtonLocator.click();
    }

    public String getYourMessageText() {
        assert isElementPresent(customMessageTextLocator) : "Custom Message text is not present";
        String currentMessageText = customMessageTextLocator.getText();
        return currentMessageText;
    }

    //Basic Checkbox Demo page methods
    public void clickCheckboxForSingleCheckboxDemo() {
        singleCheckboxLocator.click();
    }

    public Boolean isSingleCheckboxChecked() {
        Boolean isShown = successMessageForCheckboxLocator.getAttribute("style").contains("block");
        return isShown;
    }

    public void checkSingleCheckboxDemo() {
        assert isElementPresent(singleCheckboxLocator) : "Single checkbox is not present";
        Boolean bChecked = isSingleCheckboxChecked();
        if(bChecked==false) {
            clickCheckboxForSingleCheckboxDemo();
        }
    }

    public String getSingleCheckboxSuccessMessage() {
        assert isElementPresent(successMessageForCheckboxLocator) : "Success message is not present";
        String sMessage = successMessageForCheckboxLocator.getText();
        return sMessage;
    }

}
