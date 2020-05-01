package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    static final Logger log = LogManager.getLogger(BasePage.class);
    //Home page locators

    @FindBy(id= "site-name")
    WebElement homeLogoLocator;

    @FindBy(className = "panel panel-default")
    WebElement leftSideMenuLocator;

    @FindBy(id = "home_bar")
    WebElement homeButtonLocator;

    @FindBy(id = "basic_example")
    WebElement basicExampleButtonLocator;

    @FindBy (className = "at4win")
    WebElement modalLocator;

    @FindBy (className = "at4-close")
    WebElement closeModalLocator;

    //Simple Form Demo page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./basic-first-form-demo.html')]")
    WebElement simpleFormDemoBoardLocator;

    @FindBy(id = "user-message")
    WebElement messageLocator;

    @FindBy(xpath = "//form[@id='get-input']//button[@class ='btn btn-default']")
    WebElement showMessageButtonLocator;

    @FindBy(xpath = "//div[@id='user-message']//span")
    WebElement customMessageTextLocator;

    @FindBy(id = "sum1")
    WebElement enterALocator;

    @FindBy(id = "sum2")
    WebElement enterBLocator;

    @FindBy(xpath = "//form[@id='gettotal']/button[@class='btn btn-default']")
    WebElement getTotalButtonLocator;

    @FindBy(id = "displayvalue")
    WebElement displayValueLocator;

    //Basic Checkbox Demo page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./basic-checkbox-demo.html')]")
    WebElement checkboxDemoBoardLocator;

    @FindBy(id = "isAgeSelected")
    WebElement singleCheckboxLocator;

    @FindBy(id = "txtAge")
    WebElement successMessageForCheckboxLocator;

    //Radio Button Demo page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./basic-radiobutton-demo.html')]")
    WebElement radioButtonDemoBoardLocator;

    @FindBy(xpath = "//div[text() = 'Radio Button Demo']/..//input[@value = 'Male']")
    WebElement maleRadioButtonInRadioButtonDemoGroupLocator;

    @FindBy(xpath = "//div[text() = 'Radio Button Demo']/..//button[@id = 'buttoncheck']")
    WebElement getCheckedValueButtonLocator;

    @FindBy(xpath = "//div[text() = 'Radio Button Demo']/..//p[@class = 'radiobutton']")
    WebElement getRadioButtonDemoMessageLocator;

    //Select Dropdown List page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./basic-select-dropdown-demo.html')]")
    WebElement dropdownListBoardLocator;

    @FindBy(id = "select-demo")
    WebElement selectListDemoDropdownLocator;

    @FindBy(xpath = "//p[@class = 'selected-value']")
    WebElement selectListDemoMessageLocator;

    //JavaScript Alerts page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./javascript-alert-box-demo.html')]")
    WebElement javaScriptAlertsBoardLocator;

    @FindBy(xpath = "//button[@onclick = 'myAlertFunction()']")
    WebElement javaScriptAlertBoxButtonLocator;

    //Window Popup Modal page locators

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./window-popup-modal-demo.html')]")
    WebElement windowPopupModalBoardLocator;

    @FindBy(xpath = "//a[@title = 'Follow @seleniumeasy on Twitter']")
    WebElement followOnTwitterButtonLocator;

    //Bootstrap alerts

    @FindBy(xpath = "//div[@class= 'list-group']/a[contains(@href,'./bootstrap-alert-messages-demo.html')]")
    WebElement bootstrapAlertsBoardLocator;

    @FindBy(className = "btn btn-primary btn-success btn-block")
    WebElement bootStrapAlertsButtonLocator;

    String sBootStrapButtonsClassName = "//button[contains(@class, 'btn btn-primary')]";

    String sBootStrapAlertClassName = "//div[contains(@class, 'alert alert')]";

    protected WebDriver driver = null;
    public BasePage(WebDriver driver) {
        log.debug("BasePage");
        PageFactory.initElements(driver, this);
        this.driver = driver;
        closeModalIfShows();
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

    public void checkUrl(String sUrl) {
        log.debug("checkRedirectUrl (" + sUrl + ")");
        String sCurrentUrl = driver.getCurrentUrl();
        assert sCurrentUrl.contains(sUrl) : "Wrong URL. Expected: " + sUrl + ", but got: " + sCurrentUrl;
    }

    public void closeModalIfShows() {
        log.debug("closeModalIfShows()");
        Boolean bIsPresent = isElementPresent(modalLocator);
        if(bIsPresent) closeModalLocator.click();
    }

    //Home page methods

    public void clickBasicExamples() {
        log.debug("clickBasicExamples()");
        assert isElementPresent(basicExampleButtonLocator) : "Basic Examples Link is not present on page";
        basicExampleButtonLocator.click();
    }

    public void clickSimpleFormDemoLinkFromBoard() {
        log.debug("clickSimpleFormDemoLinkFromBoard()");
        assert isElementPresent(simpleFormDemoBoardLocator) : "Simple Form Demo Locator on Board is not present";
        simpleFormDemoBoardLocator.click();
        checkUrl(PageUrls.basic_first_form_demo_url);
    }

    public void clickChecBoxDemoLinkFromBoard() {
        log.debug("clickChecBoxDemoLinkFromBoard()");
        assert isElementPresent(checkboxDemoBoardLocator) : "Checkbox Demo locator on Board is not present";
        checkboxDemoBoardLocator.click();
        checkUrl(PageUrls.basic_checkbox_demo_url);
    }

    public void clickRadioButtonsDemoLinkFromBoard() {
        log.debug("clickRadioButtonsDemoLinkFromBoard()");
        assert isElementPresent(radioButtonDemoBoardLocator) : "Radio Buttons Demo locator on Board is not present";
        radioButtonDemoBoardLocator.click();
        checkUrl(PageUrls.basic_radiobutton_demo_url);
    }

    public void clickSelectDropdownListFromBoard() {
        log.debug("clickSelectDropdownListFromBoard()");
        assert isElementPresent(dropdownListBoardLocator) : "Select Dropdown List locator on Board is not present";
        dropdownListBoardLocator.click();
        checkUrl(PageUrls.basic_select_dropdown_demo_url);
    }

    public void clickJavaScriptAlertsFromBoard() {
        log.debug("clickJavaScriptAlertsFromBoard()");
        assert isElementPresent(javaScriptAlertsBoardLocator) : "Javascript Alerts locator on Board is not present";
        javaScriptAlertsBoardLocator.click();
        checkUrl(PageUrls.basic_javascript_alert_box_demo_url);
    }

    public void clickWindowPopupModalFromBoard() {
        log.debug("clickWindowPopupModalFromBoard()");
        assert isElementPresent(windowPopupModalBoardLocator) : "Window Popup Modal locator on Board is not present";
        windowPopupModalBoardLocator.click();
        checkUrl(PageUrls.basic_window_popup_modal_demo_url);
    }

    public void clickBootstrapAlertFromBoard() {
        log.debug("clickBootstrapAlertFromBoard()");
        assert isElementPresent(bootstrapAlertsBoardLocator) : "Bootstrap Alert locator on Board is not present";
        bootstrapAlertsBoardLocator.click();
        checkUrl(PageUrls.basis_boostrap_alert_demo_url);
    }


    //Simple Form demo page methods

    public void enterMessageForSingleInputField(String sText) {
        log.debug("enterMessageForSingleInputField(" + sText + "");
        assert isElementPresent(messageLocator) : "Single Input Field is not present on page";
        messageLocator.sendKeys(sText);
    }

    public void clickShowMessageForSingleInputField() {
        log.debug("clickShowMessageForSingleInputField()");
        assert isElementPresent(showMessageButtonLocator) : "Show message button is not present on page ";
        showMessageButtonLocator.click();
    }

    public String getYourMessageText() {
        log.debug("getYourMessageText()");
        assert isElementPresent(customMessageTextLocator) : "Custom Message text is not present";
        String currentMessageText = customMessageTextLocator.getText();
        return currentMessageText;
    }

    /**
     * Enter values sValueA and sValueB into 'Two Input Fields'
     * values can be null for negative testing
     * @param sValueA
     * @param sValueB
     */
    public void enterValues(String sValueA, String sValueB){
        log.debug("enterValues(" + sValueA + ", " + sValueB + ")");
        assert isElementPresent(enterALocator) : "First of two input fields is NOT present!";
        assert isElementPresent(enterBLocator) : "Second of two intput fields is NOT present!";
        if(sValueA != null){ // For negative testing
            enterALocator.sendKeys(sValueA);
        }
        if(sValueB != null){ // For negative testing
            enterBLocator.sendKeys(sValueB);
        }
    }

    /**
     * Click on 'Get Total' button
     */
    public void clickGetTotal(){
        log.debug("clickGetTotal()");
        assert isElementPresent(getTotalButtonLocator) : "'Get Total' button is NOT present!";
        getTotalButtonLocator.click();
    }

    /**
     * Gets value of 'Total a + b = '
     * @return {String}
     */
    public String getTotalValue(){
        log.debug("getTotalValue()");
        assert isElementPresent(displayValueLocator) : "'Total a + b' is NOT present!";
        String sTotal = displayValueLocator.getText();
        return sTotal;
    }

    //Basic Checkbox Demo page methods
    public void clickCheckboxForSingleCheckboxDemo() {
        log.debug("clickCheckboxForSingleCheckboxDemo()");
        singleCheckboxLocator.click();
    }

    public Boolean isSingleCheckboxChecked() {
        log.debug("isSingleCheckboxChecked()");
        Boolean isShown = successMessageForCheckboxLocator.getAttribute("style").contains("block");
        return isShown;
    }

    public void checkSingleCheckboxDemo() {
        log.debug("checkSingleCheckboxDemo()");
        assert isElementPresent(singleCheckboxLocator) : "Single checkbox is not present";
        Boolean bChecked = isSingleCheckboxChecked();
        if(bChecked==false) {
            clickCheckboxForSingleCheckboxDemo();
        }
    }

    public String getSingleCheckboxSuccessMessage() {
        log.debug("getSingleCheckboxSuccessMessage()");
        assert isElementPresent(successMessageForCheckboxLocator) : "Success message is not present";
        String sMessage = successMessageForCheckboxLocator.getText();
        return sMessage;
    }

    //Basic Radio Button Demo page methods

    public void clickMaleRadioButtonInRadioButtonDemoSection() {
        log.debug("clickMaleRadioButtonInRadioButtonDemoSection()");
        assert isElementPresent(maleRadioButtonInRadioButtonDemoGroupLocator) : "Male radio button on Radio Button Demo section is not present";
        maleRadioButtonInRadioButtonDemoGroupLocator.click();
    }

    public void clickGetCheckedValueButton() {
        log.debug("clickGetCheckedValueButton()");
        assert  isElementPresent(getCheckedValueButtonLocator) : "Get Checked Value button is not present";
        getCheckedValueButtonLocator.click();
    }

    public String getRadioButtonDemoMessage() {
        log.debug("getRadioButtonDemoMessage()");
        assert isElementPresent(getRadioButtonDemoMessageLocator) : "Radio Button Demo message is not present";
        String sMessage = getRadioButtonDemoMessageLocator.getText();
        return sMessage;
        }


    //Basic Select Dropdown Demo page methods

    public void clickSelectListDemoDropdown() {
        log.debug("clickSelectListDemoDropdown()");
        assert isElementPresent(selectListDemoDropdownLocator): "Select List Demo Dropdown is not present";
        selectListDemoDropdownLocator.click();
    }

    public void selectValueFromSelectListDemoDropdown(String sValue) {
        log.debug("selectValueFromSelectListDemoDropdown (" + sValue + ")");
        assert isElementPresent(selectListDemoDropdownLocator) : "Select List Demo Dropdown is not present";
        Select day = new Select(selectListDemoDropdownLocator);
        day.selectByValue(sValue);
    }

    public String getSelectListDemoMessage() {
        log.debug("getSelectListDemoMessage()");
        assert isElementPresent(selectListDemoMessageLocator) : "Select List Demo Message is not present";
        String sMessage = selectListDemoMessageLocator.getText();
        return sMessage;
    }

    //Basic Java Script Alerts Demo page methods

    public void clickJavaScriptAlertBoxButton() {
        log.debug("clickJavaScriptAlertBoxButton()");
        assert isElementPresent(javaScriptAlertBoxButtonLocator) : "Java Script Alert Box button is no present";
        javaScriptAlertBoxButtonLocator.click();
    }

    //Basic Window Popup Modal Demo page methods

    public void clickFollowOnTwitterButton() {
        log.debug("clickFollowOnTwitterButton()");
        assert isElementPresent(followOnTwitterButtonLocator) : "Follow on Twitter button is not present";
        followOnTwitterButtonLocator.click();
    }

    //BootStrap Alerts Demo page methods


    public List<WebElement> getAllAlertButtonsLocators() {
        log.debug("getAllAlertButtons()");
        List<WebElement> buttons = driver.findElements(By.xpath(sBootStrapButtonsClassName));
        return buttons;
    }

    public int getNumberOfAlertButtonsPresent() {
        log.debug("getNumberOfAlertButtonsPresent()");
        List<WebElement> buttons = getAllAlertButtonsLocators();
        return buttons.size();
    }

    public boolean areAllAlertsButtonsPresent(int iCount) {
        log.debug("areAllAlertsButtonsPresent(" + Integer.toString(iCount) + ")");
        int iActualNumberOfButtons = getNumberOfAlertButtonsPresent();
        return iActualNumberOfButtons==iCount;
    }

    public void clickAlertButtonWithLabel(String sButtonName) {
        log.debug("clickAlertButtonWithLabel(" + sButtonName + ")");
        List<WebElement> elements = getAllAlertButtonsLocators();
        for (int i=0;i<elements.size();i++) {
            WebElement element = elements.get(i);
            if(element.getText().equals(sButtonName)) {
                element.click();
                break;
            }
        }
    }

    public List<WebElement> getAllAlertsLocators () {
        log.debug("getAllAlertsLocators()");
        List<WebElement> elements  = driver.findElements(By.xpath(sBootStrapAlertClassName));

        assert elements.size()!=0 : "No elements are present on page";
        return elements;
    }

    public boolean isAlertWithTextShown (String sText) {
        log.debug("isAlertWithTextShown(" + sText + ")");
        List<WebElement> alerts = getAllAlertsLocators();
        boolean bIsPresent = false;
        for (int i=0; i<alerts.size(); i++) {
            WebElement alert = alerts.get(i);
            String sActualText = alert.getAttribute("class");
            String sStyleAttribute = alert.getAttribute("style");
            if(sActualText.contains(sText) && sStyleAttribute.equals("display: block;")) {
                bIsPresent = true;
                break;
            }
        }
        return bIsPresent;
    }

    public boolean isAlertClosed (String sText) {
        log.debug("isAlertClosed(" + sText + ")");
        List<WebElement> alerts = getAllAlertsLocators();
        boolean bIsPresent = false;
        for (int i=0; i<alerts.size(); i++) {
            WebElement alert = alerts.get(i);
            String sActualText = alert.getAttribute("class");
            String sStyleAttribute = alert.getAttribute("style");
            if(sActualText.contains(sText) && sStyleAttribute.equals("display: none;")) {
                bIsPresent = true;
                break;
            }
        }
        return bIsPresent;
    }


}
