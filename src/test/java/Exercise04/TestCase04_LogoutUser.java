package Exercise04;

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

public class TestCase04_LogoutUser {
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
       // driver.close();
    }

    @Test
    public void test03() {
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("(//html)[1]"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
         //   5. Verify 'Login to your account' is visible
         WebElement loginText=  driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginText.isDisplayed());

        // 6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[1]")).sendKeys("a912@gmail.com");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("12345");
       // 7. Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement username= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        String actualText = username.getText();
        String expectedText = "Logged in as Ali";
        Assert.assertTrue(actualText.equals(expectedText));

        //9. Click 'Logout' button
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();

        //10. Verify that user is navigated to login page
        WebElement mainPageLast= driver.findElement(By.xpath("//a[@style='color: orange;']"));
        Assert.assertTrue(mainPageLast.isDisplayed());








    }


}
