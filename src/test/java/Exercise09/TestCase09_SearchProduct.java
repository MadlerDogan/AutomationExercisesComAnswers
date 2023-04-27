package Exercise09;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TestCase09_SearchProduct extends TestBase {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Products' button
//5. Verify user is navigated to ALL PRODUCTS page successfully
//6. Enter product name in search input and click search button
//7. Verify 'SEARCHED PRODUCTS' is visible
//8. Verify all the products related to search are visible

    @Test
    public void test09() {
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
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

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        extentTest.info("Click on 'Products' button");
        wait(2);

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage= driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(productPage.isDisplayed());
        extentTest.pass("Assertion: user is navigated to ALL PRODUCTS page successfully");

        //6. Enter product name in search input and click search button
        WebElement seachBox =driver.findElement(By.id("search_product"));
        seachBox.sendKeys("Tshirt");
        driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
        extentTest.info("Enter product name in search input and click search button");

        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProduct= driver.findElement(By.xpath("(//*[text()='Men Tshirt'])[1]"));
        Assert.assertTrue(searchedProduct.isDisplayed());
        extentTest.pass("Assertion: 'SEARCHED PRODUCTS' is visible");

        //8. Verify all the products related to search are visible
        List<WebElement> relatedProducts = driver.findElements(By.xpath("//*[@class='productinfo text-center']/p"));
        for (WebElement w:relatedProducts) {
            Assert.assertTrue(w.isDisplayed());
        }
        //relatedProducts.stream().forEach(WebElement::isDisplayed);
        extentTest.pass("Assertion: all the products related to search are visible");
        extentTest.info("Close page");
    }
}
