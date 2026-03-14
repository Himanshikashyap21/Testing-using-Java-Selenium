package gettingstarted;

import model.CreateEmployee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;

public class TestNGTest {

    private WebDriver driver;

    @BeforeTest
    public void RunBeforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com");
    }



    @Parameters({"UserName" , "Password"})
    @Test
    public void testBCreateEmployee(String userName, String password){
        var homePage = new HomePage(driver);
        var loginPage = homePage.clickLogin();
        homePage = loginPage.performLogin(userName,password);

        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.clickCreateNew();

        // After this finishes, you are likely on a page WITHOUT the 'Log off' link
        employeeListPage = createEmployeePage.createNewEmployee(
                "AutoUser2","200","25","autotestuser@gmail.com","100000","Middle");

        // --- ADD THIS LINE ---
        driver.navigate().to("http://eaapp.somee.com");
        // ---------------------
        System.out.println("DEBUG: Current URL is " + driver.getCurrentUrl());
        System.out.println("DEBUG: Page Source contains 'Log off': " + driver.getPageSource().contains("Log off"));
        employeeListPage.clickLogoff();
    }




    @Test(dataProvider = "CreateEmployee")
    public void testWithDataProvider(String name, String durationWorked, String age, String email, String salary, String grade){
        var homePage = new HomePage(driver);
        var loginPage = homePage.clickLogin();
        homePage = loginPage.performLogin("admin","password");

        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.clickCreateNew();

        // After this finishes, you are likely on a page WITHOUT the 'Log off' link
        employeeListPage = createEmployeePage.createNewEmployee(name, durationWorked, age, email, salary, grade);

        // --- ADD THIS LINE ---
        driver.navigate().to("http://eaapp.somee.com");
        // ---------------------
        System.out.println("DEBUG: Current URL is " + driver.getCurrentUrl());
        System.out.println("DEBUG: Page Source contains 'Log off': " + driver.getPageSource().contains("Log off"));
        employeeListPage.clickLogoff();
    }



    @Test(dataProvider = "CreateEmployeeWithCustomData")
    public void testWithDataProviderWithCustomType(CreateEmployee createEmployee){
        var homePage = new HomePage(driver);
        var loginPage = homePage.clickLogin();
        homePage = loginPage.performLogin("admin","password");

        var employeeListPage = homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.clickCreateNew();

        // After this finishes, you are likely on a page WITHOUT the 'Log off' link
        employeeListPage = createEmployeePage.createNewEmployee(createEmployee.getName(), createEmployee.getDurationWorked(), createEmployee.getAge(), createEmployee.getEmail(), createEmployee.getSalary(), createEmployee.getGrade());

        // --- ADD THIS LINE ---
        driver.navigate().to("http://eaapp.somee.com");
        // ---------------------
        System.out.println("DEBUG: Current URL is " + driver.getCurrentUrl());
        System.out.println("DEBUG: Page Source contains 'Log off': " + driver.getPageSource().contains("Log off"));
        employeeListPage.clickLogoff();
    }



    @DataProvider(name = "CreateEmployeeWithCustomData")
    public static CreateEmployee[] createEmployeeDataWithCustomType(){
        return new CreateEmployee[]  {
                new CreateEmployee("FromCustomData", "9999","28", "FromCustomData@gmail.com", "40000", "Middle"){
                }
        };
    }



    @AfterTest
    public void AfterTestExecution() {
        System.out.println("Quiting the Webdriver");
        driver.quit();
    }
}
