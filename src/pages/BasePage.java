package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(id= "site-name")
    WebElement homeLogo;

    @FindBy(className = "panel panel-default")
    WebElement leftSideMenu;

    @FindBy(id = "home_bar")
    WebElement homeButton;

    @FindBy(xpath = "//a[@href= '#basic']")
    WebElement basicExampleButton;

    By basicExample = By.id("home_bar");



    protected WebDriver driver = null;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    private Boolean isElementPresent(WebElement element) {
        Boolean isPresent = driver.findElements(basicExample).size() == 1;
        return isPresent;
    }

    public void clickBasicExamples() {
        //Boolean isPresent = driver.findElements(basicExample).size() == 1;
        //assert isElementPresent(basicExampleButton) : "trt";
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", basicExampleButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", basicExampleButton);
        //basicExample.click();
    }







}
