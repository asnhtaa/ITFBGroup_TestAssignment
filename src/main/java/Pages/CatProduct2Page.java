package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class CatProduct2Page {
        private WebDriver driver;
        private WebDriverWait wait;
        private By compareButton = By.cssSelector("[data-auto='compare-button']");
        private By profile = By.cssSelector("[data-zone-name='profile']");
        private By compareList =By.cssSelector("[data-auto='side-menu-item-comparison']");
        private By productName =By.cssSelector("[data-additional-zone='title']");

        public CatProduct2Page(WebDriver driver){
            this.driver =driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
        public void addToCompareList(){
            driver.findElement(compareButton).click();
        }

        public String getProduct2Name(){
            return driver.findElement(productName).getText();
        }
        public CompareListPage goToCompareList(){
            clickElement(profile);
            clickElement(compareList);
            return new CompareListPage(driver);
        }

        private void clickElement(By elementLocator) {
            wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            driver.findElement(elementLocator).click();
        }

    }
