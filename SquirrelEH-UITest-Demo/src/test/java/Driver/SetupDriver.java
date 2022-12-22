package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public void initDriver(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }
}
