package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utils {

   static public WebDriver driver;

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
    wait(3);

             driver.close();
    }

    public static void wait(int seconds)  {

        try {
            Thread.sleep(1000 *seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void creatAccount() {
        //open new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        wait(3);
        //Click on 'Signup / Login' button
        WebElement signUpButton = driver.findElement(By.xpath("//*[@class='fa fa-lock']"));
        signUpButton.click();
        //Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("John");
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("jd912@gmail.com");
        //Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //Fill details: Title, Name, Email, Password, Date of birth
        //title
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();
        //password
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("12345");
        wait(2);
        //page down
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        wait(3);;
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
        wait(2);;
        //Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        wait(1);
        //offers.click();
        wait(1);;
        //First name
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("John");
        wait(1);;
        //Last Name
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Doe");
        wait(1);;
        //Company
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Nex Technologie");
        wait(1);;
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
        //Click 'Create Account button'
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait(1);

        List<String> tumWindowList = new ArrayList<String>(driver.getWindowHandles());
        //Bütün açtığım pencerelerin handle değerlerini bir ArrayList'e atadık

        //techproeducation sayfasına geçiniz:
        wait(3);
        //driver.switchTo().window(techproWindowHandle);
        driver.switchTo().window(tumWindowList.get(0));// ilk açtığımız pencereye index ile geçebiliriz
    }


    public static void deleteAdd(){

        //    if there is a popup add, close ad
        driver.get("https://automationexercise.com/delete_account#google_vignette");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).build().perform();
        wait(2);


    }

}
