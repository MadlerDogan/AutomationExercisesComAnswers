import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class CreatAccount {


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
        public void creatAccountTest() throws InterruptedException {
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("i[class='fa fa-home']"));
        Assert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement signUpButton = driver.findElement(By.xpath("//*[@class='fa fa-lock']"));
        signUpButton.click();
        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignUp.isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ali");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("a912@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement entAccInf = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(entAccInf.isDisplayed());
        // 9. Fill details: Title, Name, Email, Password, Date of birth
        //title
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();
        //password
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("12345");
        Thread.sleep(2000);

        //page down
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

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

        // 10. Select checkbox 'Sign up for our newsletter!'

        driver.findElement(By.xpath("//*[text()='Sign up for our newsletter!']")).click();
        Thread.sleep(2000);

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        //WebElement offers=driver.findElement(By.xpath("//*[text()='Receive special offers from our partners!']"));
        Thread.sleep(1000);
        //offers.click();
        Thread.sleep(1000);
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //First name
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Ali");
        Thread.sleep(1000);
        //Last Name
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Gel");
        Thread.sleep(1000);
        //Company
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Nex Technologie");
        Thread.sleep(1000);
        //Address
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Stein Street 77, 47799,Ottava");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Toronto, Canada");
        Thread.sleep(1000);
        //Country
        WebElement country = driver.findElement(By.cssSelector("select[id='country']"));
        Thread.sleep(1000);
        Select selectCountry = new Select(country);
        selectCountry.selectByIndex(2);
        //state
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Toronto");
        Thread.sleep(1000);
        //City
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Toronto");
        Thread.sleep(1000);
        //Zipcode
        driver.findElement(By.cssSelector("input[id='zipcode']")).sendKeys("1457");
        Thread.sleep(1000);
        //Mobile number
        driver.findElement(By.cssSelector("input[id='mobile_number']")).sendKeys("14572124");
        Thread.sleep(1000);

        //   13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
    }


}
