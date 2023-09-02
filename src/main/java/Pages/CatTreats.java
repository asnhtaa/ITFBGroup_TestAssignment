package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatTreats {
    private WebDriver driver;
    private WebDriverWait wait;
    private By minPriceLoc = By.xpath("//input[contains(@id, 'range-filter-field-glprice')]");
    private By maxPriceLoc = By.xpath("(//input[contains(@id, 'range-filter-field-glprice')])[2]");
    private By courierDelivery = By.cssSelector("[data-filter-value-id='offer-shipping_delivery']");
    private By showMoreManufacturer = By.xpath("//div[@data-baobab-name='showMoreFilters']");
    private By getManufacturerInput = By.xpath("//input[contains(@id,'textfield')]");
    private By firstListElement = By.xpath("//label[contains(@data-auto, 'filter-list-item')]");
    private By catProduct1 = By.cssSelector("[data-autotest-id='product-snippet']");
    private By catProduct2 = By.xpath("(//article[@data-autotest-id='product-snippet'])[2]");

    public CatTreats(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void set1ProductFilters(String minPrice, String maxPrice, String firstManufacturer) {
        setPriceInputValue(minPriceLoc, minPrice);
        setPriceInputValue(maxPriceLoc, maxPrice);
        retryingClick(courierDelivery);
        retryingClick(showMoreManufacturer);
        setInputValueManufacturer(firstManufacturer);
        retryingClick(firstListElement);
    }

    public CatProduct1Page selectCat1Product() {
        retryingClick(catProduct1);
        return new CatProduct1Page(driver);
    }

    public CatProduct2Page selectCat2Product() {
        retryingClick(firstListElement);
        driver.findElement(getManufacturerInput).clear();
        setInputValueManufacturer("Мнямс");
        retryingClick(firstListElement);
        retryingClick(catProduct2);
        return new CatProduct2Page(driver);
    }

    public void retryingClick(By elementLocator) {
        int maxAttempts = 3;

        for (int attempts = 0; attempts < maxAttempts; attempts++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).click();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
            }
        }
    }

    private void setPriceInputValue(By inputLocator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        driver.findElement(inputLocator).sendKeys(value);
    }

    private void setInputValueManufacturer(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getManufacturerInput));
        driver.findElement(getManufacturerInput).sendKeys(value);
    }
}
