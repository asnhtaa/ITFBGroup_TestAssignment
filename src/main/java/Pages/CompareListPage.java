package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class CompareListPage {
        private WebDriver driver;
        private By selectedProduct2 = By.xpath("//div[@class='zvRJM']");
        private By selectedProduct2Price = By.cssSelector("[data-auto='mainPrice']");
        private By selectedProduct1 = By.xpath("(//div[@class='zvRJM'])[2]");
        private By selectedProduct1Price = By.xpath("(//span[@data-auto='mainPrice'])[2]");
        private By product1DeleteButton = By.xpath("(//div[@aria-label='Удалить'])[2]");
        private By removeListButton = By.cssSelector("button._1KpjX._1KU3s");

        public CompareListPage(WebDriver driver){
            this.driver =driver;
        }
        public String checkSelectedProduct1(){
            return driver.findElement(selectedProduct1).getText();
        }
        public String checkSelectedProduct2(){
            return driver.findElement(selectedProduct2).getText();
        }
        public String checkSelectedProduct1Price(){
            return driver.findElement(selectedProduct1Price).getText();
        }
        public String checkSelectedProduct2Price(){
            return driver.findElement(selectedProduct2Price).getText();
        }

        // 1. Удалить товар производителя «Whiskas» из сравнения
        public void removeProduct1() {
                driver.findElement(product1DeleteButton).click();
        }

        // 2. Нажать на «Удалить список» (значок мусорного бака)
        public void clickRemoveList() {
            driver.findElement(removeListButton).click();
        }

        // Проверить, что товар производителя «Whiskas» не отображается
        public boolean isProduct1Displayed() {
            return !driver.findElement(selectedProduct1).isDisplayed();
        }

        // Проверить, что товары не отображаются
        public boolean areProductsDisplayed() {
            return !driver.findElement(selectedProduct1).isDisplayed() && !driver.findElement(selectedProduct2).isDisplayed();
        }
    }
