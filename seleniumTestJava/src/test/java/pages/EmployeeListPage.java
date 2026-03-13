package pages;
import extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeListPage {

    private WebDriver driver;

    public EmployeeListPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //Create New
    @FindBy(linkText = "+ New Employee")
    private WebElement btnCreateNew;

    //Grid with all the list of employee
    public CreateEmployeePage clickCreateNew(){
        UIElementExtensions.performClick(driver, btnCreateNew);
        return new CreateEmployeePage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Log off') or contains(text(),'Logoff') or contains(@href,'Logout')]")
    private WebElement lnkLogoff;

    public void clickLogoff() {
        // Check if we are even logged in first
        if (driver.getPageSource().contains("Log off")) {
            UIElementExtensions.performClick(driver, lnkLogoff);
        } else {
            System.out.println("Already logged out or session expired. Skipping Logoff.");
        }
    }

}
