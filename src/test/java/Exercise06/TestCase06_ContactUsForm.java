package Exercise06;

import Utilities.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;

public class TestCase06_ContactUsForm extends Utils {

/*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
 */

    @Test
    public void test06() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        String mainWindowHandle = driver.getWindowHandle();
//        3. Verify that home page is visible successfully
        WebElement mainPage = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(mainPage.isDisplayed());

//        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
//        5. Verify 'GET IN TOUCH' is visible//
        WebElement getInTouch = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
        wait(5);

//        6. Enter name, email, subject and message
        //name
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        //email
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("jd912@gmail.com");
        //subject
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Thanks for this internet site");
        //message
        driver.findElement(By.xpath("//textarea[@placeholder='Your Message Here']")).sendKeys("Thanks for a good designed internet site");


//        7. Upload file

//        WebElement buton = driver.findElement(By.xpath("(//*[@class='form-group col-md-12'])[3]"));
//        buton.click();
        //  buton.sendKeys("C:\\Users\\dogan\\Desktop\\SeleniumTest.txt");

        WebElement upload = driver.findElement(By.xpath("//input[@name='upload_file']"));
        upload.sendKeys("C:\\Users\\dogan\\Desktop\\SeleniumTest.txt");
        wait(2);
        //        8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        wait(3);
//        9. Click OK button
        driver.switchTo().alert().accept();
//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement messageVerify = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(messageVerify.isDisplayed());

        //    if there is a popup add, close ad
        driver.get("https://automationexercise.com/contact_us#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        wait(2);
//        11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();

        WebElement mainPage2 = driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(mainPage2.isDisplayed());

    }
}
