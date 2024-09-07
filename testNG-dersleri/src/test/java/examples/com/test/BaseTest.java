package examples.com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {

    //Base test sayesinde her yerde kullanılcak olan kod tekrarından kaçınılması sağlanılır
    //Base testin içinde tnaımlayacağım softAssert testin yanlış olduğunda bile devam etmesini diğer testleride test etmesini sağlar
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        softAssert=new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        softAssert.assertAll();
    }

}
