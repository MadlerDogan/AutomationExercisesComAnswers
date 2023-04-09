package Exercise06;

import Utilities.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class New extends Utils {

    @Test
    public void name() throws InterruptedException {
        // "http://automationexercise.com" sitesine git
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homepage=driver.findElement(By.xpath("//html"));
        //WebElement hmp= driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homepage.isDisplayed());
        Thread.sleep(3000);
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
        Thread.sleep(4000);
        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch=driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());
        Thread.sleep(3000);
//    //6. Enter name, email, subject and message
        List<WebElement> elements=driver.findElements(By.xpath("//*[@class='form-control']"));
//        String []str= {"user", "user@gmail.com","konu", "selam"};
//        for (int i = 0; i <= elements.size(); i++) {
//            elements.get(i).sendKeys(str[i]);
//        }
        //2 .yol
    elements.get(0).sendKeys("user");
    elements.get(1).sendKeys("user@gmail.com");
    elements.get(2).sendKeys("konu");
    elements.get(3).sendKeys("selam");
        Thread.sleep(3000);
        //3.yol
//    driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("user");
//    driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("user@gmail.com");
//    driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("konu");
//    driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("selam");
//
//    //7. Upload file
        elements.get(4).click();
        elements.get(4).sendKeys("C:\\Users\\HakanBatirhan\\Desktop\\hhhh.txt");
        WebElement upload= driver.findElement(By.xpath("//input[@name='upload_file']"));
        upload.sendKeys("C:\\Users\\HakanBatirhan\\Desktop\\text.txt");

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='submit-button']")).submit();
        //9. Click OK button
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement message=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(message.isDisplayed());
//11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']")).click();
        WebElement homepageEnd=driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homepageEnd.isDisplayed());
    }
}
