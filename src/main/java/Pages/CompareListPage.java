package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class CompareListPage {
        private WebDriver driver;
        private By selectedProduct1 = By.xpath("//div[@class='zvRJM']");
        private By selectedProduct2 = By.xpath("(//div[@class='zvRJM'])[2]");

        public CompareListPage(WebDriver driver){
            this.driver =driver;
        }
        public String checkSelectedProduct1(){
            return driver.findElement(selectedProduct1).getText();
        }
        public String checkSelectedProduct2(){
            return driver.findElement(selectedProduct2).getText();
        }
    }
