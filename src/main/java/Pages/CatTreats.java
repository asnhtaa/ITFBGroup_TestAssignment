package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class CatTreats {
        private WebDriver driver;
        private WebDriverWait wait;
        private By minPriceLoc = By.cssSelector("[data-auto='filter-range-min']");
        private By maxPriceLoc = By.cssSelector("[data-auto='filter-range-max']");
        private By courierDelivery = By.cssSelector("[data-filter-value-id='offer-shipping_delivery']");
        private By showMoreManufacturer = By.xpath("(//div[@data-baobab-name='showMoreFilters']");
        private By getManufacturerInput = By.cssSelector("[data-zone-name='filterSearchValueField']");
        private By firstListElement= By.xpath("//label[contains(@data-auto, 'filter-list-item')]");
        private By catProduct1 = By.xpath("[data-autotest-id='product-snippet']");
        private By catProduct2= By.xpath("(//article[@data-autotest-id='product-snippet'])[2]");
        public CatTreats(WebDriver driver){
            this.driver =driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        public void set1ProductFilters(String minPrice, String maxPrice, String firstManufacturer) {
            setPriceInputValue(minPriceLoc, minPrice);
            setPriceInputValue(maxPriceLoc, maxPrice);
            clickElement(courierDelivery);
            clickElement(showMoreManufacturer);
            setInputValueManufacturer(firstManufacturer);
            clickElement(firstListElement);
        }

        public CatProduct1Page selectCat1Product() {
            clickElement(catProduct1);
            return new CatProduct1Page(driver);
        }

        public CatProduct2Page selectCat2Product() {
            clear1Input();
            setInputValueManufacturer("Мнямс");
            clickElement(firstListElement);
            clickElement(catProduct2);
            return new CatProduct2Page(driver);
        }

        public void clear1Input() {
            clickElement(firstListElement);
            driver.findElement(getManufacturerInput).clear();
        }

        private void clickElement(By elementLocator) {
            wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            driver.findElement(elementLocator).click();
        }

        private void setPriceInputValue(By inputLocator, String value) {
            wait.until(ExpectedConditions.presenceOfElementLocated(inputLocator));
            driver.findElement(inputLocator).sendKeys(value);
        }

        private void setInputValueManufacturer(String value) {
            wait.until(ExpectedConditions.presenceOfElementLocated(getManufacturerInput));
            driver.findElement(getManufacturerInput).sendKeys(value);
            wait.until(ExpectedConditions.presenceOfElementLocated(firstListElement));
        }
    }
