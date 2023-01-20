package Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class HandleDriver {
    static WebDriver driver;

    @Before
    public static void setup(){
        System.out.println("------------------------?");
        SetupDriver setupDriver = new SetupDriver();
        setupDriver.initDriver();
        driver = SetupDriver.getDriver();
    }
    @After
    public static void testTearDown(){
        driver.quit();
    }
}
