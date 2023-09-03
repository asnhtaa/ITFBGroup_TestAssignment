package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CatProduct1Page {
    private WebDriver driver;
    private By compareButton = By.cssSelector("[data-auto='compare-button']");
    private By productName =By.cssSelector("[data-additional-zone='title']");
    public CatProduct1Page(WebDriver driver){
        this.driver =driver;
    }
    public void addToCompareList(){
        driver.findElement(compareButton).click();
        //ожидание, чтобы продукт добавился в список сравнения
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.close();
    }
    public String getProduct1Name(){
        return driver.findElement(productName).getText();
    }

}