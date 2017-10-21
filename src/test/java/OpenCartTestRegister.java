import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class OpenCartTestRegister {

    private static Connection connection = null;
    private static final String FIRSTNAME = "TEST_FIRSTNAME";
    private static final String LASTNAME = "TEST_LASTNAME";
    private static final String EMAIL = "test_test@mail.com";
    private static final String TELEPHONE = "380511223344";
    private static final String ADDRESS = "TEST_ADDRESS";
    private static final String CITY = "LVIV";
    private static final String POSTCODE = "79000";
    private static final String PASSWORD = "269LV269LV";
    private static final String CONFIRM = "269LV269LV";


    public void connectToDB() throws SQLException {
        String jdbcUrl = "jdbc:mysql://77.120.103.50:3310/pekelis_db";
        String user = "pekelis_usr";
        String password = "B6y0N7i5";
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

    @After
    public void deleteFromDatabase() throws SQLException {
        connectToDB();
        String query1 = "DELETE FROM oc_customer WHERE firstname=? and lastname=?   and email=?  and telephone=?  ;";
        PreparedStatement pst1 = connection.prepareStatement(query1);
        pst1.setString(1, FIRSTNAME);
        pst1.setString(2, LASTNAME);
        pst1.setString(3, EMAIL);
        pst1.setString(4, TELEPHONE);
        pst1.executeUpdate();
        // connection.commit();
        connection.close();
    }

    @Test
    public void testOpenCartLogInBySubmitMozilla() throws InterruptedException, SQLException {
        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.partialLinkText("Register")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);

        driver.findElement(By.name("telephone")).clear();
        driver.findElement(By.name("telephone")).click();
        driver.findElement(By.name("telephone")).sendKeys(TELEPHONE);

        driver.findElement(By.name("address_1")).clear();
        driver.findElement(By.name("address_1")).click();
        driver.findElement(By.name("address_1")).sendKeys(ADDRESS);

        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).sendKeys(CITY);

        driver.findElement(By.name("postcode")).clear();
        driver.findElement(By.name("postcode")).click();
        driver.findElement(By.name("postcode")).sendKeys(POSTCODE);

        //driver.findElement(By.name("country_id")).clear();
        driver.findElement(By.name("country_id")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"input-country\"]/option[237]")).click();
        //driver.findElement(By.linkText("Ukraine")).click();

        // driver.findElement(By.name("zone_id")).clear();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#input-zone")).click();
        //Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"input-zone\"]/option[15]")).click();
        //   driver.findElement(By.partialLinkText("L'vivs'ka Oblast'")).click();


        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).click();
        driver.findElement(By.name("confirm")).sendKeys(CONFIRM);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
        String actualtext = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualtext, "Your Account Has Been Created!");

        driver.quit();

        //    deleteFromDatabase();

    }

    @Test
    public void testOpenCartLogInBySubmitChrome() throws SQLException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.partialLinkText("Register")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);

        driver.findElement(By.name("telephone")).clear();
        driver.findElement(By.name("telephone")).click();
        driver.findElement(By.name("telephone")).sendKeys(TELEPHONE);

        driver.findElement(By.name("address_1")).clear();
        driver.findElement(By.name("address_1")).click();
        driver.findElement(By.name("address_1")).sendKeys(ADDRESS);

        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).sendKeys(CITY);

        driver.findElement(By.name("postcode")).clear();
        driver.findElement(By.name("postcode")).click();
        driver.findElement(By.name("postcode")).sendKeys(POSTCODE);

        //driver.findElement(By.name("country_id")).clear();
        driver.findElement(By.name("country_id")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"input-country\"]/option[237]")).click();
        //driver.findElement(By.linkText("Ukraine")).click();

        // driver.findElement(By.name("zone_id")).clear();
        driver.findElement(By.cssSelector("#input-zone")).click();
        // ! ! !  Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"input-zone\"]/option[15]")));


        driver.findElement(By.xpath("//*[@id=\"input-zone\"]/option[15]")).click();
        //   driver.findElement(By.partialLinkText("L'vivs'ka Oblast'")).click();


        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).click();
        driver.findElement(By.name("confirm")).sendKeys(CONFIRM);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

        ///    //*[@id="content"]/h1

        String actualtext = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualtext, "Your Account Has Been Created!");

///   "Your Account Has Been Created!"

        driver.quit();
    }
}
