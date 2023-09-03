package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompareListPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By selectedProduct2 = By.xpath("//div[@class='zvRJM']");
    private By selectedProduct2Price = By.cssSelector("[data-auto='mainPrice']");
    private By selectedProduct1 = By.xpath("(//div[@class='zvRJM'])[2]");
    private By selectedProduct1Price = By.xpath("(//span[@data-auto='mainPrice'])[2]");
    private By product1DeleteButton = By.xpath("(//div[@role='button'])[6]");
    private By removeListButton = By.cssSelector("button._1KpjX._1KU3s");

    public CompareListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String checkSelectedProduct1() {
        return driver.findElement(selectedProduct1).getText();
    }

    public String checkSelectedProduct2() {
        return driver.findElement(selectedProduct2).getText();
    }

    public Integer checkSelectedProduct1Price() {
        String cleanPriceString = driver.findElement(selectedProduct1Price).getText().replaceAll("[^0-9]", "");
        return Integer.valueOf(cleanPriceString);
    }

    public Integer checkSelectedProduct2Price() {
        String cleanPriceString = driver.findElement(selectedProduct2Price).getText().replaceAll("[^0-9]", "");
        return Integer.valueOf(cleanPriceString);
    }

    public void removeProduct1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(selectedProduct1), 10, 10).click(driver.findElement(product1DeleteButton)).build().perform();

        driver.findElement(product1DeleteButton).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(selectedProduct1)));
    }

    public void clickRemoveList() {
        driver.findElement(removeListButton).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(selectedProduct2)));
    }

    public boolean isProduct1Displayed() {
        try {
            WebElement element = driver.findElement(selectedProduct1);
            return !element.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }


    public boolean areProductsDisplayed() {
        try {
            driver.findElement(selectedProduct1);
            driver.findElement(selectedProduct2);
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }
}

