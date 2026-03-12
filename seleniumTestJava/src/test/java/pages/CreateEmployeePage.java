package pages;

import extensions.UIElementExtensions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEmployeePage {
    private WebDriver driver;

    public CreateEmployeePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    //using Findby...

    @FindBy(name="Name")
    private WebElement txtName;

    @FindBy(id = "DurationWorked")
    private WebElement txtDurationWorked;

    @FindBy(id = "Age")
    private WebElement txtAge;

    @FindBy(name = "Email")
    private WebElement txtEmail;


    @FindBy(name = "Salary")
    private WebElement txtSalary;

    @FindBy(name = "Grade")
    private WebElement ddlGrade;



//    @FindBy(css = ".btn")
//    private WebElement btnSubmit;

    @FindBy(xpath="//input[@value='Create']")
    WebElement btnSubmit;

//    private By txtName = By.name("Name");
//    private By txtDurationWorked = By.id("DurationWorked");
//    private By txtEmail = By.name("Email");
//    private By txtSalary = By.name("Salary");
//    private By ddlGrade = By.name("Grade");
//    private By btnCreate = By.cssSelector(".btn");

    public EmployeeListPage createNewEmployee(String name, String durationWorked, String age, String email, String salary, String grade){
        UIElementExtensions.performEnterText(txtName, name);
        UIElementExtensions.performEnterText(txtDurationWorked,durationWorked);
        UIElementExtensions.performEnterText(txtDurationWorked,age);
        UIElementExtensions.performEnterText(txtSalary,salary);
        UIElementExtensions.performEnterText(txtEmail,email);
        UIElementExtensions.performDropDownSelectionByText(ddlGrade,grade);
        UIElementExtensions.performClick(btnSubmit);
        return new EmployeeListPage(driver);
    }


}

