package Exercise05;

import Utilities.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase05_RegisterUserWithExistEmail extends Utils {
    @Test
    public void name() {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

      driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
    WebElement mainPage =driver.findElement(By.xpath("//a[@style='color: orange;']"));
    Assert.assertTrue(mainPage.isDisplayed());
//4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

//5. Verify 'New User Signup!' is visible
    WebElement signUpText=driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
    Assert.assertTrue(signUpText.isDisplayed());

//6. Enter name and already registered email address
        //to create already registered account
    //    creatAccount();//username =John, Email address =jd912@gmail.com

    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("John");
    driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("jd912@gmail.com");

//7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

  //8. Verify error 'Email Address already exist!' is visible
    WebElement existMessage=driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
    Assert.assertTrue(existMessage.isDisplayed());

    }

}
