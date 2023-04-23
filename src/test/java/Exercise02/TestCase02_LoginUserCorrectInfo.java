package Exercise02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase02_LoginUserCorrectInfo {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void test02() throws InterruptedException {
        //    2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement mainManuLogo = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(mainManuLogo.isDisplayed());

        //4. Click on 'Signup / Login' button

        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginText.isDisplayed());
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("a912@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
        Thread.sleep(2000);
        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedText = driver.findElement(By.xpath("(//a)[11]"));
        String StrLoggedText = loggedText.getText();
        String expectedText = "Logged in as Ali";
        Assert.assertTrue(StrLoggedText.contains(expectedText));
        Assert.assertTrue(loggedText.isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        Thread.sleep(10000);


        //    if there is a popup add, close ad
        driver.get("https://automationexercise.com/delete_account#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        Thread.sleep(2000);

        //  10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deletedTex = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(deletedTex.isDisplayed());



    }


}
