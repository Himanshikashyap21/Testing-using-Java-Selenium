package gettingstarted;

import extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;

import java.time.Duration;

public class SeleniumTest {
    public static void main(String[] args){

        //1. create a webdriver with a chromedriver object.....
        //2. launch the browser....
        WebDriver driver = new ChromeDriver();

        //navigate to a specific URL.....
        driver.navigate().to("http://eaapp.somee.com");

        HomePage homePage= new HomePage(driver);
        //Page navigation concept of Selenium......
        var loginPage = homePage.clicklogin();
        loginPage.performLogin("admin","password");


        //Login(driver);

        //create user....
        //CreateUser(driver);
        Logoff(driver);

        //set the screen as full screen.....
        //driver.manage().window().fullscreen();

        //minimize  the screen of browser....
        //driver.manage().window().minimize();

        //driver.close();

        //System.out.println("The URL on my browser:" + driver.getCurrentUrl());

        //get the current page source....
        //String pageSource = driver.getPageSource();

        //if(pageSource.contains("Bing helps you turn information into action")) {
            //System.out.println("True");
        //}else {
            //System.out.println("False");
        //}
        //System.out.println("My browser current handle: " + driver.getWindowHandles());

        //for(var handle: driver.getWindowHandles()){
            //System.out.println("My browser current handle: " + handle);
        //}


        //click the login link.....

        //1.identify the login link using its ID....
        //By lnkLogin = By.linkText("Login");
        //Alternate option....//By locator = By.linkText("Login");
        //alternate option....//By locator = By.id("loginLink");

        //2.pass this locator to webdriver which can help me do the operation on UI....
        //WebElement element= driver.findElement(lnkLogin);

        //3.perform operation on  the UI- click in my case...
        //element.click();

        //we can perform this 3 line code in one single line....we called this as refactor.....find the element using the by locator & clicking on that element using WebDriver...
        //click the login link.....
        //driver.findElement(By.linkText("Login")).click();

        //for username....
        //By txtUserName=By.name("UserName");
        //var txtUserNameElement= driver.findElement(txtUserName);
        //txtUserNameElement.sendKeys("admin");

        //alternate in one line.....
        //for username...
        //driver.findElement(By.name("UserName")).sendKeys("admin");

        //for password....
        //By Password =By.name("Password");
        //var PasswordElement = driver.findElement(Password);
        //PasswordElement.sendKeys("xyz@123");

        //alternate in one line...
        //for password...
        //driver.findElement(By.name("Password")).sendKeys("password");

        //for login button....
        //driver.findElement(By.cssSelector(".btn")).click();


        }

        public static void Login(WebDriver driver){

            //driver.findElement(By.linkText("Login")).click();//for login link
            UIElementExtensions.performClick(driver, By.linkText("Login"));//alternate option

            //Enter Username short version
            UIElementExtensions.performEnterText(driver,By.name("UserName"),"admin");
            //for username
            //driver.findElement(By.name("UserName")).click();
            //driver.findElement(By.name("UserName")).clear();
            //driver.findElement(By.name("UserName")).sendKeys("admin");

            //driver.findElement(By.name("Password")).sendKeys("password");//for password
            UIElementExtensions.performEnterText(driver,By.name("Password"),"password");//alternate for password

            //driver.findElement(By.cssSelector(".btn")).click();//for login or submit button
            UIElementExtensions.performClick(driver, By.cssSelector(".btn"));//alternate for submit or login button
        }

        public static void CreateUser(WebDriver driver){
            driver.findElement(By.linkText("\uD83D\uDC65 Employees")).click();
            driver.findElement(By.linkText("+ New Employee")).click();
            driver.findElement(By.name("Name")).sendKeys("AutoUser1");
            //driver.findElement(By.name("Salary")).sendKeys("40000");
            driver.findElement(By.id("DurationWorked")).sendKeys("40");

            //Select selectGrade = new Select(driver.findElement(By.id("Grade")));
            //selectGrade.selectByVisibleText("Middle");
            //Alternate fort above dropdown
            UIElementExtensions.performDropDownSelectionByIndex(driver, By.id("Grade"), 3);


            driver.findElement(By.name("Email")).sendKeys("AutoUser1@ea.com");
            driver.findElement(By.cssSelector(".btn")).click();

            //if the mandatory field error for salary appears, then enter the salary...
            if(driver.findElement(By.xpath("//span[text()+'The Salary field is required.']")).isDisplayed()){
                driver.findElement(By.name("Salary")).sendKeys("10000");
                UIElementExtensions.performDropDownSelectionByIndex(driver, By.id("Grade"), 3);
                driver.findElement(By.cssSelector(".btn")).click();
            }else{
                //do nothing
            }
        }

        public static void Logoff(WebDriver driver){
            driver.findElement(By.linkText("Logout")).click();
        }
    }

