package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class HomePage {
        private WebDriver driver;
        private WebDriverWait wait;
        private By catalogButton = By.xpath("//div[@data-zone-name='catalog']");
        private By petProducts = By.xpath("(//a[contains(@href,'tovary-dlia-zhivotnykh')])[2]");
        private By treats = By.xpath("//a[contains(@href,'lakomstva-dlia-koshek')]");
        private By petScale = By.xpath("//a[contains(@href, 'vesy-dlia-zhivotnykh')]");

        public HomePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        public void clickCatalog() {
            driver.findElement(catalogButton).click();
        }
        private void scrollToElement(By elementLocator) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", driver.findElement(elementLocator));
        }

        public String returnHomePageTitle(){
            String homePageTitle = driver.getTitle();
            return homePageTitle;
        }

        public CatTreats chooseTreats() {
            clickCatalog();
            wait.until(ExpectedConditions.visibilityOfElementLocated(petProducts));
            scrollToElement(petProducts);
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(petProducts)).perform();
            actions.moveToElement(driver.findElement(petScale)).perform();
            scrollToElement(treats);
            actions.moveToElement(driver.findElement(treats)).click().perform();
            return new CatTreats(driver);
        }
    }
