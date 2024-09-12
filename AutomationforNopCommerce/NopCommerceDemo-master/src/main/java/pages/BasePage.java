package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {this.driver = driver;}
    protected static void ClickBtn(String linkTest) {
        driver.findElement(By.linkText(linkTest)).click();}
    protected static void SetText(By by, String textValue) {
        driver.findElement(by).sendKeys(textValue);}
    public static void ScrollToBtn(String scroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(scroll);}
    public static void WaitTime(By by){
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(by));}
}