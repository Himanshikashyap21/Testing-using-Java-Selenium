package extensions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class UIElementExtensions {
    public static void performEnterText(WebElement locator, String value) {
        locator.click();
        locator.clear();
        locator.sendKeys(value);
    }

    public static void performClick(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(locator));

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", locator);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", locator);
    }

    public static void performDropDownSelectionByText(WebElement locator, String dropDownText) {
        var select = new Select(locator);
        select.selectByVisibleText(dropDownText);
    }

    public static void performDropDownSelectionByIndex(WebElement locator, int index) {
        var select = new Select(locator);
        select.selectByIndex(index);
    }

    public static void performDropDownSelectionByValue(WebElement locator, String dropDownValue) {
        var select = new Select(locator);
        select.selectByValue(dropDownValue);
    }
}