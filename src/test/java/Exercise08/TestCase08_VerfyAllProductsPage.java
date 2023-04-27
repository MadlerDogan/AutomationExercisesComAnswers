package Exercise08;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestCase08_VerfyAllProductsPage extends TestBase {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Products' button
//5. Verify user is navigated to ALL PRODUCTS page successfully
//6. The products list is visible
//7. Click on 'View Product' of first product
//8. User is landed to product detail page
//9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

    @Test
    public void test01() {
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        extentTest.info("Navigate to url:automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement mainPage= driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(mainPage.isDisplayed());
        extentTest.pass("Make assertion");


        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        extentTest.info("Clik on products ikon");
        wait(1);
        //      if there is a popup add, close add
        driver.get("https://automationexercise.com/#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        extentTest.info("Close popup add");
        wait(2);

        Actions actions = new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait(1);

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage= driver.findElement(By.xpath("//a[@style ='color: orange;']"));
        Assert.assertTrue(productPage.isDisplayed());
        extentTest.pass("Verifying product page is displayed");

        //6. The products list is visible

        WebElement productList= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productList.isDisplayed());
        extentTest.pass("Verifying productlist is displayed");
        wait(2);
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
        extentTest.info("Clik on first product");

        //8. User is landed to product detail page
        //9. Verify that detail is visible: product name, category, price, availability, condition, brand
        //product name
        WebElement productName= driver.findElement(By.xpath("//h2[text()='Blue Top']"));
        Assert.assertTrue(productName.isDisplayed());
        extentTest.pass("Assertion: Product name is displayed");

        //category
        WebElement category= driver.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        extentTest.pass("Assertion: Category is displayed");

        //price
        WebElement price= driver.findElement(By.xpath("//span[text()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        extentTest.pass("Assertion: Price is displayed");

        //availability
        WebElement availability= driver.findElement(By.xpath("//*[text()='Availability:']"));
        Assert.assertTrue(availability.isDisplayed());
        extentTest.pass("Assertion: Availability is displayed");

        //condition
        WebElement condition= driver.findElement(By.xpath("//*[text()='Condition:']"));
        Assert.assertTrue(condition.isDisplayed());
        extentTest.pass("Assertion: Condition is displayed");

        //Brand
        WebElement brand= driver.findElement(By.xpath("//*[text()='Brand:']"));
        Assert.assertTrue(brand.isDisplayed());
        extentTest.pass("Assertion: Brand is displayed");
        extentTest.info("Close page");
    }


}
