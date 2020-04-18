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



    protected WebDriver driver = null;
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBasicExamples() {
        basicExampleButton.click();
    }







}
