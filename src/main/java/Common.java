import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Common {

    public static WebDriver driver;
    private static String baseURL;


    public  void setUP(){
        System.setProperty("webdriver.chrome.driver", Util.CHROM_PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        baseURL=Util.BASE_URL;
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);

    }

    public void startBrowser() {

        driver.get(baseURL+"/V4/");
        driver.manage().window().maximize();

    }
    public void scroll(){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,800)");

    }
    public void closeBrowser(){
        driver.quit();
    }

    public static void login(String username, String password ) {

        driver.findElement(By.name("uid")).clear();
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
    }


    public static void logout(){
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
    }

}