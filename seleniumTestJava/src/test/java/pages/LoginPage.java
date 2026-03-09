package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    private By txtUserName=By.name("UserName");
    private By txtPassword=By.name("Password");
    private By btnLogin =By.cssSelector(".btn");

    public HomePage performLogin(String userName, String password){
        driver.findElement(txtUserName).sendKeys(userName);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }

}
