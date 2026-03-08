package extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UIElementExtensions {
    public static void performEnterText(WebDriver driver, By locator, String value) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public static void performClick(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public static void performDropDownSelectionByText(WebDriver driver, By locator, String dropDownText){
        var select = new Select(driver.findElement(locator));
        select.selectByVisibleText(dropDownText);
    }

    public static void performDropDownSelectionByIndex(WebDriver driver, By locator, int index){
        var select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public static void performDropDownSelectionByValue(WebDriver driver, By locator, String dropDownValue){
        var select = new Select(driver.findElement(locator));
        select.selectByValue(dropDownValue);
    }
}