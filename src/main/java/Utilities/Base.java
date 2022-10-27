package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Base {

    public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream fp;

    public Base() throws IOException {
        prop = new Properties();
        fp = new FileInputStream(System.getProperty("user.dir")+"./src/main/java/Utilities/config.properties");
        prop.load(fp);
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
