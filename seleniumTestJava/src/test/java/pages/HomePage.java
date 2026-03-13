package pages;

import extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators for login
    @FindBy(linkText = "Login")
    private WebElement lnkLogin;

    @FindBy(partialLinkText = "Log off")
    private WebElement lnkLogoff;

    //Locators for Employee list
    @FindBy(linkText = "\uD83D\uDC65 Employees")
    private WebElement lnkEmployeeList;

    public LoginPage clickLogin(){
        UIElementExtensions.performClick(driver, lnkLogin);
        return new LoginPage(driver);
    }

    public EmployeeListPage clickEmployeeList() {
        UIElementExtensions.performClick(driver, lnkEmployeeList);
        return new EmployeeListPage(driver);
    }

    public void clickLogoff() {
        UIElementExtensions.performClick(driver, lnkLogoff);
    }
}

