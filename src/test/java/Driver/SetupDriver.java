package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver {

    static WebDriver driver;

    public static WebDriver getDriver() {
//        if (driver.getWindowHandles().size()>1){
//            driver.close();
//            driver = driver.switchTo().newWindow(WindowType.WINDOW);
//        }
        return driver;
    }

    public void initDriver(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

    }
}
