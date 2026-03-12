package gettingstarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestNGTest {

    private WebDriver driver;

    @BeforeTest
    public void RunBeforeTest(){
        driver = new ChromeDriver();
        driver.navigate().to("http://eaapp.somee.com");
    }

    @Test
    public void testBCreateEmployee(){
        //POM Code
        var homePage= new HomePage(driver);
        var loginPage = homePage.clickLogin();
        homePage=loginPage.performLogin("admin","password");
        var employeeListPage=homePage.clickEmployeeList();
        var createEmployeePage = employeeListPage.clickCreateNew();
        createEmployeePage.createNewEmployee("AutoUser2","200","25","autotestuser@gmail.com","100000","Middle");
        homePage.clickLogoff();
    }

    @AfterTest
    public void AfterTestExecution(){
        System.out.println("Quiting the Webdriver");
        driver.quit();
    }
}
