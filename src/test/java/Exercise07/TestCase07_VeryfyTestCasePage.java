package Exercise07;

import Utilities.TestBase;
import com.aventstack.extentreports.ExtentReports;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase07_VeryfyTestCasePage extends TestBase {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Test Cases' button
        //5. Verify user is navigated to test cases page successfully


    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement mainPage= driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(mainPage.isDisplayed());

    }

    @Test
    public void name() {
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");

        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url:automationexercise.com");
         //      if there is a popup add, close add
        driver.get("https://automationexercise.com/#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        extentTest.info("Close popup add");
        wait(2);

        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        extentTest.info("Click test cases icon");
        wait(2);

        //5. Verify user is navigated to test cases page successfully
        WebElement testCasePage=  driver.findElement(By.xpath("//h5"));
        Assert.assertTrue(testCasePage.isDisplayed());
        extentTest.pass("Make assertion");

        extentTest.info("Close page");

    }
}
