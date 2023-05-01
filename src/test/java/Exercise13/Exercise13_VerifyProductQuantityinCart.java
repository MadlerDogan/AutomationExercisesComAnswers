package Exercise13;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Exercise13_VerifyProductQuantityinCart extends TestBase {


//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
//        4. Click 'View Product' for any product on home page
//        5. Verify product detail is opened
//        6. Increase quantity to 4
//        7. Click 'Add to cart' button
//        8. Click 'View Cart' button
//        9. Verify that product is displayed in cart page with exact quantity


    @Test
    public void test13() {
        extentTest = extentReports.createTest("ExtentTest", "Test Report");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url:automationexercise.com");
        wait(2);

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(homePage.isDisplayed());
        extentTest.pass("Assertion: Home page is visible successfully");
        wait(2);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Page is downed");
        wait(1);

        //4. Click 'View Product' for any product on home page
        WebElement viewProductButton = driver.findElement(By.xpath("(//*[@class='nav nav-pills nav-justified'])[1]"));
        viewProductButton.click();
        wait(2);

        //      if there is a popup add, close add
        driver.get("https://automationexercise.com/#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        extentTest.info("Close popup add");
        wait(2);

        driver.findElement(By.xpath("(//*[@class='nav nav-pills nav-justified'])[1]")).click();
        extentTest.info("Click 'View Product' for any product on home page");
        wait(2);


        //5. Verify product detail is opened

        WebElement productDetail = driver.findElement(By.xpath("//*[text()=' In Stock']"));
        Assert.assertTrue(productDetail.isDisplayed());
        extentTest.pass("Verify product detail is opened");

        //6. Increase quantity to 4
        driver.findElement(By.id("quantity")).clear();
        wait(1);
        driver.findElement(By.id("quantity")).sendKeys("4");
        extentTest.info("Increase quantity to 4");

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();
        extentTest.info("Click 'Add to cart' button");

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        extentTest.info("Click 'Add to cart' button");

        //9. Verify that product is displayed in cart page with exact quantity
        String chartPage = driver.findElement(By.xpath("//button[text()='4']")).getText();
        Assert.assertEquals(chartPage, "4");
        extentTest.pass("Verify that product is displayed in cart page with exact quantity");
    }
}
