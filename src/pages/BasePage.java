package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(id= "site-name")
    WebElement homeLogo;

    @FindBy(className = "panel panel-default")
    WebElement leftSideMenu;

    @FindBy(id = "home_bar")
    WebElement homeButton;

    @FindBy(id = "basic_example")
    WebElement basicExampleButton;




    protected WebDriver driver = null;
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    private Boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void clickBasicExamples() {
        assert isElementPresent(basicExampleButton) : "Basic Examples Link is not present on page";
        basicExampleButton.click();
    }








}
