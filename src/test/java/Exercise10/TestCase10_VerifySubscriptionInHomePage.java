package Exercise10;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase10_VerifySubscriptionInHomePage extends TestBase {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Scroll down to footer
//5. Verify text 'SUBSCRIPTION'
//6. Enter email address in input and click arrow button
//7. Verify success message 'You have been successfully subscribed!' is visible


    @Test
    public void test10() {
        extentTest=extentReports.createTest("ExtentTest","Test Report");
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url:automationexercise.com");
        wait(1);

        //3. Verify that home page is visible successfully
        WebElement mainPage= driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(mainPage.isDisplayed());
        extentTest.pass("Assertion: Home page is visible successfully");
        wait(2);

        //      if there is a popup add, close add
        driver.get("https://automationexercise.com/#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        extentTest.info("Close popup add");
        wait(2);

        //4. Scroll down to footer
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.END);
        extentTest.info("Scroll down to footer");
        wait(2);

        //5. Verify text 'SUBSCRIPTION'
        WebElement subscribe=  driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subscribe.isDisplayed());
        extentTest.pass("Assertion: Verify text 'SUBSCRIPTION");
        wait(2);

        //6. Enter email address in input and click arrow button
        Faker faker = new Faker();
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress());
        wait(1);
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        extentTest.info("Enter email address in input and click arrow button");

        //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message= driver.findElement(By.xpath("//div[text()='You have been successfully subscribed!']"));
        Assert.assertTrue(message.isDisplayed());
        extentTest.pass("Assertion: 'You have been successfully subscribed!' is visible");
        extentTest.info("Close page");

    }
}
