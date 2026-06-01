package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class BaseTest {


    protected WebDriver driver;

    @BeforeEach
    void initDriver(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().fullscreen();

    }

    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }






}
