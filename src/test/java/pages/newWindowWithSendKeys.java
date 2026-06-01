package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class newWindowWithSendKeys {

    WebDriver webDriver;


    @BeforeEach
    void setUp(){
        webDriver = new FirefoxDriver();
    }


   /* @AfterEach
    void quitAfterEach(){
        if(webDriver != null){
            webDriver.quit();
        }
    }*/



    @Test
    void newWindow() throws InterruptedException{
        webDriver.get("https://the-internet.herokuapp.com/windows");

        // switchTo() brauchst du wenn Selenium den Fokus auf einen anderen Kontext wechseln soll. Es gibt drei häufige Anwendungsfälle:
        webDriver.switchTo().newWindow(WindowType.WINDOW); // öffnet ein neues Fenster

        // Nachdem das Fenster geöffnet wurde, gibt Selenium diese URL im gleichen Fenster ein.
        webDriver.get("https://the-internet.herokuapp.com/typos");
        Assertions.assertEquals(2, webDriver.getWindowHandles().toArray().length);




    }
}




