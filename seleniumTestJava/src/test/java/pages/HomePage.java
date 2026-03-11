package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Locators for login
    private By lnkLogin= By.linkText("Login");

    //Locators for Employee list
    private By lnkEmployeeList = By.linkText("\uD83D\uDC65 Employees");

    public LoginPage clicklogin(){
        driver.findElement(lnkLogin).click();
        return new LoginPage(driver);
    }

    public EmployeeListPage clickEmployeeList() {
        driver.findElement(lnkEmployeeList).click();
        return new EmployeeListPage(driver);}
    }

