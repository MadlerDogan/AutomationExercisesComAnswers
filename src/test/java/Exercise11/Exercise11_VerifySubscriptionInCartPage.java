package Exercise11;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Exercise11_VerifySubscriptionInCartPage extends TestBase {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Cart' button
//5. Scroll down to footer
//6. Verify text 'SUBSCRIPTION'
//7. Enter email address in input and click arrow button
//8. Verify success message 'You have been successfully subscribed!' is visible


    @Test
    public void test11() {

        extentTest = extentReports.createTest("ExtentTest", "Test Report");
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url:automationexercise.com");
//3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(homePage.isDisplayed());
        extentTest.pass("Assertion: Home page is visible successfully");
//4. Click 'Cart' button
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();
        extentTest.info("Click 'Cart' button");
//5. Scroll down to footer
        Actions action = new Actions(driver);
        action.sendKeys(Keys.END);
        extentTest.info("Scroll down to footer");
//6. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        wait(1);
        extentTest.pass("Assertion: Verify text 'SUBSCRIPTION'");
//7. Enter email address in input and click arrow button
        Faker fake = new Faker();
        String email = fake.internet().emailAddress();
        WebElement eMailbox = driver.findElement(By.xpath("//input[@id='susbscribe_email']"));
        eMailbox.sendKeys(email);
        wait(1);
        driver.findElement(By.xpath("//i[@class='fa fa-arrow-circle-o-right']")).click();
        extentTest.info("Enter email address in input and click arrow button");
        wait(1);

//8. Verify success message 'You have been successfully subscribed!' is visible
        WebElement message = driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']"));

        Assert.assertTrue(message.isDisplayed());

        extentTest.pass("//8. Verify success message 'You have been successfully subscribed!' is visible");
        extentTest.info("Close page");
    }
}
