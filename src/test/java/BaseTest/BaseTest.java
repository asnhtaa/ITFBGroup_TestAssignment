package BaseTest;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import Utils.WindowManager;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    protected Pages.HomePage HomePage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(getEdgeOptions());
        driver.manage().window().maximize();
        driver.get("https://market.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        HomePage = new HomePage(driver);
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }
}
