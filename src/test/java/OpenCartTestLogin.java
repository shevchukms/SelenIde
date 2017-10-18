import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OpenCartTestLogin {
    private static final String EMAIL = "lv_269_test@ukr.net";
    private static final String  PASSWORD="269lv269lv";

    @Test
    public void testOpenCartLogInBySubmitMozilla() throws InterruptedException {


        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

//        System.setProperty("webdriver.chrome.driver",
//                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.get("http://lv-269new.freecluster.eu/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.partialLinkText("Login")).click();

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("password")).submit();


        driver.findElement(By.linkText("Edit Account")).click();
        Assert.assertEquals(EMAIL, driver.findElement(By.name("email")).getAttribute("value"));

        driver.findElement(By.partialLinkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();

        driver.quit();

    }

    @Test
    public void testOpenCartLogInBySubmitChrome() throws InterruptedException {


//                System.setProperty("webdriver.gecko.driver",
//                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver",
                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://lv-269new.freecluster.eu/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.partialLinkText("Login")).click();

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("password")).submit();


        driver.findElement(By.linkText("Edit Account")).click();
        Assert.assertEquals(EMAIL, driver.findElement(By.name("email")).getAttribute("value"));

        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Logout")).click();

        driver.quit();

    }



    @Test
    public void testOpenCartLogInByButtonMozilla() throws InterruptedException {


        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

//        System.setProperty("webdriver.chrome.driver",
//                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver.get("http://lv-269new.freecluster.eu/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
       //// driver.findElement(By.name("password")).
      //  submit();
        //driver.findElement(By.name("Login")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();


        driver.findElement(By.linkText("Edit Account")).click();
        Assert.assertEquals(EMAIL, driver.findElement(By.name("email")).getAttribute("value"));

        driver.findElement(By.partialLinkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();

        driver.quit();

    }

    @Test
    public void testOpenCartLogInByButtonChromr() throws InterruptedException {


//                System.setProperty("webdriver.gecko.driver",
//                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver",
                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://lv-269new.freecluster.eu/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();


        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        ///driver.findElement(By.name("password")).
       // submit();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();


        driver.findElement(By.linkText("Edit Account")).click();
        Assert.assertEquals(EMAIL, driver.findElement(By.name("email")).getAttribute("value"));

        driver.findElement(By.partialLinkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();

        driver.quit();

    }

}
