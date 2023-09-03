package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CatTreats {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By minPriceLoc = By.xpath("//input[contains(@id, 'range-filter-field-glprice')]");
    private final By maxPriceLoc = By.xpath("(//input[contains(@id, 'range-filter-field-glprice')])[2]");
    private final By courierDelivery = By.cssSelector("[data-filter-value-id='offer-shipping_delivery']");
    private final By showMoreManufacturer = By.xpath("//div[@data-baobab-name='showMoreFilters']");
    private final By manufacturerInput = By.xpath("//input[contains(@id,'textfield')]");
    private final By firstListElement = By.xpath("//label[contains(@data-auto, 'filter-list-item')]");
    private final By catProduct1 = By.cssSelector("[data-autotest-id='product-snippet']");
    private final By catProduct2 = By.xpath("(//article[@data-autotest-id='product-snippet'])[2]");
    public CatTreats(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void setProductFilters(String minPrice, String maxPrice, String manufacturer) {
        setInputValue(minPriceLoc, minPrice);
        setInputValue(maxPriceLoc, maxPrice);
        retryingClick(courierDelivery);
        retryingClick(showMoreManufacturer);
        setInputValue(manufacturerInput, manufacturer);
        retryingClick(firstListElement);    }
    public CatProduct1Page selectCatProduct1() {
        clickWithWait(catProduct1);
        return new CatProduct1Page(driver);
    }
    public CatProduct2Page selectCatProduct2() {
        clearInput();
        setInputValue(manufacturerInput, "Мнямс");
        retryingClick(firstListElement);
        clickWithWait(catProduct2);
        return new CatProduct2Page(driver);
    }
    private void clearInput() {
        retryingClick(firstListElement);
        driver.findElement(manufacturerInput).clear();    }
    private void setInputValue(By inputLocator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLocator));
        WebElement inputElement = driver.findElement(inputLocator);
        inputElement.sendKeys(value);    }

    private void clickWithWait(By elementLocator) {
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
                scrollToElement(elementLocator);
                element.click();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                attempts++;
            }
        }
    }

    private void retryingClick(By elementLocator) {
        int maxAttempts = 3;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                scrollToElement(elementLocator);
                wait.until(ExpectedConditions.elementToBeClickable(elementLocator)).click();
                break;
            } catch
            (org.openqa.selenium.StaleElementReferenceException e) {
                attempts++;
            }        }
    }
    private void scrollToElement(By elementLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", driver.findElement(elementLocator));
    }}