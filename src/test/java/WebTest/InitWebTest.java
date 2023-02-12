package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InitWebTest {
    ChromeDriver driver;
    WebDriverWait webDriverWait;

    String getURL = "https://test-stand.gb.ru/login";
    String loginAutotest = "GB202302d8ec18";
    String passwordAutotest = "0b014008cc";


    public String getGetURL() {
        return getURL;
    }

    @BeforeAll
    static void  webdriwerInit(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void eachInit(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions
                .addArguments("--disable-notifications").addArguments("--disable-popup-blocking")
                .addArguments("test-type")
                .addArguments("incognito");
        driver = new ChromeDriver(chromeOptions) ;

        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterEach
    void killProcess(){
        driver.quit();
    }

    public String getLoginAutotest() {
        return loginAutotest;
    }

    public String getPasswordAutotest() {
        return passwordAutotest;
    }
}
