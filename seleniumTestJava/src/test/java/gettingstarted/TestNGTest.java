package gettingstarted;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest {

    @BeforeTest
    public void RunBeforeTest(){
        System.out.println("Execution before every single test...");
    }

    @Test
    public void testLogin(){
        System.out.println("Testing the login operation");
    }

    @Test
    public void testCreateUser(){
        System.out.println("Testing the Create User operation");
    }

    @Test
    public void testLogoff(){
        System.out.println("Testing the log off operation");
    }

    @Test
    public void testSettings(){
        System.out.println("Testing the settings operation");
    }

    @AfterTest
    public void AfterTestExecution(){
        System.out.println("Executing after Test Execution...");
    }
}
