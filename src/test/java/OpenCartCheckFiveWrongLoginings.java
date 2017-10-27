import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class OpenCartCheckFiveWrongLoginings {


    private static final String EMAIL = "gqeuwergik20062@ukr.net";
    private static final String PASSWORD = "269lv269lv";
    private static final String WRONGPASSWORD = "1111111111";
    private static WebDriver driver;
    private static Connection connection = null;



    @BeforeClass
    public static void runBrowser() {

        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @AfterClass
    public static void closeWebDriver() {
        driver.quit();
    }






    @Test
    public void testWrongPassWords(){

        for (int i = 0; i < 5; i++) {
            driver.get("http://server7.pp.ua/");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(By.partialLinkText("My Account")).click();

            driver.findElement(By.linkText("Login")).click();


            driver.findElement(By.name("email")).clear();
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).sendKeys(EMAIL);
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys(WRONGPASSWORD);

            driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",
                    driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());
        }
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(WRONGPASSWORD);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());


    }





}
