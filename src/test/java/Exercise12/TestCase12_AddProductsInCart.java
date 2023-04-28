package Exercise12;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TestCase12_AddProductsInCart extends TestBase {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Products' button
//5. Hover over first product and click 'Add to cart'
//6. Click 'Continue Shopping' button
//7. Hover over second product and click 'Add to cart'
//8. Click 'View Cart' button
//9. Verify both products are added to Cart
//10. Verify their prices, quantity and total price


    @Test
    public void test12() {

        extentTest = extentReports.createTest("ExtentTest", "Test Report");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url:automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(homePage.isDisplayed());
        extentTest.pass("Assertion: Home page is visible successfully");

        //      if there is a popup add, close add
        driver.get("https://automationexercise.com/#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();
        extentTest.info("Close popup add");
        wait(2);

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        extentTest.info("Click on 'Products' button");
        wait(2);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        //5. Hover over first product and click 'Add to cart'
        WebElement firstProduct= driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[1]"));
        action.moveToElement(firstProduct).perform();
        extentTest.info("Hover over first product");
        wait(1);
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        extentTest.info("Click 'Add to cart'");

        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        extentTest.info("Click 'Continue Shopping' button");

        //7. Hover over second product and click 'Add to cart'
        WebElement secondProduct= driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[2]"));
        action.moveToElement(firstProduct).perform();
        extentTest.info("Hover over second product");
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]")).click();
        extentTest.info("Click 'Add to cart'");

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        extentTest.info("Click 'Add to cart'");

        //9. Verify both products are added to Cart
       List<WebElement> productList= driver.findElements(By.xpath("//tbody"));

        for (WebElement each : productList ) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.pass("Assertion: Verify both products are added to Cart");

        //10. Verify their prices, quantity and total price
        //first product
        WebElement firtProductActualPrice=  driver.findElement(By.xpath("//tbody//tr[1]//td[3]"));
        Assert.assertEquals("Rs. 500", firtProductActualPrice.getText());
        extentTest.pass("Assertion: Verify first product price");

        WebElement firtProducActualtQuantity=  driver.findElement(By.xpath("//tbody//tr[1]//td[4]"));
        Assert.assertEquals("1", firtProducActualtQuantity.getText());
        extentTest.pass("Assertion: Verify first product quantity");

        WebElement firtProductActualTotalPrice=  driver.findElement(By.xpath("//tbody//tr[1]//td[5]"));
        Assert.assertEquals("Rs. 500", firtProductActualTotalPrice.getText());
        extentTest.pass("Assertion: Verify first product tolal price");

        //second product
        WebElement secondProductActualPrice=  driver.findElement(By.xpath("//tbody//tr[2]//td[3]"));
        Assert.assertEquals("Rs. 400", secondProductActualPrice.getText());
        extentTest.pass("Assertion: Verify second product price");

        WebElement secondProducActualtQuantity=  driver.findElement(By.xpath("//tbody//tr[2]//td[4]"));
        Assert.assertEquals("1", secondProducActualtQuantity.getText());
        extentTest.pass("Assertion: Verify second product quantity");

        WebElement secondProductActualTotalPrice=  driver.findElement(By.xpath("//tbody//tr[2]//td[5]"));
        Assert.assertEquals("Rs. 400", secondProductActualTotalPrice.getText());
        extentTest.pass("Assertion: Verify second product tolal price");

        extentTest.info("Close page");
    }
}
