package Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    //TestBase class'ından Obje oluşturmanın önüne geçilmesi için abstract yapılabilir
    //Orn: TestBase base = new TestBase()
    //Bu class'a extends ettiğimiz test classlarından ulaşabiliriz
    protected static WebDriver driver;
    protected static ExtentReports extentReports; //raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//raporu hTML formatında düzenler
    protected static ExtentTest extentTest;// tüm test aşamalarında extentTest objesi ile bilgi eklelir
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //----------------------------------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Mustafa Dogan");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Report");
    }
    @After
    public void tearDown() throws Exception {
        extentReports.flush();
        wait(3);
         driver.quit();
   }
    //HARD WAIT METHOD
    public static void wait(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert ACCEPT
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    //Alert getText()
    public static String alertText(){
        String text=   driver.switchTo().alert().getText();
        return text;
    }
    //Alert promptBox
    public static void alertprompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");
        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    //DropDown Index
    public static void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public static void ddmValue(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }
    public static void switchToWindow(int sayi){
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(sayi));
    }



    //SwitchToWindow2
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }

    //EXPLİCİT WAİT METHODS

    //Visible wait
    public static void visibleWait(WebElement element,int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Explicit Wait
    public static void visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //alert wait
    public static void alertWait(WebElement element,int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //screen shot methodu

    public static void tumSayfaScreenShot(){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyy").format(new Date());
        String dosyaYolu = "testOutPut/screenshot"+tarih+".png";

        TakesScreenshot ts = (TakesScreenshot) driver;


        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //WEBELEMENT SCREEN SHOT
    public static void webElementResmi(WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenshot"+tarih+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //EXTENDS REPORT BEFORDAN ÇIKARIRSAN BU KODU KULLAN. BU DURUMDA FLUSH'U KULLANMAYI UNUTMA!!!
    public static void extentReport(){
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Mustafa Dogan");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
    }



    public static void printData(int satir, int sutun){
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());

    }


}