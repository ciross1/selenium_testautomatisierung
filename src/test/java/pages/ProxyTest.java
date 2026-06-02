package pages;

import base.BaseTest;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/*Dieser Code wird benutzt, um vor jedem Selenium-Test den Browser vorzubereiten.
Konkret wird er in zwei Situationen gebraucht:
Beim Testen von Webseiten, die viele externe Skripte laden, zum Beispiel:

Nachrichtenportale
Online-Shops
Seiten mit Login, die Analytics oder Chat-Widgets eingebunden haben

Ein praktisches Beispiel: Du testest einen Login auf einer Webseite. Ohne den Proxy wartet der Browser
vielleicht 10 Sekunden auf Google Analytics. Mit dem Proxy lädt nur das Login-Formular und der Test ist in 2 Sekunden fertig.*/

public class ProxyTest extends BaseTest {



    // Proxy starten:
    @BeforeEach
    public void setUp(){

         BrowserMobProxy proxy;

/*Startet einen lokalen Proxy-Server. Der Port 0 bedeutet, dass automatisch ein freier Port gewählt wird.*/
        proxy = new BrowserMobProxyServer();
        proxy.start(0); // Port 0 = automatisch einen freien Port wählen


        // Drittanbieter blockieren
        // Wenn der Browser eine Anfrage an diese Adressen schickt, blockiere sie und antworte mit 204 (leer)
        proxy.blacklistRequests(".*google-analytics.*", 204);
        proxy.blacklistRequests(".*facebook\\.net.*", 204);
        proxy.blacklistRequests(".*hotjar.*", 204);


        // Proxy mit Chrome verbinden
        Proxy seleniumProxy= ClientUtil.createSeleniumProxy(proxy);
        ChromeOptions options = new ChromeOptions();
        options.setProxy(seleniumProxy);
        options.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));


    }





}
