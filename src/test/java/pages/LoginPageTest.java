package pages;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class LoginPageTest extends BaseTest {


     LoginPage loginPage;

     @BeforeEach
     void setUp(){
          // JUnit 5 führt das @BeforeEach der Elternklasse zuerst aus,
          // danach das der Kindklasse. Das bedeutet der Driver ist bereits bereit wenn loginPage initialisiert wird
          loginPage = new LoginPage(driver);
     }

     @Test
     void loginAttempt() throws InterruptedException {

          // ARRANGE - Vorbereitung der Testdaten
          loginPage.setUsername("tomsmith");
          loginPage.setPassword("SuperSecretPassword!");

          // ACT Aktion die gesetz wird
          loginPage.pressButton();


          // ASSERT Überprüfung des Ergebnisses
          Assertions.assertTrue(driver.getCurrentUrl().contains("secure"));
     }


}
