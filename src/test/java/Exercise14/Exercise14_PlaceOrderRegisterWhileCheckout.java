package Exercise14;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Exercise14_PlaceOrderRegisterWhileCheckout extends TestBase {


    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully


    @Test
    public void test14() {
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

        //4. Add products to cart
       driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();
       wait(2);
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("(//*[text()='Add to cart'])[3]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        wait(2);

        driver.findElement(By.xpath("(//*[text()='Add to cart'])[5]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        wait(2);
        extentTest.info("Add products to cart");

        //5. Click 'Cart' button
        driver.findElement(By.xpath("(//li)[3]")).click();
        extentTest.info("Click 'Cart' button");
        wait(2);

        //6. Verify that cart page is displayed
        WebElement chartPage= driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(chartPage.isDisplayed());
        extentTest.pass("Assertion = Verify that cart page is displayed");

        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        extentTest.info("Click Proceed To Checkout");
        wait(2);

        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("(//*[@class='text-center'])[2]")).click();
        extentTest.info("Click 'Register / Login' button");

        //9. Fill all details in Signup and create account

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Alice", Keys.TAB,"alice@gmail.com", Keys.ENTER);

        //Fill details: Title, Name, Email, Password, Date of birth
        //title
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();
        //password
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("12345");
        wait(2);

        //page down

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        wait(2);
        //Date of birth
        //Day
        WebElement day = driver.findElement(By.cssSelector("select[id='days']"));
        Select selectDay = new Select(day);
        selectDay.selectByValue("22");

        //Month
        WebElement month = driver.findElement(By.cssSelector("select[id='months']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("5");

        //Year
        WebElement year = driver.findElement(By.cssSelector("select[id='years']"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1981");
        // Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[text()='Sign up for our newsletter!']")).click();
        wait(2);
        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        wait(1);
        //First name
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Ali");
        wait(1);
        //Last Name
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Gel");
        wait(1);
        //Company
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Nex Technologie");
        wait(1);
        //Address
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Stein Street 77, 47799,Ottava");
        wait(1);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Toronto, Canada");
        wait(1);
        //Country
        WebElement country = driver.findElement(By.cssSelector("select[id='country']"));
        wait(1);
        Select selectCountry = new Select(country);
        selectCountry.selectByIndex(2);
        //state
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Toronto");
        wait(1);
        //City
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Toronto");
        wait(1);
        //Zipcode
        driver.findElement(By.cssSelector("input[id='zipcode']")).sendKeys("1457");
        wait(1);
        //Mobile number
        driver.findElement(By.cssSelector("input[id='mobile_number']")).sendKeys("14572124");
        wait(1);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait(1);
        extentTest.info("//Fill all details in Signup and create account");

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated=  driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
        extentTest.pass("Verify 'ACCOUNT CREATED!'");

        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        extentTest.info("click 'Continue' button ");


        //      if there is a popup add, close add

        driver.navigate().refresh();
//
//        driver.get("https://automationexercise.com/account_created#google_vignette");
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.ESCAPE).build().perform();
//        extentTest.info("Close popup add");
//        wait(2);

        //11. Verify ' Logged in as username' at top
        WebElement loggedText = driver.findElement(By.xpath("(//a)[11]"));
        String StrLoggedText = loggedText.getText();
        String expectedText = "Logged in as Alice";
        Assert.assertTrue(loggedText.isDisplayed());


        //12.Click 'Cart' button

        driver.findElement(By.xpath("(//li)[3]")).click();
        extentTest.info("Click 'Cart' button");
        wait(2);


        //13. Click 'Proceed To Checkout' button

        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
        extentTest.info("Click Proceed To Checkout");
        wait(2);

        //14. Verify Address Details and Review Your Order
        WebElement addressDetails= driver.findElement(By.xpath("(//*[@class='heading'])[1]"));
        Assert.assertTrue(addressDetails.isDisplayed());
        extentTest.pass("Assertion: Verify Address Details");

        WebElement reviewOrder= driver.findElement(By.xpath("(//*[@class='heading'])[2]"));
        Assert.assertTrue(reviewOrder.isDisplayed());
        extentTest.pass("Assertion : Verify Review Your Order");

        //15. Enter description in comment text area and click 'Place Order'

        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("Hallo world");
        extentTest.info("Enter description in comment text area");

       driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();
       extentTest.info("click 'Place Order'");

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date



        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button




    }
}
