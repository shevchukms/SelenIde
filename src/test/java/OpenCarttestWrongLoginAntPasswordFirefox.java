import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class OpenCarttestWrongLoginAntPasswordFirefox {

    private static final String EMAIL = "lv_269_test@ukr.net";
    private static final String WRONGEMAIL = "wrongemail@ukr.net";
    private static final String PASSWORD = "269lv269lv";
    private static WebDriver driver;
    private static Connection connection = null;

    public void connectToDB() throws SQLException {
        String jdbcUrl = "jdbc:mysql://77.120.103.50:3310/pekelis_db";
        String user = "pekelis_usr";
        String password = "B6y0N7i5";
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

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


    @After
    public void deleteFromDatabase() {

        driver.quit();
    }


    @Test
    public void wrongLoginMozilla() {

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

    }


    @Test
    public void wrongPasswordMozilla() {

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


    }


}
