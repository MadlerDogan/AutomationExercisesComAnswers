package Exercise03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A03 {


    WebDriver driver;
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }


    @Test
    public void test03() {
        //3. Verify that home page is visible successfully
        WebElement mainPage = driver.findElement(By.xpath("(//html)[1]"));
        Assert.assertTrue(mainPage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginTYAcc= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginTYAcc.isDisplayed());
        //6. Enter incorrect email address and password
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("random@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("12345");
        //  7. Click 'login' button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        // 8. Verify error 'Your email or password is incorrect!' is visible
        WebElement message= driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(message.isDisplayed());

    }
}
