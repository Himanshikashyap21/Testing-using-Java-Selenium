package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {

    private WebDriver driver;

    public EmployeeListPage(WebDriver driver){
        this.driver=driver;
    }
    //Create New
    private By btnCreateNew = By.linkText("+ New Employee");

    //Grid with all the list of employee
    public CreateEmployeePage clickCreateNew(){
        driver.findElement(btnCreateNew).click();
        return new CreateEmployeePage(driver);
    }


}
