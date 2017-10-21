import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OpenCarttestWrongLoginAntPassword {

    private static final String EMAIL = "lv_269_test@ukr.net";
    private static final String WRONGEMAIL = "wrongemail@ukr.net";
    private static final String PASSWORD = "269lv269lv";

    @Test
    public void failOfLoginMozilla() {

        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();


        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(WRONGEMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());


        driver.quit();

    }

    @Test
    public void failOfLoginChrome() {

        System.setProperty("webdriver.chrome.driver",
                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();


        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(WRONGEMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());


        driver.quit();
    }

    @Test
    public void wrongPasswordMozilla() {
        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();


        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(WRONGEMAIL);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());


        driver.quit();
    }

    @Test
    public void wrongPasswordChrome() {
        System.setProperty("webdriver.chrome.driver",
                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();


        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(WRONGEMAIL);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());


        driver.quit();
    }

}
