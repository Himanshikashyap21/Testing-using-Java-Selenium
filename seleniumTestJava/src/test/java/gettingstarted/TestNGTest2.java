package gettingstarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestNGTest2 {

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
        homePage = loginPage.performLogin("admin","password");

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

    @AfterTest
    public void AfterTestExecution() {
        System.out.println("Quiting the Webdriver");
        driver.quit();
    }
}
