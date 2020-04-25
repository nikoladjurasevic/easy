import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BasePage;

@Test
public class SimpleFormDemo extends BaseTest{

    @Test
    public void testSimpleFormDemoTwoImputFieldsPositive() throws Exception{
        log.info("[RUNNING TEST] testSimpleFormDemoTwoImputFieldsPositive() ");

        String sA = "5";
        String sB = "7";

        testSimpleFormDemo(sA, sB);

    }

    @Test
    public void testSimpleFormDemoTwoImputFieldsNegative1() throws Exception{
        log.info("[RUNNING TEST] testSimpleFormDemoTwoImputFieldsNegative1()");
        String sA = "Nesto";
        String sB = "Nesto Drugo";

        testSimpleFormDemo(sA, sB);
    }

    @Test
    public void testSimpleFormDemoTwoImputFieldsNegative2() throws Exception{
        log.info("[RUNNING TEST] testSimpleFormDemoTwoImputFieldsNegative2()");
        String sA = "3.14";
        String sB = null;

        testSimpleFormDemo(sA, sB);
    }


    /**
     * jebala me Lin
     * @param sValueA
     * @param sValueB
     */
    protected void testSimpleFormDemo(String sValueA, String sValueB){
        String sExpectedValue;
        String sExpectedNegativeValue = "NaN";
        if (isNumber(sValueA) && isNumber(sValueB)){
            int iResult = Integer.parseInt(sValueA) + Integer.parseInt(sValueB);
            sExpectedValue = Integer.toString(iResult);
        } else {
            sExpectedValue = sExpectedNegativeValue;
        }

        WebDriver driver = openChromeDriver();
        try{
            BasePage basePage = new BasePage(driver);
            log.debug("Navigate to Simple Demo Form from Basic Examples");
            basePage.clickBasicExamples();
            basePage.clickSimpleFormDemoLinkFromBoard();

            log.debug("Enter values: " + sValueA + " and " + sValueB + " and click on 'Get Total' button");
            basePage.enterValues(sValueA, sValueB);
            basePage.clickGetTotal();
            String sActualTotalValue = basePage.getTotalValue();

            log.debug("Verify that Total is equal to the sum of two values(positive) / or 'NaN' (negative)");
            assert sActualTotalValue.equalsIgnoreCase(sExpectedValue) : "Total values do NOT match! Expected: " + sExpectedValue +
                    " , but got: " + sActualTotalValue + "!";
        }finally {
            driver.quit();
        }
    }
}
