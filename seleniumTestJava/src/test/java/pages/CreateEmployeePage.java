package pages;

import extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateEmployeePage {
    private WebDriver driver;

    public CreateEmployeePage(WebDriver driver){
        this.driver=driver;
    }


    private By txtName = By.name("Name");
    private By txtDurationWorked = By.id("DurationWorked");
    private By txtEmail = By.name("Email");
    private By txtSalary = By.name("Salary");
    private By ddlGrade = By.name("Grade");
    private By btnCreate = By.cssSelector(".btn");

    public EmployeeListPage createNewEmployee(String name, String durationWorked, String email, String salary, String grade){
        UIElementExtensions.performEnterText(driver,txtName,name);
        UIElementExtensions.performEnterText(driver,txtDurationWorked,durationWorked);
        UIElementExtensions.performEnterText(driver,txtSalary,salary);
        UIElementExtensions.performEnterText(driver,txtEmail,email);
        UIElementExtensions.performDropDownSelectionByText(driver,ddlGrade,grade);
        UIElementExtensions.performClick(driver,btnCreate);
        return new EmployeeListPage(driver);
    }


}

