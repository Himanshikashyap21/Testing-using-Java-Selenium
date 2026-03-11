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

    //Locators for Employee list
    @FindBy(linkText = "\uD83D\uDC65 Employees")
    private WebElement lnkEmployeeList;

    public LoginPage clicklogin(){
        lnkLogin.click();
        return new LoginPage(driver);
    }

    public EmployeeListPage clickEmployeeList() {
        lnkEmployeeList.click();
        return new EmployeeListPage(driver);}
    }

