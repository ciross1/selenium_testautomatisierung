package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private final WebDriver webDriver;


    private final By usernameUsernameTextBox = By.id("username");
    private final By password = By.id("password");
    private final By selectButtonLogin = By.cssSelector("#login > button");

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;

    }


    public void setUsername(String username){
        webDriver.findElement(usernameUsernameTextBox).clear();
        webDriver.findElement(usernameUsernameTextBox).sendKeys(username);
    }

    public void setPassword(String passwordEingabe){
        webDriver.findElement(password).sendKeys(passwordEingabe);

    }

    public void pressButton(){
        webDriver.findElement(selectButtonLogin).click();
    }

}
