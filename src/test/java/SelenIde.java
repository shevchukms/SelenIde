
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SelenIde {

    @Test
    public void testSelenIde() throws Exception {
//        System.setProperty("webdriver.gecko.driver",
//                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver",
                "D:/Eclipse/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("selenium ide download" + Keys.ENTER);
        // driver.findElement(By.name("btnK")).click();
        //driver.findElement(By.id("_fZl")).click();
        driver.findElement(By.linkText("Downloads - Selenium")).click();
        Assert.assertEquals(
                "Selenium IDE is a Firefox plugin which records and plays back user interactions with the browser. Use this to either create simple scripts or assist in exploratory testing. It can also export Remote Control or WebDriver scripts, though they tend to be somewhat brittle and should be overhauled into some sort of Page Object-y structure for any kind of resiliency.",
                driver.findElement(By.cssSelector("a[name=\"selenium_ide\"] > p")).getText());
        driver.quit();
    }

}