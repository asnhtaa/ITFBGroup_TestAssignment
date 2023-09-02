package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatProduct2Page {
    private WebDriver driver;
    private WebDriverWait wait;
    private By compareButton = By.cssSelector("[data-baobab-name='comparison']");
    private By productName = By.cssSelector("[data-additional-zone='title']");
    private By compareLink = By.cssSelector("a[href='/my/compare-lists']");

    public CatProduct2Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void addToCompareList() {
        clickElement(compareButton);
    }

    public String getProduct2Name() {
        return driver.findElement(productName).getText();
    }

    public CompareListPage goToCompareList() {
        clickElement(compareLink);
        return new CompareListPage(driver);
    }

    private void clickElement(By elementLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        driver.findElement(elementLocator).click();
    }
}
